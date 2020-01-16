package JianZhiOffer.JZ16时间效率.整数中1出现的次数_从1到n整数中1出现的次数_;

public class BetterSolution {
    public int NumberOf1Between1AndN_Solution_2(int n) {
        long count = 0; // 1的个数
        long i = 1;  // 当前位
        long current = 0,after = 0,before = 0;

        while((n / i) != 0) {
            before = n / (i * 10); // 高位
            current = (n / i) % 10; // 当前位
            after = n - (n / i) * i;  // 低位

            if (current == 0)
                //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                count = count + before * i;
            else if(current == 1)
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + before * i + after + 1;
            else if (current > 1)
                // 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
                count = count + before * i + i;//是current==1的after+1的特殊情况
            //前移一位
            i = i * 10;
        }
        return (int) count;
    }

    public static void main(String[] args) {
        BetterSolution bs = new BetterSolution();
        int result = bs.NumberOf1Between1AndN_Solution_2(1361);
        System.out.println(result);
    }
}
