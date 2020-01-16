package LeetCode.位运算.只出现一次的数字2;


public class Solution {
    //用 one 记录到当前处理的元素为止，二进制1出现“1次”（mod 3 之后的 1）的有哪些二进制位；
    // 用 two 记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的有哪些二进制位。
    // 当 one 和 two 中的某一位同时为1时表示该二进制位上1出现了3次，此时需要清零。
    // 即用二进制模拟三 进制运算。最终 one 记录的是最终结果。
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int num : nums) {
            twos |= ones & num;//用Int32位任意一位出现了一次1的结果ones 和当期num与 则同一个位置出现两次的会是1合并到twos 出现一次的保持twos原先的位
            ones ^= num;//一直异或num 则Int中的某一位出现一次1 ones为1 两次则异或成0 三次还是1 但是会被后续操作清零
            threes = ones & twos;//ones和twos同时为1时 threes为1
            ones &= ~threes;//threes对应的位置为1 取反为0 和ones与则将对应位清零
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(s.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(s.singleNumber(new int[]{-2, -2, 1, 1, -3, 1, -3, -3, -4, -2}));
    }
}
