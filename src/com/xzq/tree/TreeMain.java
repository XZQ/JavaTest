package com.xzq.tree;

public class TreeMain {


    public static void main(String[] args) {

    }

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
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

//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null && root.val == sum) return true;
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }


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


    private static boolean result = true;
    private static int max = 0;

    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }


    /// 树的对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
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


    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        max = Math.max(max, l + r);

        return Math.max(l, r) + 1;

//        if (Math.abs(l - r) > 1) {
//            result = false;
//        }
//        return Math.max(l, r) + 1;
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


