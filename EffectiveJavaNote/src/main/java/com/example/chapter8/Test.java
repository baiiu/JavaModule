package com.example.chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * auther: baiiu
 * time: 17/3/19 19 11:27
 * description:
 */

public class Test {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Li", true));
        list.add(new Animal("Zhang", false));
        list.add(new Animal("Sun", true));

        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");

        for (String string : strings) {
            for (Animal animal : list) {
                System.out.println(string + ", " + animal);
            }
        }

        System.out.println("========================");

        for (Iterator<String> stringIterator = strings.iterator(); stringIterator.hasNext(); ) {
            String next = stringIterator.next();
            for (Iterator<Animal> iterator = list.iterator(); iterator.hasNext(); ) {
                System.out.println(next + ", " + iterator.next());
            }
        }

    }
}
