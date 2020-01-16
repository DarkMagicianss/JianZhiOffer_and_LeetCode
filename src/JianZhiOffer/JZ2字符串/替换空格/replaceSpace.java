package JianZhiOffer.JZ2字符串.替换空格;

public class replaceSpace {
    public static String replaceSpace(StringBuffer str) {
        //自己想的老方法 22 ms 9544K
//        if (str.length() == 0 || str == null) return "";
//        byte[] chars = str.toString().getBytes();
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < chars.length; i++) {
//            if(chars[i] == ' '){
//                sb.append("%20");
//                continue;
//            }
//            sb.append((char) chars[i]);
//        }
//        return sb.toString();
        //可以选择不创建字符数组 22ms 9440k
        if (str.length() == 0 || str == null) return "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("We ");
        sb.append("Are ");
        sb.append("Happy.");
        System.out.println(replaceSpace(sb));
    }
}
