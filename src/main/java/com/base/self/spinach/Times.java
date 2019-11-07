package com.base.self.spinach;

import java.text.NumberFormat;
import java.util.Random;

/**
 * 倍投算法
 *
 * @author libo
 * @package com.base.self.spinach
 * @company xmiles
 * @date 2019/9/14
 */
public class Times {

    private static Random random = new Random();

    public static void main(String[] args) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);

        float sum = 0;
        for (int a = 0; a < 1000; a++) {
            // 100次赢得概率
            int winTimes = 0;
            for (int i = 0; i < 1000; i++) {
                // 本金
                int baseMoney = 120;
                // 首次投注金额
                int firstBet = baseMoney / 4;
                // 单次循环压输的次数
                int cycleLoseTimes = 0;

                int bet = firstBet;
                while (cycleLoseTimes <= 10) {
                    // 下注
                    baseMoney -= bet;
                    boolean win = random.nextInt(2) > 0;
                    if (win) {
                        baseMoney += bet * 2;
                        bet = firstBet;
                        cycleLoseTimes = 0;
                    } else {
                        bet = bet * 2;
                        cycleLoseTimes++;
                    }
                }
                if (baseMoney > 120) {
                    winTimes++;
                }
            }
            float v = (float) winTimes / (float) 1000 * 100;
            sum += v;
//            System.out.print("  " + numberFormat.format(v) + "%");
        }
        System.out.println();
        System.out.println(sum / 1000);
    }
}
