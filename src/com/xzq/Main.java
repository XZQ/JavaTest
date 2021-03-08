package com.xzq;

public class Main {


    public static void main(String[] args) {

        Integer i = Integer.valueOf(100);
        Integer j = Integer.valueOf(100);


        Integer i1 = Integer.valueOf(200);
        Integer j1 = Integer.valueOf(200);


        System.out.println(i == j);
        System.out.println(i1 == j1);

        System.out.println(i.equals(j));
        System.out.println(i1.equals(j));


        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
