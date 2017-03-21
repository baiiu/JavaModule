package com.example.charpter7;

import com.sun.istack.internal.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author: baiiu
 * date: on 17/3/18 11:11
 * description:
 */

public class TestFunction {

    /**
     * @throws NullPointerException if params is null
     */
    private static void testOne(String s) {
        if (s == null) {
            throw new NullPointerException("params s can not be null");
        }
        System.out.print(s.toCharArray());
    }

    private static void min(@NotNull int... arg) {
        if (arg.length == 0) {
            return;
        }

        for (int i : arg) {
            System.out.print(i);
        }

    }


    public static void main(String[] args) {
        //testOne(null);
        min(1, 2, 3);
        //min(null);
        List<Integer> integers = Arrays.asList(1, 2);
        //List<Integer> integers1 = Arrays.asList(new int[]{1,2});
        System.out.println(Arrays.toString(new int[]{1,2}));

        Collections.emptyList();

    }


}
