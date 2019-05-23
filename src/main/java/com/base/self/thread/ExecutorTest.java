package com.base.self.thread;

import java.util.concurrent.*;

public class ExecutorTest {

    public static void main(String[] args) throws Exception {
        new ExecutorTest().test();
    }

    private void test() throws InterruptedException, ExecutionException {
        ExecutorService executorService = getExecutorService();
        Future<String> submit = executorService.submit(new FixedThreadTest(0));
        Future<String> submit1 = executorService.submit(new FixedThreadTest(1));
        Future<String> submit2 = executorService.submit(new FixedThreadTest(2));
        Thread.sleep(5000);
        String s2 = submit2.get();
        System.out.println(s2);
        String s = submit.get();
        System.out.println(s);
        String s1 = submit1.get();
        System.out.println(s1);
    }

    public class FixedThreadTest implements Callable {
        private int anInt;
        public FixedThreadTest (int anInt) {
            this.anInt = anInt;
        }
        @Override
        public String call() throws Exception {
            System.out.println(System.currentTimeMillis() + "执行FixedThreadTest：" + anInt);
            if (anInt == 2 || anInt == 1) {
                Thread.sleep(3000);
            }
            return "FixedThreadTest return：" + anInt;
        }
    }


    private static ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(1);
    }


}
