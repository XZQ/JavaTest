package com.xzq.listnode;

import com.xzq.listnode.ListNode;

public class ListNodeMain {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;

//        ListNode cur = listNode1;
//        while (cur != null) {
//            System.out.println(cur.obj);
//            cur = cur.next;
//        }



        removeNodeFromEnd(listNode1, 2);

    }

    /**
     * @param listNode
     * @param n
     * @return https://blog.csdn.net/weixin_39043567/article/details/89813993
     * https://blog.csdn.net/qq_41318400/article/details/107651335?utm_medium=distribute.pc_relevant.none-task-blog-OPENSEARCH-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-OPENSEARCH-1.control
     * https://blog.csdn.net/qq_41318400/article/details/107651731
     * https://docs.qq.com/doc/DYWZtdWZGanN1eGd0
     */
    public static ListNode removeNodeFromEnd(ListNode listNode, int n) {
        if (listNode == null || n <= 0) {
            return null;
        }
//        ListNode derlt = new ListNode(0);
//        derlt.next = listNode;

        listNode.obj = 00;
        //
        ListNode p = listNode;
        ListNode q = listNode;


        int i = 1;
        while (q.next != null) {
            i++;
            //
            if (i <= n) {
                q = q.next;
            } else {
                q = q.next;
                p = p.next;
            }
        }

        if (listNode.next == null || i + 1 == n) {
            listNode = listNode.next;
        } else {
            p.next = p.next.next;
        }
        return null;
    }
}
