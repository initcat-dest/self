package com.base.self.thread;

/**
 * 线程池测试
 *
 * @author libo
 * @package com.base.self.thread
 * @company xmiles
 * @date 2019/3/5
 */
public class ThreadTest {

    private static Integer r1 = 3;
    private static Integer r2 = 3;
    private static Integer A = 3;
    private static Integer B = 3;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> threadOne()).start();
            new Thread(() -> threadTwo()).start();
            System.out.println("第" + i + "次>>>"
                    + ", r1: " + r1
                    + ", r2: " + r2
                    + ", A: " + A
                    + ", B: " + B
                    + ", r2 == 2: " + (r2 == 2));
            clearAll();
        }
        System.out.println("done");
    }

    public static void threadOne() {
        r2 = A;
        B = 1;
    }

    public static void threadTwo() {
        r1 = B;
        A = 2;
    }

    private static void clearAll() {
        r1 = 4;
        r2 = 4;
        A = 4;
        B = 4;
    }
}
