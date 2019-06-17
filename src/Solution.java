import java.util.ArrayList;

class Solution {

    /**
     * Helper function to check if one tree is a subtree of another tree
     * @param T The root of the main tree being looked at
     * @param S The root of the subtree to look for
     * @return Returns true if tree S is a subtree of T, otherwise false
     */
    public boolean isSubtree(TreeNode T, TreeNode S) {
        if (S == null)
            return true;
        if (T == null)
            return false;
        if (areIdentical(T, S))
            return true;
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    /**
     * Helper function to check if two trees are equal
     * @param root1 Root of tree1
     * @param root2 Root of tree2
     * @return Returns true if tree1 and tree2 are equal, otherwise false
     */
    boolean areIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    /**
     * Helper function to create and store the inorder traversal of a tree
     * @param root Root of tree
     * @return Returns the inorder traversal as a Integer ArrayList
     */
    public ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        } else {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
        return list;
    }
    /*
     * Helper function to create and store the preorder traversal of a tree
     * @param root Root of tree
     * @return Returns the preorder traversal as a Integer ArrayList
     */
    public ArrayList<Integer> preorder(TreeNode root) {
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
