package com.xzq.strs;

import java.util.Stack;

public class StringTest {
    public static void main(String[] args) {
//        System.out.println(removeHelper(new StringBuilder("abcdessed")));
//        StringBuilder sb = new StringBuilder("abcdessed");
//        sb.delete(0, 2);
//        System.out.println(sb);
//        System.out.println(isPalindrome(1121));

//        System.out.println(isValid("()[]"));
//        System.out.println(climbStairs(4));

//        System.out.println(fibonacci(4));
//        System.out.println(fibonacci2(4));

//        for (int i = 0; i < 10; i++) {
////            System.out.println("i=" + i + "  " + (i & 1));
//            System.out.println("i=" + i + "  " + (i & i) + "  " + (i & 1) + "  " + (i & 0));
//            System.out.println();
//        }
//        numberOf1(5000);
        System.out.println(power(20, 2));
    }

    public static double power(double d, int expect) {
        double result = 1.0;
        for (int i = 1; i <= expect; i++) {
            result = result * d;
        }
        return result;
    }

    public static void numberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        System.out.println("count=" + count);
    }

    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }


    public static long fibonacci2(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        long one = 1;
        long two = 1;
        long sum = 0L;
        for (int i = 2; i < n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }


    //    https://leetcode-cn.com/problems/valid-parentheses/
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty() || (s.length() % 2 != 0)) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        } else if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x * x, n / 2);
        }
    }


    // 二维数组的查找
    // https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (target == num) {
                return true;
            } else if (target > num) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    // https://leetcode-cn.com/problems/palindrome-number/ 回文数
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = x % 10 + revertedNumber * 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertNumber || x == revertNumber / 10;
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