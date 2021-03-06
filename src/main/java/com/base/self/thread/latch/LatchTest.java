package com.base.self.thread.latch;

import java.text.NumberFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java模拟多线程高并发
 * 原文地址：https://blog.csdn.net/u010642004/article/details/50042781
 *
 * @author Administrator
 */
public class LatchTest {
    private static int count = 0;
    /**
     * 并发量
     */
    private int threadNum = 4;
    /**
     * 总访问量
     */
    private int clientNum = 12;

    private float avgExecTime = 0;
    private float sumexecTime = 0;
    private long firstExecTime = Long.MAX_VALUE;
    private long lastDoneTime = Long.MIN_VALUE;
    private float totalExecTime = 0;

    public static void main(String[] args) {
        new LatchTest().run();
        System.out.println("finished!");
    }

    private void run() {
        final ConcurrentHashMap<Integer, ThreadRecord> records = new ConcurrentHashMap<>();
        // 建立ExecutorService线程池，threadNum个线程可以同时访问
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 模拟clientNum个客户端访问
        final CountDownLatch doneSignal = new CountDownLatch(clientNum);

        for (int i = 0; i < clientNum; i++) {
            Runnable run = () -> {
                int index = getIndex();
                long systemCurrentTimeMillis = System.currentTimeMillis();
                try {
                    // do something
//                        String sendGet = HttpClientUtil.sendGet("http://localhost:8080/Dima3773Web/Simulate", "");
//                        System.out.println(System.currentTimeMillis() + sendGet);
                    System.out.println(System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                records.put(index, new ThreadRecord(systemCurrentTimeMillis, System.currentTimeMillis()));
                // 每调用一次countDown()方法，计数器减1
                doneSignal.countDown();
            };
            exec.execute(run);
        }

        try {
            // 计数器大于0时，await()方法会阻塞程序继续执行
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();

        // 获取每个线程的开始时间和结束时间
        for (int i : records.keySet()) {
            ThreadRecord r = records.get(i);
            sumexecTime += ((double) (r.endTime - r.startTime)) / 1000;

            if (r.startTime < firstExecTime) {
                firstExecTime = r.startTime;
            }
            if (r.endTime > lastDoneTime) {
                this.lastDoneTime = r.endTime;
            }
        }

        this.avgExecTime = this.sumexecTime / records.size();
        this.totalExecTime = ((float) (this.lastDoneTime - this.firstExecTime)) / 1000;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(4);

        System.out.println("======================================================");
        System.out.println("线程数量:\t\t" + threadNum);
        System.out.println("客户端数量:\t" + clientNum);
        System.out.println("平均执行时间:\t" + nf.format(this.avgExecTime) + "秒");
        System.out.println("总执行时间:\t" + nf.format(this.totalExecTime) + "秒");
        System.out.println("吞吐量:\t\t" + nf.format(this.clientNum / this.totalExecTime) + "次每秒");
    }

    private static int getIndex() {
        return ++count;
    }

    class ThreadRecord {
        long startTime;
        long endTime;

        ThreadRecord(long st, long et) {
            this.startTime = st;
            this.endTime = et;
        }

    }
}

