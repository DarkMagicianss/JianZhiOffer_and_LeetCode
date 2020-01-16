package JianZhiOffer.JZDiff.栈的压入_弹出序列______思路不够好;

import java.util.HashMap;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len = pushA.length;
        if(len == 0)return true;
        int[] ispop = new int[len];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(pushA[i],i);
        }
        Integer baozheng_index = map.get(popA[0]);
        if(baozheng_index == null)return false;
        ispop[baozheng_index]=1;
        for(int i=1;i<len;i++){
            Integer temp_index =  map.get(popA[i]);
            if(temp_index==null)return false;
            if(temp_index < baozheng_index){
                for(int j=temp_index+1;j<baozheng_index;j++){
                    if(ispop[j] == 0)return false;
                }
            }else{
                baozheng_index = temp_index;
            }
            ispop[temp_index]=1;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,5,3,1,2};
        System.out.println(s.IsPopOrder(pushA,popA));
    }
}
