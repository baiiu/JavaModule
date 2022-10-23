package com.example.IteratorPattern.sample01;

import java.util.List;

/**
 * auther: baiiu
 * time: 18/12/19 19 07:28
 * description:
 */
class ProductList extends AbstractObjectList {
    ProductList(List<Object> products) {
        super(products);
    }

    //实现创建迭代器对象的具体工厂方法
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }

    private class ProductIterator implements AbstractIterator {
        private int cursor1; //定义一个游标，用于记录正向遍历的位置
        private int cursor2; //定义一个游标，用于记录逆向遍历的位置

        ProductIterator(ProductList list) {
            cursor1 = 0; //设置正向遍历游标的初始值
            cursor2 = getList().size() - 1; //设置逆向遍历游标的初始值
        }

        public Object next() {
            Object o = getList().get(cursor1);

            if (cursor1 < getList().size()) {
                cursor1++;
            }

            return o;
        }

        public boolean isLast() {
            return (cursor1 == getList().size());
        }

        public Object previous() {
            Object o = getList().get(cursor2);
            cursor2--;
            return o;
        }

        public boolean isFirst() {
            return (cursor2 == -1);
        }

        public Object getNextItem() {
            return getList().get(cursor1);
        }

        public Object getPreviousItem() {
            return getList().get(cursor2);
        }
    }
}
