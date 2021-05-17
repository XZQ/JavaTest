package com.xzq.pattera;

import java.util.ArrayList;
import java.util.List;

public class MyClas<T> {
    private T t;

//    private static T t1;/

    private T fun0(T t) {
        return t;
    }

    private static <T> T func1(T t) {
        return t;
    }

    private static <T> T func2(T t) {
        return t;
    }

    <T> void fun(T t) {

    }

    public static void main(String[] args) {
        List<? extends Number> list1;
        List<Integer> list2 = new ArrayList<Integer>();
        list1 = list2;
        list2.add(1);
    }

}
