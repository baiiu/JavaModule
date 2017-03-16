讨论枚举和注解的最佳实践。

## 30. 用enum代替int常量
枚举类型(enum type)是指由一组固定的常量组成合法值得类型，在编程语言还没有引入枚举之前，表示枚举类型的常用模式是声明一组具名的int常量，称作**int枚举模式**。

- int枚举模式的不足
  1. 它在类型安全性和使用方便性方法没有任何帮助
  2. 采用int枚举模式的程序是十分脆弱的。因为int枚举是编译时常量，被编译到使用它们的客户端中，如果int值发生变化，则客户端就必须重新编译。如果不编译，则它们的行为就是不确定的。
  3. 打印出int枚举常量的字符串，并没有很便利的方法。要便利一个组中所有的int枚举常量、获取int枚举组大小等这些都没有很可靠的方法。

- String枚举模式
int枚举模式的变体，同样也有很大的不足。虽然它提供了可打印的字符串，但是它会导致性能问题，因为它依赖于字符串的比较操作；

- 枚举enum，Java的枚举本质上是int
它们就是通过公有的静态final域为每个枚举常量导出实例的类，因为没有可访问的构造器，枚举类型是真正的final；不能实例化，只能访问已声明过的枚举常量。
即枚举类型是实例受控的，它们是单例的泛型化，本质上式单元素的枚举。
  - 包含同名常量的多个枚举类型可以在同一个系统中和平共处，因为每个类型都有自己的命名空间(在不同的类下)。
  - 可以增加或重排枚举类型中的常量，而无需重新编译它的客户端代码，因为导出的常量域在枚举类型和它的客户端之间提供了一个隔离层：常量值并没有被编译到客户端代码中，而是在int枚举模式之中。
  - 可以调用toString()方法将枚举转换成可打印的字符串。
  - 可以添加任意的方法和域，并可以实现任意的接口。
  - 可以遍历

- 与枚举常量关联的有些行为，可能只需要用在定义了枚举的类或者包中。这种行为最好被实现成私有的或者包级私有的方法。

- 如果一个枚举具有普遍适用性，就应该成为一个顶层类；如果它只是用在一个特定的顶层类中，它应该被作为该顶层类的一个成员类。
例如：java.math.RoundingMode枚举类。

- 有时候需要在不同的枚举类型上表现本质不同的行为，采用如下这种方法：在枚举类型中声明一个抽象方法，并在**特定常量的类主体(constant-specific class body)**中实现该抽象方法。
这种方法被称作**特定于常量的方法实现(constant-specific method implementation)**。
```
public enum Operation {
    PLUS {
        @Override double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);
}
```

- 特定于常量的方法实现有一个美中不足的地方，它们使得在枚举常量中共享代码变得困难。
可以增加抽象方法、调用不同的辅助方法，但这样会产生大量的样板代码，降低可读性。
可以使用**策略枚举(strategy enum)**，即嵌套一个私有枚举，把大量计算放在其中，外部将调用该嵌套枚举常量来委托计算。虽然这种模式没有switch语句那么简洁，但更加安全、灵活。

- 枚举的性能缺点：
装载和初始化枚举时会有空间和时间的成本。

总之，与int常量相比，枚举类型有很大优势，要易读、更安全、功能更强大。善用枚举，另外如果多个枚举常量同时共享相同的行为时，考虑使用策略枚举。

## 31. 用实例域代替序数
可以使用枚举的`ordinal`方法获取到该枚举常量在枚举中的排列位置，但依赖该方法的话维护就会很麻烦；比如添加一个枚举或重排，就会导致该位置发生变化。
所以永远不要根据枚举的序数导出与它关联的值，而是使用枚举值的成员变量来保存，通过构造方法传入。
最好完全避免使用`ordinal`方法，它是设计成用在EnumSet、EnumMap这种基于枚举的通用数据结构的。

## 32. 用EnumSet代替位域
```
/*
    使用int常量进行位运算，位域
*/
public class Text {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 2;
    public static final int STYLE_UNDERLINE = 1 << 3;

    public void applyStyles(int styles) {
    }

    //text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
}

/*
  使用EnumSet代替位域
*/
public class TextEnumSetStyle {
    public enum Style {
        BOLD, ITALIC, UNDERLINE;
    }

    public void applyStyles(Set<Style> styles) { //使用接口接收，说不定传其他的Set实现
    }

    //text.applyStyles(EnumSet.of(Style.BOLD,Style.ITALIC));
}
```
- 位域有着int枚举常量的所有缺点，不能打印、不能遍历等

- EnumSet实现了Set接口，提供了丰富的功能和类型安全性，以及可以从其他任何Set实现中得到的互用性。
在内部实现上，每个EnumSet内容都表示为矢量；如果枚举类型<=64个，整个EnumSet就是用单个long来表示，所以性能比得上位域。

EnumSet类集位域的简洁和性能优势、及枚举类型的所有优点于一身，但枚举本身是消耗性能的，使用时考虑考虑。

## 33. 使用EnumMap代替序数索引




























<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
