package com.base.self.locks;

/**
 * class description 死锁
 *
 * @author libo
 * @package com.base.self.locks
 * @company initcat
 * @date 2020/6/17
 */
public class DeadLock {

    private static LockA lockA = new LockA();
    private static LockB lockB = new LockB();

    public static void main(String[] args) {
        System.out.println("lockA.start();");
        LockA lockA = new LockA();
        lockA.start();
        System.out.println("lockB.start();");
        LockB lockB = new LockB();
        lockB.start();
        long timeOut = System.currentTimeMillis() + 7000;
        while (true) {
            System.out.println((timeOut <= System.currentTimeMillis()) + " timeOut:" + timeOut + "; " + System.currentTimeMillis());
            if (timeOut <= System.currentTimeMillis()) {
                lockA.stop();
                lockB.stop();
                break;
            }
        }
    }

    static class LockA extends Thread {
        @Override
        public void run() {
            try {
                synchronized (lockA) {
                    System.out.println(Thread.currentThread() + " first get LockA");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread() + " stata:" + Thread.currentThread().getState().toString());
                    synchronized (lockB) {
                        System.out.println("get LockB too");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class LockB extends Thread {
        @Override
        public void run() {
            try {
                synchronized (lockB) {
                    System.out.println(Thread.currentThread() + " first get LockB");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread() + " stata:" + Thread.currentThread().getState().toString());
                    synchronized (lockA) {
                        System.out.println("get LockA too");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
