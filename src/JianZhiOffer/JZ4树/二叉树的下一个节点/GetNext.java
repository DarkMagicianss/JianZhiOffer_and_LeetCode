package JianZhiOffer.JZ4树.二叉树的下一个节点;

import utils.TreeLinkNode;

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            //源节点的右节点包含子树(左节点包含 没用)
            TreeLinkNode source_right = pNode.right;
            while (source_right.left != null) {
                source_right = source_right.left;
            }
            return source_right;
        } else if(pNode.next != null) {
            //源节点不包含子节点
            if (pNode == pNode.next.left) {
                //1.源节点作为父节点的左节点
                return pNode.next;
            } else {
                //2.源节点作为父节点的右节点
                TreeLinkNode source_father = pNode.next;
                if(source_father.next == null) return null;
                while(source_father == source_father.next.right){
                    source_father = source_father.next;
                    if(source_father.next == null) return null;
                }
                return source_father.next;
            }
        }else{
            //没有右子节点 也没有父节点 结束了呀~~~~
            return null;
        }

    }

    public static void main(String[] args) {

    }
}
