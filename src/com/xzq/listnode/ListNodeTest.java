package com.xzq.listnode;

public class ListNodeTest {

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


        System.out.println(listNode1);
        System.out.println(removeNthFromEnd1(listNode1, 2));
    }


    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int j = 0; j < n; j++) {
            fast = fast.next;
        }
        if (fast == null) {//此时删除的是第一个节点
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;//删除slow.next


        return head;

    }

    // 删除链表倒数第N个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode("0");
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int j = 1;
        while (head != null) {
            if (j >= n) {
                fast = slow;
                slow = slow.next;
            }
            head = head.next;
            j++;
        }
        fast.next = fast.next.next;
        return dummy.next;
    }

    //    链表中倒数第k个节点
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode("0");
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int j = 0;
        while (dummy != null) {
            if (j >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            j++;
            dummy = dummy.next;
        }
        return slow;
    }


    // 查找中间元素
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // 判断链表是否有环
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    /// 链表反转
    public static ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode head = null;
        while (listNode != null) {
            ListNode tempNode = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = tempNode;
        }
        return head;
    }
}

