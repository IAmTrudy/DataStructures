package com.lxp;

import java.nio.charset.StandardCharsets;

public class TestAll {
    public static void main(String[] args) {
        String s = "我们";
        byte[] bytes = s.getBytes();
        for (Byte aByte : bytes) {
            System.out.println(aByte);
        }
        System.out.println(new String(bytes));
        String s1 = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s1);
    }
}
