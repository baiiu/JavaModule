package com.example.chapter6;

import java.util.Set;

/**
 * auther: baiiu
 * time: 17/3/16 16 08:06
 * description:
 */

public class TextEnumSetStyle {
    public enum Style {
        BOLD, ITALIC, UNDERLINE;
    }

    public void applyStyles(Set<Style> styles) {
    }

    //text.applyStyles(EnumSet.of(Style.BOLD,Style.ITALIC));
}
