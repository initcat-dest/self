package com.base.self.list;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.list
 * @company initcat
 * @date 2019/3/18
 */
public class AsListTest {

    public static void main(String[] args) {
        error1();
        error2();
        error3();
    }

    /**
     * 错误一:将基本类型数组作为asList的参数
     * 由于Arrays.ArrayList参数为可变长泛型，而基本类型是无法泛型化的，所以它把int[] arr数组当成了一个泛型对象，所以集合中最终只有一个元素arr。
     */
    private static void error1() {
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println("error1: Arrays.asList>>>" + list.size());
        // 正确做法1
        int[] arr1 = {1, 2, 3};
        List list1 = CollectionUtils.arrayToList(arr1);
        System.out.println("error1->correct1: Arrays.asList>>>" + list1.size());
        // 正确做法2
        int[] arr2 = {1, 2, 3};
        List list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        System.out.println("error1->correct2: Arrays.asList>>>" + list2.size());

    }

    /**
     * 错误二:将数组作为asList参数后，修改数组或List
     * 由于asList产生的集合元素是直接引用作为参数的数组，所以当外部数组或集合改变时，数组和集合会同步变化，这在平时我们编码时可能产生莫名的问题。
     */
    private static void error2() {
        String[] arr = {"1", "2", "3"};
        List list = Arrays.asList(arr);
        arr[1] = "4";
        list.set(2, "5");
        System.out.println("error2: " + Arrays.toString(arr));
        System.out.println("error2: " + list.toString());
    }

    /**
     * 数组转换为集合后，进行增删元素
     * 由于asList产生的集合并没有重写add,remove等方法，所以它会调用父类AbstractList的方法，而父类的方法中抛出的却是异常信息。
     */
    private static void error3() {
        try {
            String[] arr = {"1", "2", "3"};
            List list = Arrays.asList(arr);
            list.add("4");
            list.remove("3");
            System.out.println("error3: " + list.toString());
        } catch (Exception e) {
            System.out.println("error3: error>>>" + e);
        }
    }
}
