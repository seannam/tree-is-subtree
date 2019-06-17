import java.util.ArrayList;

class Solution {
    public boolean isSubtree(TreeNode t, TreeNode s) {
        if (s == null)
            return true;

        if (t == null)
            return false;

        if (areIdentical(t, s))
            return true;

        return isSubtree(t.left, s) || isSubtree(t.right, s);
    }

    boolean areIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
    }

    public ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        } else {
            list.add(root.val);
            inorder(root.left);
            inorder(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        // inorder: 3 4 1 2 5
        //     3
        //    / \
        //   4   5
        //  / \
        // 1   2
        TreeNode rootS = new TreeNode(3);
        rootS.left = new TreeNode(4);
        rootS.left.left = new TreeNode(1);
        rootS.left.right = new TreeNode(2);
        rootS.right = new TreeNode(5);

//        rootS.left.right.right = new TreeNode(0);

        TreeNode rootT = new TreeNode(4);
        rootT.left = new TreeNode(1);
        rootT.right = new TreeNode(2);

        Solution s = new Solution();
        boolean result = s.isSubtree(rootS, rootT);

        if(result) {
            System.out.println("tree S is a subtree of tree T");
        } else {
            System.out.println("tree S is not subtree of tree T");
        }
    }


}
