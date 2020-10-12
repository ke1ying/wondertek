package com.miu.web.suanfa;

public class chengXu7 {
    /*
     * 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     * */
    public static void main(String[] args) {
        String string = "123,.  ,ajsASA";
        Integer shuzi = 0;
        Integer zimu = 0;
        Integer kongge = 0;
        Integer qita = 0;
        Character.isSpaceChar(' ');
        Character.isLetter('a');
        Character.isDigit('1');
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) <= '9' && string.charAt(i) >= '0') {
                shuzi++;
            } else if (string.charAt(i) <= 'z' && string.charAt(i) >= 'a'
                    || string.charAt(i) <= 'Z' && string.charAt(i) >= 'A') {
                zimu++;
            } else if (string.charAt(i) == ' ') {
                kongge++;
            } else {
                qita++;
            }
        }
        System.out.println("数字：" + shuzi + ";字母:" + zimu);
        System.out.println("空格：" + kongge );
        System.out.println("其他：" + qita );
    }
}
