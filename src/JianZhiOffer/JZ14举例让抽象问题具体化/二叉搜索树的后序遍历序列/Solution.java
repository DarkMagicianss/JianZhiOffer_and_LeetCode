package JianZhiOffer.JZ14举例让抽象问题具体化.二叉搜索树的后序遍历序列;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len == 0)return false;
        if(len == 1)return true;
        return sub_VerifySquenceOfBST(sequence,0,len-1);
    }
    public boolean sub_VerifySquenceOfBST(int [] sequence,int start,int end){
        if(end-start<=1)return true;
        int special_num = sequence[end];
        int key_index=end;
        for(int i=start;i<end;i++){
            if(sequence[i]>special_num){
                key_index = i;
                break;
            }
        }
        System.out.println("key_index  "+key_index);
        for(int i=key_index;i<end;i++){
            if(sequence[i]<special_num){
                return false;
            }
        }
        return sub_VerifySquenceOfBST(sequence,start,key_index-1)&& sub_VerifySquenceOfBST(sequence,key_index,end-1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,7,5};
        Solution s = new Solution();
        System.out.println(s.VerifySquenceOfBST(arr));
    }
}
