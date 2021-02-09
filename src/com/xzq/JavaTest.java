package com.xzq;

import java.util.concurrent.Executors;

public class JavaTest {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
//            if (i % 5 != 0) {
//                System.out.println("=" + (i % 5));
//            }
            System.out.println("=" + (i % 4) + "    =" + (i / 5));

            Executors.newSingleThreadExecutor();

        }
    }
}
