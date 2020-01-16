package JianZhiOffer.JZDiff.序列化二叉树_____重建二叉树不会啊;


import utils.TreeNode;

public class Solution {
    public String Serialize(TreeNode root) {
        //利用前序遍历生成序列
        if (root == null) return "";
        String result = sub_pre_lookup(root);
        return result.substring(0, result.length() - 1);
    }
    public String sub_pre_lookup(TreeNode root) {
        String temp_result = "";
        if (root == null) return "#,";
        temp_result += root.val + ",";
        temp_result += sub_pre_lookup(root.left);
        temp_result += sub_pre_lookup(root.right);
        return temp_result;
    }
    //这里开始是难点啊 依据前序遍历重建二叉树 太强了呀
    public int index = -1;
    public TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        String[] arr = str.split(",");
        TreeNode node = null;
        if (index >= len) return null;//index超出数组的长度 返回空
        if (!arr[index].equals("#")) {
            //若当前节点不为'#'
            node = new TreeNode(Integer.parseInt(arr[index]));//创建当前节点
            node.left = Deserialize(str);//设置其左子树
            node.right = Deserialize(str);//设置其右子树
        }
        return node;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(11);
        TreeNode t2 = new TreeNode(22);
        TreeNode t3 = new TreeNode(33);
        TreeNode t4 = new TreeNode(44);
        TreeNode t5 = new TreeNode(111);
        TreeNode t6 = new TreeNode(123);
        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        t4.right = t5;
        t5.left = t6;
        Solution s = new Solution();
        String str = s.Serialize(t1);
        System.out.println(str);
        String str1 = s.Serialize(s.Deserialize(str));
        System.out.println(str1);
    }
}
