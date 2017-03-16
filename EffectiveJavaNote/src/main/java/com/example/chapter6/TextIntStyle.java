package com.example.chapter6;

/**
 * auther: baiiu
 * time: 17/3/16 16 08:04
 * description:
 */

public class TextIntStyle {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 2;
    public static final int STYLE_UNDERLINE = 1 << 3;

    public void applyStyles(int styles) {
    }

    //text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
}
