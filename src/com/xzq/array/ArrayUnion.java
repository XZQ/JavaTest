package com.xzq.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 数组求交集
public class ArrayUnion {

    public static void main(String[] args) {
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//        hashMap.put("a", "1");
//        hashMap.put("a", "2");
//        hashMap.put("a", "3");
//        hashMap.put("", "4");
//        hashMap.put(null, "5");
//
//        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }


//        System.out.println(myPod(2, 15));

//        for (int i = 0; i < 10; i++) {
//            System.out.println((i / 2) + "  " + (i % 2));
//        }

        int[] ints = new int[]{1, 1, 2, 35};

        System.out.println(removeDuplicates(ints));
    }


    //    26. 删除有序数组中的重复项
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }
        return i + 1;
    }

    public static int myPod(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        int half = myPod(x, n / 2);
        int reset = myPod(x, n % 2);
        System.out.println("41  ==  " + half + "   " + reset);
        return reset * half * half;
    }


    public static int maxProfit() {
        int[] ints = {7, 1, 5, 3, 6, 4};
        if (ints.length <= 1) {
            return 0;
        }
        int min = ints[0];
        int max = 0;

        for (int i = 1; i < ints.length; i++) {
            min = Math.min(min, ints[i - 1]);
            max = Math.max(max, ints[i] - min);
        }

        return max;

    }
}
