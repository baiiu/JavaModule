package com.example;

/**
 * auther: baiiu
 * time: 17/8/1 01 22:51
 * description: Unicode 编解码
 */
class Unicode {


    static String toUnicode(String str) {
        char[] arChar = str.toCharArray();
        int iValue = 0;
        StringBuilder uStr = new StringBuilder();
        for (int i = 0; i < arChar.length; i++) {
            iValue = (int) str.charAt(i);
            uStr.append("&#").append(iValue).append(";");
        }
        return uStr.toString();
    }

    static String decodeUnicode(String str) {
        String[] strings = str.split(";");
        StringBuilder aStr = new StringBuilder();
        for (String string : strings) {
            String s = string.replace("&#", "");
            aStr.append((char) Integer.parseInt(s));
        }
        return aStr.toString();
    }


}
