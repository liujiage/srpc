package org.jiage.srpc.server.string;

import org.junit.Test;

public class StringReverseTest {

    @Test
    public void test2() {
        //char[] chars = {'1', '2', '0', '4', '5'};
        //reverse(chars);
        //for (char c : chars) System.out.print(c);
        String words = "Let's take LeetCode contest";
        //s'teL ekat edoCteeL tsetnoc
        System.out.print(reverseWords(words));
    }
    public void test3(){
        "".toLowerCase();
    }

    public static void reverse(char[] chars) {
        if (chars == null || chars.length <= 1) return;
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }

    public static String reverseWords(String words) {
        String[] ss = words.split(" ");
        StringBuffer res = new StringBuffer();
        for(String s : ss)
            res.append(new StringBuffer(s).reverse()).append(" ");
        return res.toString().trim();
    }

}
