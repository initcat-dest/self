package com.base.self.digui;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.digui
 * @company xmiles
 * @date 2019/5/31
 */
public class DiGui2 {

    private static String reverse1(String s) {
        //方法1 递归方法
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        System.out.println(left);
        System.out.println(right);
        return reverse1(right) + reverse1(left);
    }

    public static void main(String[] args) {
        String l = "abcd";
        System.out.println("最终：" + reverse1(l));
    }
}
