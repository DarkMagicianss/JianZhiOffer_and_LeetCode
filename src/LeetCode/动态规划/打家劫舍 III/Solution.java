
/**
 * @author LinHu
 * @version 2021/4/3
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] result = getSubRob(root);
        return Math.max(result[0], result[1]);
    }
    private int[] getSubRob(TreeNode root) {
        // 返回的pair前者包含当前节点，后者不包含当前节点。
        if (root == null) {
            return new int[]{0, 0};
        }
        int nowValue = root.val;
        int[] leftVal = getSubRob(root.left);
        int[] rightVal = getSubRob(root.right);
        int includeNodeVal = nowValue + leftVal[1] + rightVal[1];
        int excludeNodeVal = Math.max(leftVal[0], leftVal[1]) +
                Math.max(rightVal[0], rightVal[1]);
        return new int[]{includeNodeVal, excludeNodeVal};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(s.rob(treeNode1));
        TreeNode treeNode21 = new TreeNode(3);
        TreeNode treeNode22 = new TreeNode(4);
        TreeNode treeNode23 = new TreeNode(5);
        TreeNode treeNode24 = new TreeNode(1);
        TreeNode treeNode25 = new TreeNode(3);
        TreeNode treeNode26 = new TreeNode(1);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        treeNode22.left = treeNode24;
        treeNode22.right = treeNode25;
        treeNode23.right = treeNode26;
        System.out.println(s.rob(treeNode21));
        TreeNode treeNode31 = new TreeNode(4);
        TreeNode treeNode32 = new TreeNode(1);
        TreeNode treeNode33 = new TreeNode(2);
        TreeNode treeNode34 = new TreeNode(3);
        treeNode31.left = treeNode32;
        treeNode32.left= treeNode33;
        treeNode33.left = treeNode34;
        System.out.println(s.rob(treeNode31));
    }
}
