package com.base.self.thread;

/**
 * 线程的挂起方法
 * 这里讨论的是过时的技术，仅为了测试使用jstack
 *
 * @author libo
 * @package com.base.self.thread
 * @company initcat
 * @date 2019/3/5
 */
public class BadSuspend {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                // 挂起当前线程，并持有synchronized锁
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动t1线程
        t1.start();
        Thread.sleep(100);
        // 由于线程t1被挂起，t2.start()处于等待synchronized锁
        t2.start();
        // t1执行继续执行指令
        t1.resume();
        // t2.resume执行先于t2.suspend(),所以导致死锁
        t2.resume();
        t1.join();
        t2.join();
        // 在 Terminal中执行jstack pid(pid:线程ID)
    }
}
