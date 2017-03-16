package com.example.chapter6;

import java.util.EnumMap;
import java.util.Map;

/**
 * author: baiiu
 * date: on 17/3/16 10:10
 * description:
 */
public class EnumMapTest {

    public enum Type {ONE, TWO, THREE}

    Map<Type, String> map = new EnumMap<Type, String>(Type.class);

    private void a() {
        map.put(Type.ONE, "one");
    }
}
