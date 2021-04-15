package com.xzq.array;

import java.util.*;

// 数组求交集
public class ArrayUnion {

    public static void main(String[] args) {

        int[] ints = new int[]{0, 1, 2, 2, 3};
//        rotate1(ints, 3);
        System.out.println(singleNumber(ints));

//
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + " " + (i / 2) + "   ");
//        }
//        System.out.println();
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + " " + (i % 2) + "   ");
//        }
    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strAtr = new String[nums.length];
        for (int i = 0; i < strAtr.length; i++) {
            strAtr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strAtr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String aStrArr : strAtr) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        if ('0' == result.charAt(0)) {
            result = "0";
        }
        return result;

    }


    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;

        //每次往后移一位，移动k次
        for (int i = 0; i < k; i++) {
            int fir = nums[nums.length - 1];
            //从倒数第二个元素开始移动
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            //每次的第一个元素都是移动前的最后一个
            nums[0] = fir;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "   ");
        }
    }


    public void rotate(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }


    public static int singleNumber(int nums[]) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }


    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }


    //    买卖股票的最佳时机
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }


    //删除排序数组中的重复项
    public static int removeDuplicates11(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums.length;
        }

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (String str : strs) {
            while (!str.contains(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }

        return s;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int length = 0;

        HashSet<Character> hashSet = new HashSet<>();
        while (right < s.length()) {
            if (hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left--));
            } else {
                hashSet.add(s.charAt(right++));
            }
            length = hashSet.size() > length ? hashSet.size() : length;
        }
        return length;
    }


    public static int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
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
