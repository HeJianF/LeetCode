package validbst;

import jdk.nashorn.internal.ir.ThrowNode;

import java.util.*;

public class ValidBST {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.minDepth(TreeNode.instance()));
        System.out.println(solution.generateParenthesis(3));
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

        //二叉树层序遍历
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) return lists;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    list.add(treeNode.val);
                    if (treeNode.left != null) queue.add(treeNode.left);
                    if (treeNode.right != null) queue.add(treeNode.right);
                }
                lists.add(list);
            }
            return lists;
        }

        //二叉树的最大深度
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left != null) queue.add(treeNode.left);
                    if (treeNode.right != null) queue.add(treeNode.right);
                }
                count++;
            }
            return count;
        }

        //二叉树的最小深度
        public int minDepth(TreeNode root) {
            //广度优先搜索
            /*if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int count = 0;
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left != null) queue.add(treeNode.left);
                    if (treeNode.right != null) queue.add(treeNode.right);
                    if (treeNode.left == null && treeNode.right == null) return count;
                }
            }
            return count;*/

            //深度优先搜索
            if (root == null) return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
        }

        //括号生成
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateOneByOne("", result, n, n);
            return result;
        }

        public void generateOneByOne(String sublist, List<String> result, int left, int right) {
            if (left == 0 && right == 0) {
                result.add(sublist);
                return;
            }
            if (left > 0) {
                generateOneByOne(sublist + "(", result, left - 1, right);
            }
            if (right > left) {
                generateOneByOne(sublist + ")", result, left, right - 1);
            }
        }
    }
}
