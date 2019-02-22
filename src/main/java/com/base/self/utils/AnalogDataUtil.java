package utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author libo 模拟数据util
 */
public class AnalogDataUtil {

	public final static Map<Integer, Integer> MONRY_MAP = new HashMap<Integer, Integer>() {
		private static final long serialVersionUID = 1L;
		{
			put(0, 30);
			put(1, 50);
			put(2, 100);
			put(3, 200);
		}
	};

	/**
	 * 生成随机手机号 ex:134****7865
	 * 
	 * @return
	 */
	public static String getRandomPhone() {
		Random random = new Random();
		String telFirst = "139,138,137,136,135,134,150,151,152,157,158,159,182,183,187,188,147,182,"
				+ "130,131,132,136,185,186,145,133,153,180,189,177";
		String[] telFirsts = telFirst.split(",");
		// 随机前缀号码段
		int index = random.nextInt(telFirsts.length - 1);
		// 随机后缀号码段1~9100
		int endNum = random.nextInt(9100) + 10001;
		// 拼接手机号
		String first = telFirsts[index];
		String second = "****";
		String third = String.valueOf(endNum).substring(1);
		return first + second + third;
	}

	/**
	 * 生成随机金额30,50,100
	 * 
	 * @return
	 */
	public static int getRandomMoney() {
		int random = new Random().nextInt(3);
		return MONRY_MAP.get(random);
	}

	/**
	 * 按照一定比例生成金额
	 * 
	 * @return
	 */
	public static int getRandomMoneyWithRate() {
		return MONRY_MAP.get(percentageRandom());
	}

	/**
	 * 0出现的概率为%90
	 */
	public static double rate0 = 0.90;
	/**
	 * 1出现的概率为%5
	 */
	public static double rate1 = 0.05;
	/**
	 * 2出现的概率为%3
	 */
	public static double rate2 = 0.03;
	/**
	 * 3出现的概率为%2
	 */
	public static double rate3 = 0.02;

	/**
	 * Math.random()产生一个double型的随机数，判断一下 例如0出现的概率为%50，则介于0到0.50中间的返回0
	 * 
	 * @return int
	 * 
	 */
	public static int percentageRandom() {
		double randomNumber;
		randomNumber = Math.random();
		if (randomNumber >= 0 && randomNumber <= rate0) {
			return 0;
		} else if (randomNumber >= rate0 && randomNumber <= rate0 + rate1) {
			return 1;
		} else if (randomNumber >= rate0 + rate1 && randomNumber <= rate0 + rate1 + rate2) {
			return 2;
		} else if (randomNumber >= rate0 + rate1 + rate2 && randomNumber <= rate0 + rate1 + rate2 + rate3) {
			return 3;
		}
		return 0; // 默认返回0
	}
	
	/** 
     * 获取随机日期 
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @return Date
	 * @throws Exception 
     */  
	public static Date randomDate(Date start, Date end) throws Exception {

		if (start.getTime() >= end.getTime()) {
			return null;
		}

		long date = random(start.getTime(), end.getTime());

		return new Date(date);
	}  
      
    public static long random(long begin,long end){  
        long rtn = begin + (long)(Math.random() * (end - begin));  
        if(rtn == begin || rtn == end){  
            return random(begin,end);  
        }  
        return rtn;  
    }  
	
    
	/**
	 * 添加新手连续五天签到零钱
	 * @param userid
	 * 1.5-3元零钱红包 60%
	 * 3-4元零钱红包 20%
	 * 4-5元零钱红包 20%
	 */
	public static void addFiveSignWalletMoney(String userid) {
		Integer addMoney = 0;
		double rate0 = 0.60d;
		double rate1 = 0.20d;
		double rate2 = 0.20d;
		double randomNumber;
		Random ra = new Random();
		randomNumber = Math.random();
		if (randomNumber >= 0 && randomNumber <= rate0) {
			addMoney = (int) ((ra.nextDouble() * 1.5 + 1.5) * 100);
		} else if (randomNumber >= rate0 && randomNumber <= rate0 + rate1) {
			addMoney = (int) ((ra.nextDouble() + 3) * 100);
		} else if (randomNumber >= rate0 + rate1 && randomNumber <= rate0 + rate1 + rate2) {
			addMoney = (int) ((ra.nextDouble() + 4) * 100);
		}
		System.out.println(addMoney);
	}
    
	/**
	 * 测试
	 */
	public static void main(String[] agrs) {
		int i = 0;
		// java.lang.Math.random() 返回一个正符号的double值，大于或等于0.0且小于1.0
		for (i = 0; i <= 100; i++)// 打印100个测试概率的准确性
		{
			System.out.println(AnalogDataUtil.percentageRandom());
		}
	}
	
}
