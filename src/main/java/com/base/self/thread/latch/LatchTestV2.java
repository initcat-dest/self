package com.base.self.thread.latch;

import java.util.concurrent.CountDownLatch;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.latch
 * @company xmiles
 * @date 2019/4/7
 */
public class LatchTestV2 {

    //模拟的并发量
    private static final int BINGFA = 10;

    private static CountDownLatch cdl = new CountDownLatch(BINGFA);

    public static void main(String[] args) {
        for (int i = 0; i < BINGFA; i++) {
            new Thread(new UserRequest()).start();
            cdl.countDown();
        }
    }

    public static class UserRequest implements Runnable{
        @Override
        public void run() {
            try {
                cdl.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(System.currentTimeMillis());
        }

    }

}
