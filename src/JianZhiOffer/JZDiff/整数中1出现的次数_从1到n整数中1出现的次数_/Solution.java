package JianZhiOffer.JZDiff.整数中1出现的次数_从1到n整数中1出现的次数_;


public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) return 0;
        if (n <= 9) return 1;
        int[] wei1num = new int[]{1, 20, 300, 4000, 50000, 600000, 7000000, 80000000, 900000000};
        int number = n;
        int count = 0;
        int highwei = 0;
        while (number != 0) {//得出对应的n数字的位数
            if (number / 10 == 0) highwei = number;
            number = number / 10;
            count++;
        }
        int temp_num = (int) Math.pow(10, count - 1);
        int remain = n % temp_num;
        int result = NumberOf1Between1AndN_Solution(remain);
        if (highwei == 1) {//以1361为例 需要加上361个1为千位开头的1的个数 就是remain 然后加上361本身中包含多少个1
            result += remain + 1;
        } else {//以3361为例 需要加上1000到1999 以及2000到2999中间的所有1的个数
            result = result + temp_num + wei1num[count - 2] * (highwei - 1);//这个为1000到1999的 加上之后的
        }
        result += wei1num[count - 2];
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.NumberOf1Between1AndN_Solution(1361);
        System.out.println(result);
    }
}
