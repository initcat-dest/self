package com.base.self.thread;

import java.util.concurrent.*;

/**
 * class description 集中创建线程的方式
 *
 * @author libo
 * @package com.base.self.thread
 * @company initcat
 * @date 2020/5/5
 */
public class CreateThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // type1
        Type1ExtendsThread type1ExtendsThread = new Type1ExtendsThread();
        type1ExtendsThread.start();

        // type2
        Type2ImplementsRunnable type2ImplementsRunnable = new Type2ImplementsRunnable();
        Thread thread2 = new Thread(type2ImplementsRunnable);
        thread2.start();

        // type3
        Callable type3ImplementsCallable = new Type3ImplementsCallable(666);
//        FutureTask<String> futureTask = new FutureTask<>(type3ImplementsCallable);
//        Thread thread3 = new Thread(futureTask);
//        thread3.start();
//        System.out.println(futureTask.get());
//        System.out.println("END");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future submit = executorService.submit(type3ImplementsCallable);
        System.out.println(submit.get());
        System.out.println("END");
        executorService.shutdown();
    }

    static class Type1ExtendsThread extends Thread {
        @Override
        public void run() {
            System.out.println("this is type1; extends Thread");
        }
    }

    static class Type2ImplementsRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("this is type2; implements Runnable");
        }
    }

    static class Type3ImplementsCallable implements Callable<String> {

        Integer indx;

        Type3ImplementsCallable(Integer indx) {
            this.indx = indx;
        }

        @Override
        public String call() throws InterruptedException {
            System.out.println("this is type3; implements Callable " + indx);
            Thread.sleep(3000L);
            return "this is type3; return implements Callable " + indx;
        }
    }

}
