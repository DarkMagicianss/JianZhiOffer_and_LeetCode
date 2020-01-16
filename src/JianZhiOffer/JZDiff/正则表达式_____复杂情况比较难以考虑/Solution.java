package JianZhiOffer.JZDiff.正则表达式_____复杂情况比较难以考虑;

public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        //若字符串长度为1
        if (str.length == 1 && pattern.length == 1) {
            if (str[0] == pattern[0] || pattern[0] == '.') {
                return true;
            }
            return false;
        }
        return matchIndex(str, 0, pattern, 0);
    }

    public boolean matchIndex(char[] str, int sindex, char[] pattern, int pindex) {
        //若str和pattern同时达到末尾 则匹配成功
        if (sindex == str.length && pindex == pattern.length)
            return true;
        //若pattern先到末尾 而str没有到达末尾 则匹配失败
        if (sindex != str.length && pindex == pattern.length)
            return false;
        //若pattern的当前的后一个字符是*
        if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
            //若str当前符号与pattern符号相同 或者pattern为'.'
            if (sindex != str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.')) {
                return (matchIndex(str, sindex, pattern, pindex + 2) ||//表明'*'表示的是0个 当前符号可能是*后面的符号
                        matchIndex(str, sindex + 1, pattern, pindex + 2) ||//表明'*'表示的是1个 继续匹配
                        matchIndex(str, sindex + 1, pattern, pindex)//表明'*'表示的是很多个 继续进行递归 直到出现上述情况
                );
            } else {//若str当前符号与pattern符号不匹配 则说明'*'表明该符号为0个
                return matchIndex(str, sindex, pattern, pindex + 2);
            }
        }
        //若pattern的当前的后一个字符不是*
        if (sindex != str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.')) {
            return matchIndex(str, sindex + 1, pattern, pindex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.match("a".toCharArray(), (".*").toCharArray()));
    }
}
