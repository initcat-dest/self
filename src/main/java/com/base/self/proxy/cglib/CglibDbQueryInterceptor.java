package com.base.self.proxy.cglib;

import com.base.self.proxy.DBQuery;
import com.base.self.proxy.IDBQuery;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDbQueryInterceptor implements MethodInterceptor {
    IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null) {
            real = new DBQuery(); // 如果是第一次调用，则生成真是对象}
        }
        return real.request(); // 使用真实主题完成实际的操作
    }
}
