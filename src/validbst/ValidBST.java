package validbst;

import java.util.Stack;

public class ValidBST {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(TreeNode.instance()));
    }

    static class Solution {

        public boolean isValidBST(TreeNode root) {
            //return performTraversals(root);
            return help(root, null, null);
        }

        //方法一
        private final Stack<Integer> stack = new Stack<>();

        private boolean performTraversals(TreeNode root) {
            boolean a1 = true, a2 = true;
            if (root != null) {
                a1 = performTraversals(root.left);
                if (stack.empty()) {
                    stack.push(root.val);
                } else {
                    if (stack.peek() >= root.val) {
                        return false;
                    } else {
                        stack.push(root.val);
                    }
                }
                a2 = performTraversals(root.right);
            }
            return a1 && a2;
        }

        //方法二
        private boolean help(TreeNode root, Integer min, Integer max) {
            if (root == null) return true;
            if (min != null && min >= root.val) return false;
            if (max != null && max <= root.val) return false;
            return help(root.right, root.val, max) && help(root.left, min, root.val);
        }
    }
}
