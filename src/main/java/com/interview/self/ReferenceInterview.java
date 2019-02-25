package com.interview.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 引用传递
 * 非基本类型参数传递为引用传递的规则
 *
 * @author libo
 * @package com.interview.self
 * @company xmiles
 * @date 2019/2/23
 */
public class ReferenceInterview {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = a;
        b++;
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        /*
            s1\s2\ss1\ss2中存储的是StringBuffer变量的引用而不是一个StringBuffer对象。
            根据非基本类型参数传递为引用传递的规则，
            changeStringBuffer接收的参数只是StringBuffer对象的引用.
            因此可以理解为s1、ss1都是指向同一个对象;
            s2、ss2也是指向同一个StringBuffer对象，
            所以s1.append(" world")将导致s1和ss1同指的StringBuffer对象改变（增加" world"）;
            而ss2 = ss1只是让变量ss2改变指向为和ss1相同的StringBuffer对象，
            而ss2原来所指的对象并不会发生任何改变。(s2的指向对象没有变化)
         */
        StringBuffer s1 = new StringBuffer("Hollo");
        StringBuffer s2 = new StringBuffer("Hollo");
        changeStringBuffer(s1, s2);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        List<String> l1 = new ArrayList<>();
        l1.add("Hollo");
        List<String> l2 = new ArrayList<>();
        l2.add("Hollo");
        changeList(l1, l2);
        System.out.println("l1: " + l1.toString());
        System.out.println("l2: " + l2.toString());

        Map<String, String> m1 = new HashMap<>();
        m1.put("1", "Hollo");
        Map<String, String> m2 = new HashMap<>();
        m2.put("1", "Hollo");
        changeMap(m1, m2);
        System.out.println(m1.toString());
        System.out.println(m2.toString());
    }

    private static void changeStringBuffer(StringBuffer ss1, StringBuffer ss2) {
        ss1.append(" world");
        ss2 = ss1;
        System.out.println("ss2: " + ss2);
    }

    private static void changeList(List<String> ll1, List<String> ll2) {
        ll1.add(" world");
        ll2 = ll1;
        System.out.println("ll2: " + ll2.toString());
    }

    private static void changeMap(Map<String, String> mm1, Map<String, String> mm2) {
        mm1.put("2", "world");
        mm2 = mm1;
        System.out.println("mm2: " + mm2.toString());
    }
}
