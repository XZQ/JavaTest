package com.xzq.listnode;

import java.util.LinkedList;

public class ListReverse {


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


        double d = 44.4 + 21.6 + 3.12;


        System.out.println("   " + removeNthFromEnd(listNode1, 2));
    }


    //83. 删除排序链表中的重复元素
//    https://lyl0724.github.io/2020/01/25/1/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }
//    https://lyl0724.github.io/2020/01/25/1/
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (pre.val == next.val) {
                pre.next = next.next;
                next = next.next;
            } else {
                pre = next;
                next = next.next;
            }
        }
        return head;
    }

    // 合并两个有序链表
    public static void mergeTwoLists(ListNode l1, ListNode l2) {

    }


    /// 删除链表重复元素
    // https://blog.csdn.net/xushibi4580/article/details/90354394
    // https://blog.csdn.net/qq_42124842/article/details/93302815
    // https://blog.csdn.net/Tong_Nan/article/details/89489621
    public static ListNode removeRepeatLListNode(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode dunmy = new ListNode(0);
        dunmy.next = listNode;

        ListNode pre = dunmy;
        ListNode temp = listNode;

        while (temp != null && temp.next != null) {
            if (temp.next.obj == temp.obj) {
                Object obj = temp.obj;
                while (temp != null && temp.obj == obj) {
                    temp = temp.next;
                }
                pre.next = temp;
            } else {
                pre = temp;
                temp = temp.next;
            }
        }
        return listNode;
    }


//    public static ListNode remove(ListNode node) {
//        ListNode first = new ListNode(0, null);
//        first.next = node;
//
//        ListNode temp = node;
//        ListNode pre = first;
//
//        while (temp != null && temp.next != null) {
//            if (temp.next.obj == temp.obj) {
//                Object val = temp.obj;
//                while (temp != null && temp.obj == val) {
//                    temp = temp.next;
//                }
//                pre.next = temp;
//            } else {
//                pre = temp;
//                temp = temp.next;
//            }
//        }
//        return node;
//    }


    // 删除链表倒数第N个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dunmy = new ListNode("0");
        dunmy.next = head;

        ListNode pre = dunmy;
        ListNode cur = dunmy;// 要删除的节点
        int i = 1;

        while (head != null) {
            if (i >= n) {
                pre = cur;
                cur = cur.next;
            }
            head = head.next;
            i++;
        }
        pre.next = pre.next.next;

        return dunmy.next;
    }


    // 判断链表是否有环
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 判断链表是否有环
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return true;
    }

    // 查找中间元素
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 链表反转
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
