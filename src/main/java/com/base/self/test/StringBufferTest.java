package com.base.self.test;

/**
 * @author libo
 * invokespecial: 调用一个初始化(构造)方法，私有方法或者父类的方法
 * invokestatic:调用静态方法
 * invokevirtual:调用实例方法
 * invokeinterface：调用接口方法
 * StringBuffer中的方法大都采用了 synchronized 关键字进行修饰，因此是线程安全的，而 StringBuilder 没有这个修饰，可以被认为是线程不安全的。
 */
public class StringBufferTest {
	
	public String appendStr(String str, String... appendStrs) {
		if (appendStrs == null || appendStrs.length == 0) {
			return str;
		}

		for (String appendStr : appendStrs) {
			str += appendStr;
		}
		/**
		 * 35: invokestatic #20 // Method
		 * java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String; 38:
		 * invokespecial #26 // Method
		 * java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
		 */
		return str;
	}
	
	public String appendStrByStringBuffer(StringBuffer str, String... appendStrs) {
		if (appendStrs == null || appendStrs.length == 0) {
			return str.toString();
		}
		
		for (String appendStr : appendStrs) {
			str.append(appendStr);
		}
		/**
		 	35: invokevirtual #47                 // Method java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
		 */
		return str.toString();
	}
}
