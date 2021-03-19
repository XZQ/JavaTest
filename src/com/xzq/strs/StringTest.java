package com.xzq.strs;

public class StringTest {
    public static void main(String[] args) {


//        System.out.println(removeHelper(new StringBuilder("abcdessed")));


        StringBuilder sb = new StringBuilder("abcdessed");

        sb.delete(0, 2);


        System.out.println(sb);
    }


//    public static String removeDuplicates(String S) {
//        int index = -1;
//        char[] chars = S.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (index >= 0 && chars[index] == chars[i]) {
//                index--;
//            } else {
//                index++;
//                chars[index] = chars[i];
//            }
//        }
//        return String.copyValueOf(chars, 0, index + 1);
//    }


    static StringBuffer removeHelper(StringBuffer sb) {
        for (int i = 0; i + 1 < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                return removeHelper(sb);
            }
        }
        return sb;
    }
}