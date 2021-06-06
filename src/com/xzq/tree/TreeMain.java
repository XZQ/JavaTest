package com.xzq.tree;


import com.xzq.listnode.ListNode;

import java.util.*;

public class TreeMain {


    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        System.out.println(maxTree(nums, 0, nums.length - 1));
    }


    //    最大二叉树
//    https://lyl0724.github.io/2020/01/25/1/
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    public static TreeNode maxTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int maxInded = findMax(nums, l, r);
        TreeNode treeNode = new TreeNode(nums[maxInded]);
        treeNode.left = maxTree(nums, l, maxInded - 1);
        treeNode.right = maxTree(nums, maxInded + 1, r);
        return treeNode;
    }

    public static int findMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    // 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (Math.abs(getHeight1(root.left) - getHeight1(root.right)) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int getHeight1(TreeNode x) {
        if (null == x) {
            return 0;
        }
        return Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    }


    // 二叉树最大深度
    public int maxDepth2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = maxDepth2(treeNode.left);
        int right = maxDepth2(treeNode.right);
        return Math.max(left, right) + 1;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }


    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree0(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


    // https://truedei.blog.csdn.net/article/details/106655271
//    static public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0)
//            return null;
//
//        //1，获取树的根节点的value值
//        TreeNode root = new TreeNode(preorder[0]);
//        //2，查找每一次根节点在中序遍历结果中的位置
//        int index = findIndex(preorder[0], inorder);
//
//        //3,构建left左子树
////        root.left = buildTree(左子树前序数组，左子树中序数组)
//        root.left = buildTree(java.util.Arrays.copyOfRange(preorder, 1, index + 1),
//                java.util.Arrays.copyOfRange(inorder, 0, index));
//
//
//        //4，构建reght右子树
////        root.right=buildTree(右子树前序数组，右子树中序数组)
//        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
//                Arrays.copyOfRange(inorder, index + 1, inorder.length));
//
//
//        return root;
//    }

    /**
     * 查找根的index（在中序中的位置）的函数
     *
     * @param preorderData 节点
     * @param inorder      每一次的中序数组
     * @return 索引位置
     */
    static public int findIndex(int preorderData, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorderData)
                return i;
        }
        return 0;
    }

    public static void levelOrder12(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.pop();
            System.out.print(root.val + " ");
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }


    // 3 后序遍历（递归）
    public static void nextOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        preOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    /**
     * 左-->右-->根
     * 非递归实现后序遍历
     *
     * @param root
     */
    public static void BackOrderStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点

        //节点不为空，结点入栈，并且指向下一个左孩子
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                /**
                 * 这块就是判断treeNode是否有右孩子，
                 * 如果没有，则输出treeNode.val，让lastVisit指向treeNode，并让treeNode为空
                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
                 */
                if (treeNode.right == null || treeNode.right == lastVisit) {
                    System.out.print(treeNode.val + " ");
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
    }


    // 2 中序遍历（递归）
    public static void centerOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.right);
    }

    /**
     * 左-->根-->右
     * 非递归实现中序遍历
     *
     * @param root
     */
    public static void MidOrderStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            }
        }
    }


    // 1 前序遍历（递归）
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    // 1 前序遍历（遍历）
    public static void preOrder2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }


    // 重建二叉树
    // https://truedei.blog.csdn.net/article/details/106655271
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }


    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    //  深度优先搜索
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                queue.offer(node.left);
            } else if (node.val < low) {
                queue.offer(node.right);
            } else {
                sum += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sum;

    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);

    }

    /// 二叉树右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.addFirst(root);
        }
        while (!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }


    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    boolean isValidBST(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return true;
        }
        if (left != null && root.val <= left.val) {
            return false;
        }
        if (right != null && root.val >= right.val) {
            return false;
        }

        return isValidBST(root.left, left, root);

    }


    boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }


    void traverse(TreeNode root) {
        // root 需要做
        root.val += 1;
        traverse(root.left);
        traverse(root.right);
    }


    /// 树的对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 要判断一个树 t 是不是树 s 的子树
    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (t.val != s.val) return false;
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }


    ///判断路径和是否等于一个数
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    ///  归并两棵树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.left, t2.right);
        return treeNode;

    }

    /// 二叉树翻转
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }


    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if (r == null) {
            return 0;
        }
        int left = Math.max(0, getMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;

    }


}


