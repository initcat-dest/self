package com.base.self.spinach;

import java.util.Random;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.spinach
 * @company xmiles
 * @date 2019/9/15
 */
public class Test {

    private static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            // 本金
            int baseMoney = 120;
            // 首次投注金额
            int firstBet = baseMoney / 4;
            // 单次循环压输的次数
            int cycleLoseTimes = 0;
            int bet = firstBet;
            while (cycleLoseTimes <= 3 && baseMoney > 0) {
                // 下注
                baseMoney -= bet;
                int thisBet = bet;
                boolean win = random.nextInt(2) > 0;
                if (win) {
                    baseMoney += bet * 2;
                    if (cycleLoseTimes > 1) {
                        bet = bet * 2;
                    } else {
                        bet = firstBet;
                    }
                    cycleLoseTimes = 0;
                } else {
                    bet = bet / 2;
                    cycleLoseTimes++;
                }
                System.out.println(" win:" + win + " cycleLoseTimes:" + cycleLoseTimes + " baseMoney:" + baseMoney + " bet:" + thisBet);
            }
            System.out.println();

        }
    }
}


