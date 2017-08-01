package com.example;

/**
 * auther: baiiu
 * time: 17/8/2 02 06:27
 * description:
 */
class HexString {

    static String bytesToHexString(String str) {
        if (str == null || str.length() == 0) return "";

        byte[] b = str.getBytes();

        if (b.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < b.length; i++) {
            int value = b[i] & 0xFF;
            String hv = Integer.toHexString(value);
            if (hv.length() < 2) {
                sb.append(0);
            }

            sb.append(hv);
        }
        return sb.toString();
    }

    static String hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return "";
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }

        return new String(d);
    }

    static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}
