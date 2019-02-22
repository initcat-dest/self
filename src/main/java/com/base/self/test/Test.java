package com.base.self.test;

import com.base.self.utils.UtilNumber;

import java.math.BigDecimal;

public class Test {
	public static void func(int a) {
		a = 20;
		System.out.println(a);
	}

	public static void main(String[] args) throws Exception {
		// int a = 10;// 变量
		// func(a);
		// System.out.println(a);
		//
		// System.out.println(DateFormatUtils.format(1485193638L * 1000, "yyyy-MM-dd
		// HH:mm:ss"));
		//
		// Float averageAward = 0.00f;
		// if (averageAward != null && averageAward == 0) {
		// System.out.println(111);
		// }
		// System.out.println(222);

		// BigDecimal money = new BigDecimal(0.7);
		// BigDecimal customsPassAwardIntervalStart = new BigDecimal(0.1);
		// BigDecimal customsPassAwardIntervalEnd = new BigDecimal(0.5);
		// if (money.compareTo(customsPassAwardIntervalStart) < 0 ||
		// money.compareTo(customsPassAwardIntervalEnd) > 0) {
		// for (int i = 0; i < 50; i++) {
		// money = new BigDecimal(Math.random()
		// * (customsPassAwardIntervalEnd.floatValue() -
		// customsPassAwardIntervalStart.floatValue())
		// + customsPassAwardIntervalStart.floatValue());
		// money = UtilNumber.transBase(money.floatValue(), 2, BigDecimal.ROUND_DOWN);
		// System.out.println(money);
		// }
		// }
		BigDecimal money = new BigDecimal(0); // 单用户奖金
		Float averageAward = 0.1f;
		// 如果配置人均奖金，则直接使用
		if (averageAward != null && averageAward > 0) {
			money = UtilNumber.transBase(averageAward, 2, BigDecimal.ROUND_DOWN);
			System.out.println(1);
		} else {
			// 奖金平均分
			money = UtilNumber.transBase(10 / 13413, 2, BigDecimal.ROUND_DOWN);
			BigDecimal awardMin = new BigDecimal(1.9);
			BigDecimal awardMax = new BigDecimal(1.9);
			if (awardMin != null && awardMax != null
					&& (money.compareTo(awardMin) < 0 || money.compareTo(awardMax) > 0)) {
				money = new BigDecimal(
						Math.random() * (awardMax.floatValue() - awardMin.floatValue()) + awardMin.floatValue());
				money = UtilNumber.transBase(money.floatValue(), 2, BigDecimal.ROUND_DOWN);
				System.out.println(2);
			}
			if ((awardMin == null || awardMax == null)
					&& (money.compareTo(new BigDecimal(0.1)) < 0 || money.compareTo(new BigDecimal(0.5)) > 0)) {
				// 若奖励金额小于0.1 或 大于0.5 取0.1到0.5的随机值
				money = UtilNumber.transBase(((float) (1 + Math.random() * 4) / 10), 2, BigDecimal.ROUND_DOWN);
				System.out.println(3);
			}
		}
		System.out.println(money);
	}
}
