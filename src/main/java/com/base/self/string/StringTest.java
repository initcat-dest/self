package com.base.self.string;

import java.net.ServerSocket;
import java.net.Socket;

public class StringTest {

    String process(String str) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            // 判断是否是小写字母
            if (Character.isLowerCase(aChar)) {
                return "不合法的String";
            }
        }
        StringBuffer bf = new StringBuffer(str);
        return bf.reverse().toString();
    }

    int calc(int x) {
        int aDayWork = 5;
        int bDayWork = 6;
        int workDay = 0;
        int aWorkCount = 0;
        int bWorkCount = 0;
        boolean aRest = false;
        boolean bRest = false;
        while (x <= 0) {
            workDay++;
            if (!aRest) {
                aWorkCount += aDayWork;
                x = x - aDayWork;
            } else if (aRest && bRest) {
                aWorkCount += aDayWork;
                x = x - aDayWork;
            }

            if (!bRest) {
                bWorkCount += bDayWork;
                x = x - bDayWork;
            }
            // 判断A队明天是否需要休息
            aRest = String.valueOf(aWorkCount).endsWith("13");
            // 判断B队明天是否需要休息
            bRest = String.valueOf(bWorkCount).endsWith("13");
        }
        return workDay;
    }

    public static void main(String[] args) throws Exception {
        int port = 8888;
        ServerSocket socket = new ServerSocket(port);
        while (true) {
            Socket client = socket.accept();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    // do something client.....;
                }
            });
            t.start();
        }
    }

}
