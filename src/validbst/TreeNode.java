package validbst;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode instance() {
        TreeNode node17 = new TreeNode(17);
        TreeNode node18 = new TreeNode(18);
        TreeNode node19 = new TreeNode(19);
        TreeNode node20 = new TreeNode(20);
        TreeNode node21 = new TreeNode(21);
        TreeNode node22 = new TreeNode(22);
        TreeNode node23 = new TreeNode(23);
        node20.left = node18;
        node20.right = node22;
        node18.left = node17;
        node18.right = node19;
        node22.left = node21;
        node22.right = node23;
        return node20;
    }
}
