package com.example.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * auther: baiiu
 * time: 17/3/15 15 21:58
 * description:
 */

public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (instance == null) {
            return;
        }

        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

}
