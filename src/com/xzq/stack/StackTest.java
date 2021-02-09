package com.xzq.stack;

import java.util.Stack;

/**
 * 剑指offer：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 */
public class StackTest {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};

        IsPopOrder(pushA, popA);
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;//用于标识弹出序列位置

        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
