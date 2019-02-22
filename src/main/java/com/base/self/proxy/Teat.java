package com.base.self.proxy;

import com.base.self.proxy.cglib.CglibDbQueryInterceptor;
import com.base.self.proxy.javassist.JavassistDynDbQueryHandler;
import com.base.self.proxy.jdkproxy.JDKQueryHandle;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Teat {
	public static void main(String[] args) {
		IDBQuery query = new DBQueryProxy(); // 使用代理
//		query.request(); // 在真正使用时才创建真是对象
		System.out.println(query.request());
	}
	
	public static IDBQuery createJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IDBQuery.class}
		, new JDKQueryHandle());
		return jdkProxy;
	}
	
	public static IDBQuery createCglibProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDbQueryInterceptor()); // 指定切入期，定义代理类逻辑
		enhancer.setInterfaces(new Class[] {IDBQuery.class}); // 指定实现的接口
		IDBQuery cglibProxy = (IDBQuery) enhancer.create(); // 生成代理类的实例
		return cglibProxy;
	}
	
	/**
	 * 使用代理工厂创建
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static IDBQuery createJavassistDynProxy() throws InstantiationException, IllegalAccessException {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class[] {IDBQuery.class});
		Class proxyClass = proxyFactory.createClass();
		IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
		((ProxyObject)javassistProxy).setHandler(new JavassistDynDbQueryHandler());
		return javassistProxy;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {
		return null;
	}
	
}
