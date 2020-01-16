package JianZhiOffer.JZ17时间空间效率的平衡.字符流中第一个不重复的字符;


import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    LinkedList<Character> list = new LinkedList<>();
    HashSet<Character> set = new HashSet<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if(set.contains(ch)){
            list.remove((Character)ch);
        }else{
            list.add(ch);
            set.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if(list.isEmpty())
            return '#';
        else
            return list.getFirst();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.Insert('g');
        System.out.println(s.FirstAppearingOnce());
        s.Insert('o');
        System.out.println(s.FirstAppearingOnce());
        s.Insert('o');
        System.out.println(s.FirstAppearingOnce());
        s.Insert('g');
        System.out.println(s.FirstAppearingOnce());
        s.Insert('l');
        System.out.println(s.FirstAppearingOnce());
        s.Insert('e');
        System.out.println(s.FirstAppearingOnce());
    }
}
