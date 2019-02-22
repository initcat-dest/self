package com.base.self.utils;

import com.base.common.log.LogService;

import java.math.BigDecimal;

/**
 * 数字计算工具
 */
public class UtilNumber {

	private static int decimals = 2;
	private static int rounding = BigDecimal.ROUND_HALF_UP;
	private static int downDecimals = 2;
	private static int downRounding = BigDecimal.ROUND_DOWN;
	private static int roundDownDecimals = 0;
	private static int roundDownRounding = BigDecimal.ROUND_DOWN;
	private static int upDecimals = 2;
	private static int upRounding = BigDecimal.ROUND_UP;
	private static int fiveDecimals = 5;
	public static final BigDecimal ZERO = BigDecimal.ZERO.setScale(decimals, rounding);
	public static final BigDecimal ONE = BigDecimal.ONE.setScale(decimals, rounding);

	// 加法
	private static BigDecimal addBase(Object a, Object b, int decimals, int rounding) throws RuntimeException {
		BigDecimal add1 = conversionToBigDecimal(a);
		BigDecimal add2 = conversionToBigDecimal(b);
		BigDecimal result = add1.add(add2).setScale(decimals, rounding);
		return result;
	}

	// 减法
	private static BigDecimal subtractBase(Object a, Object b, int decimals, int rounding) throws RuntimeException {
		BigDecimal subtract1 = conversionToBigDecimal(a);
		BigDecimal subtract2 = conversionToBigDecimal(b);
		BigDecimal result = subtract1.subtract(subtract2).setScale(decimals, rounding);
		return result;
	}

	// 乘法
	private static BigDecimal multiplyBase(Object a, Object b, int decimals, int rounding) throws RuntimeException {
		BigDecimal multiply1 = conversionToBigDecimal(a);
		BigDecimal multiply2 = conversionToBigDecimal(b);
		BigDecimal result = multiply1.multiply(multiply2).setScale(decimals, rounding);
		return result;
	}

	// 除法
	private static BigDecimal divideBase(Object a, Object b, int decimals, int rounding) throws RuntimeException {
		BigDecimal divide1 = conversionToBigDecimal(a);
		BigDecimal divide2 = conversionToBigDecimal(b);
		BigDecimal result = divide1.divide(divide2, decimals, rounding);
		return result;
	}

	// 次方
	private static BigDecimal powBase(Object a, int b, int decimals, int rounding) throws RuntimeException {
		BigDecimal radix = conversionToBigDecimal(a);

		BigDecimal result = transBase(radix.pow(b), decimals, rounding);
		return result;
	}

	// 精度截取
	public static BigDecimal transBase(Object a, int decimals, int rounding) throws RuntimeException {
		BigDecimal result = conversionToBigDecimal(a).setScale(decimals, rounding);
		return result;
	}

	// 类型转换
	private static BigDecimal conversionToBigDecimal(Object obj) throws RuntimeException {
		if (obj instanceof Double) {
			return new BigDecimal(obj.toString());
		} else if (obj instanceof Float) {
			return new BigDecimal(obj.toString());
		} else if (obj instanceof Integer) {
			return new BigDecimal(obj.toString());
		} else if (obj instanceof Long) {
			return new BigDecimal(obj.toString());
		} else if (obj instanceof Byte) {
			return new BigDecimal(obj.toString());
		} else if (obj instanceof Short) {
			return new BigDecimal(obj.toString());
		} else if (obj instanceof String) {
			return new BigDecimal(obj.toString());
		} else if (obj instanceof BigDecimal) {
			return (BigDecimal) obj;
		} else {
			LogService.error("不能转换:" + obj);
			throw new RuntimeException("不能转换");
		}
	}


	// 4舍5入加法
	public static BigDecimal add(Object a, Object b) throws RuntimeException {
		return addBase(a, b, decimals, rounding);
	}

	// 4舍5入减法
	public static BigDecimal subtract(Object a, Object b) throws RuntimeException {
		return subtractBase(a, b, decimals, rounding);
	}

	// 4舍5入乘法
	public static BigDecimal multiply(Object a, Object b) throws RuntimeException {
		return multiplyBase(a, b, decimals, rounding);
	}

	// 4舍5入除法
	public static BigDecimal divide(Object a, Object b) throws RuntimeException {
		return divideBase(a, b, decimals, rounding);
	}

	// 4舍5入截取
	public static BigDecimal trans(Object a) throws RuntimeException {
		return transBase(a, decimals, rounding);
	}

	//多数4舍5入相加
	public static BigDecimal add(final Object a, final Object... as) {
		BigDecimal sum = BigDecimal.ZERO;
		for (final Object v : as) {
			sum = add(sum, v);
		}
		return add(a, sum);
	}

	//多数4舍5入相乘
	public static BigDecimal multiply(final Object a, final Object... as) {
		BigDecimal sum = BigDecimal.ONE;
		for (final Object v : as) {
			sum = multiply(sum, v);
		}
		return multiply(a, sum);
	}

	// 4舍5入次方
	public static BigDecimal pow(Object a, int b) throws RuntimeException {
		return powBase(a, b, decimals, rounding);
	}


	// 舍位加法
	public static BigDecimal addDown(Object a, Object b) throws RuntimeException {
		return addBase(a, b, downDecimals, downRounding);
	}

	// 舍位减法
	public static BigDecimal subtractDown(Object a, Object b) throws RuntimeException {
		return subtractBase(a, b, downDecimals, downRounding);
	}

	// 舍位乘法
	public static BigDecimal multiplyDown(Object a, Object b) throws RuntimeException {
		return multiplyBase(a, b, downDecimals, downRounding);
	}

	// 舍位除法
	public static BigDecimal divideDown(Object a, Object b) throws RuntimeException {
		return divideBase(a, b, downDecimals, downRounding);
	}

	// 向上取整加法
	public static BigDecimal addUp(Object a, Object b) throws RuntimeException {
		return addBase(a, b, upDecimals, upRounding);
	}

	// 向上取整减法
	public static BigDecimal subtractUp(Object a, Object b) throws RuntimeException {
		return subtractBase(a, b, upDecimals, upRounding);
	}

	// 向上取整乘法
	public static BigDecimal multiplyUp(Object a, Object b) throws RuntimeException {
		return multiplyBase(a, b, upDecimals, upRounding);
	}

	// 向上取整除法
	public static BigDecimal divideUp(Object a, Object b) throws RuntimeException {
		return divideBase(a, b, upDecimals, upRounding);
	}

	// 向上取整截取
	public static BigDecimal transUp(Object a) throws RuntimeException {
		return transBase(a, upDecimals, upRounding);
	}


	// 向下取整加法
	public static BigDecimal addDownInt(Object a, Object b) throws RuntimeException {
		return addBase(a, b, roundDownDecimals, roundDownRounding);
	}

	// 向下取整减法
	public static BigDecimal subtractDownInt(Object a, Object b) throws RuntimeException {
		return subtractBase(a, b, roundDownDecimals, roundDownRounding);
	}

	// 向下取整乘法
	public static BigDecimal multiplyDownInt(Object a, Object b) throws RuntimeException {
		return multiplyBase(a, b, roundDownDecimals, roundDownRounding);
	}

	// 向下取整除法
	public static BigDecimal divideDownInt(Object a, Object b) throws RuntimeException {
		return divideBase(a, b, roundDownDecimals, roundDownRounding);
	}

	// 向下取整截取
	public static BigDecimal transDownInt(Object a) throws RuntimeException {
		return transBase(a, roundDownDecimals, roundDownRounding);
	}

	// 向下取保留5位加法
	public static BigDecimal addFiveDown(Object a, Object b) throws RuntimeException {
		return addBase(a, b, fiveDecimals, roundDownRounding);
	}

	// 向下保留5位减法
	public static BigDecimal subtractFiveDown(Object a, Object b) throws RuntimeException {
		return subtractBase(a, b, fiveDecimals, roundDownRounding);
	}

	// 向下保留5位乘法
	public static BigDecimal multiplyFiveDown(Object a, Object b) throws RuntimeException {
		return multiplyBase(a, b, fiveDecimals, roundDownRounding);
	}

	// 向下保留5位除法
	public static BigDecimal divideFiveDown(Object a, Object b) throws RuntimeException {
		return divideBase(a, b, fiveDecimals, roundDownRounding);
	}

	// 向下保留5位截取
	public static BigDecimal transFiveDown(Object a) throws RuntimeException {
		return transBase(a, fiveDecimals, roundDownRounding);
	}

	public static BigDecimal getAbs(Object a) {
		return conversionToBigDecimal(a).abs();
	}
}
