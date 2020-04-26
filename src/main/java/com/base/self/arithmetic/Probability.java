package com.base.self.arithmetic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 概率算法
 *
 * @author libo
 * @package com.base.self.arithmetic
 * @company initcat
 * @date 2019/2/22
 */
public class Probability {

    public static void main(String[] args) {
        Probability service = new Probability();
//        int[] arr = {4, 1, 3, 2};
        int[] arr = {1, 2, 3, 4};

        int i1 = 0,i2 = 0,i3 = 0,i4 = 0;
        for (int i = 0; i < 1000000; i++) {

            int result = service.getResult(arr);
            if (result == 1) {
                i1++;
            }
            if (result == 2) {
                i2++;
            }
            if (result == 3) {
                i3++;
            }
            if (result == 4) {
                i4++;
            }
        }
        System.out.println("i1:" + i1 +" i2:" + i2 +" i3:" + i3 +" i4:" + i4);

//        service.getPrize();

    }

    /**
     * 假设有一个数组[100,400,200,300],它的意思是,总数是100+400+200+300=1000.
     * 取到第一个数的概率是100/1000,取到第二个数的概率是400/1000......
     * 源：https://www.cnblogs.com/liulangmao/p/4533293.html
     *
     * @param arr
     * @return
     */
    private int getResult(int[] arr) {
        int leng = Arrays.stream(arr).sum();
        //获取总数
        for (int i = 0; i < arr.length; i++) {
            //获取 0-总数 之间的一个随随机整数
            int random = (int) (Math.random() * leng);
            if (random < arr[i]) {
                //如果在当前的概率范围内,得到的就是当前概率
                return arr[i];
            } else {
                //否则减去当前的概率范围,进入下一轮循环
                leng -= arr[i];
            }
        }
        return 0;
    }

    private PrizeInfo getPrize() {
        List<PrizeInfo> prizeList = getPrizeList();
        //获取总数
        int sum = prizeList.stream().mapToInt(PrizeInfo::getProbability).sum();
        int randNum = new Random().nextInt(sum);
        int nowValue = 0;
        for (PrizeInfo temp : prizeList) {
            nowValue += temp.getProbability();
            if (randNum < nowValue) {
                return temp;
            }
        }
        return null;
    }

    private List<PrizeInfo> getPrizeList() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new PrizeInfo("商品" + i, 1, i * 10))
                .collect(Collectors.toList());
    }

    /**
     * 奖品信息
     */
    class PrizeInfo {
        /**
         * 奖品名称
         */
        private String prizeName;

        /**
         * 奖品类型 1：金币 2：实物 3：网页 4：没奖励  5：客服
         */
        private int prizeType;

        /**
         * 中奖概率
         */
        private int probability;

        public PrizeInfo(String prizeName, int prizeType, int probability) {
            this.prizeName = prizeName;
            this.prizeType = prizeType;
            this.probability = probability;
        }

        public String getPrizeName() {
            return prizeName;
        }

        public void setPrizeName(String prizeName) {
            this.prizeName = prizeName;
        }

        public int getPrizeType() {
            return prizeType;
        }

        public void setPrizeType(int prizeType) {
            this.prizeType = prizeType;
        }

        public int getProbability() {
            return probability;
        }

        public void setProbability(int probability) {
            this.probability = probability;
        }
    }
}
