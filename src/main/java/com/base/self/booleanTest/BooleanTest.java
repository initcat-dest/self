package com.base.self.booleanTest;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.booleanTest
 * @company initcat
 * @date 2019/5/21
 */
public class BooleanTest {
    public static void main(String[] args) {
        Boolean b1 = true;    //创建Boolean对象

        Boolean b2 = false;  //创建Boolean对象

        Boolean b3 = true;    //创建Boolean对象

        int i;

        i = b1.compareTo(b2);    //b1和b2进行比较

        System.out.println(i);

        i = b2.compareTo(b1);    //b2和b1进行比较

        System.out.println(i);

        i = b1.compareTo(b3);    //b1和b3进行比较

        System.out.println(i);
    }
}
