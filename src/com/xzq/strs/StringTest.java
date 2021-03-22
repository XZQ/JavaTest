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
    class TreeNode {
        int val;
        TreeNode left, right;
    }


    static StringBuffer removeHelper(StringBuffer sb) {
        for (int i = 0; i + 1 < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                return removeHelper(sb);
            }
        }
        return sb;
    }

    class Solution {

        int max_sum = Integer.MIN_VALUE;

        public int max_gain(TreeNode node) {

            if (node == null) {
                return 0;
            }

            int left_gain = Math.max(max_gain(node.left), 0);

            int right_gain = Math.max(max_gain(node.right), 0);

            max_sum = Math.max(max_sum, node.val + left_gain + right_gain);

            return node.val + Math.max(left_gain, right_gain);
        }

        public int maxPathSum(TreeNode root) {
            max_gain(root);
            return max_sum;
        }
    }

}