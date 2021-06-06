package com.xzq.listnode;

/***
 * https://github.com/gdutxiaoxu/Android_interview/blob/master/leetcode/ArrayList/arraylist.md
 */
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
    }

    public ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //  本级

//        ListNode next = head.next;
//        head.next = swapPairs(next.next);
//        next.next = head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;

        // 2
//        ListNode one = head;
//        ListNode two = one.next;
//        ListNode three = two.next;
//        two.next = one;
//        one.next = swapPairs(three);
//        return two;
    }


    // https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
    // 剑指 Offer 52. 两个链表的第一个公共节点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    //    https://leetcode-cn.com/problems/palindrome-linked-list/comments/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = rerverse(slow.next);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode rerverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
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


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow =slow.next;
        }
        return fast;
    }


    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    //从尾到头打印链表
    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }


    //  链表反转
    public static ListNode resver(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
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

    /// 拆分链表
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] == nums[left]) left++;

            else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }


    /// 排序链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // step 1.把链表分成两半
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // step 2.对于每一部分的链表进行排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. 合并 l2 和 l2
        return sortMerge(l1, l2);
    }

    ListNode sortMerge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return l.next;
    }


    //判断一个单链表是否存在环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    /// 合并k个有序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return partion(lists, 0, lists.length - 1);
    }

    private ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = partion(lists, start, mid);
            ListNode l2 = partion(lists, mid + 1, end);
            return merge(l1, l2);
        } else {
            //not gonna happen.
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }


    /// 将两个排序好的链表合并成新的有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }


    /// 从m->n的位置翻转链表
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = g.next;
            g.next = temp;

        }
        return dummyHead.next;

    }


    //翻转一个单向链表
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy;
            dummy = head;
            head = temp;
        }
        return dummy;
    }


    /// 删除链表中倒数第n个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null) {
            if (n <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode curr = head;
        while (count != k && curr != null) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) { //翻转
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
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
