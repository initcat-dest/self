package com.base.self.proxy.javassist;

import com.base.self.proxy.DBQuery;
import com.base.self.proxy.IDBQuery;
import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

public class JavassistDynDbQueryHandler implements MethodHandler {
	IDBQuery real = null;

	@Override
	public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
		if (real == null)
			real = new DBQuery();
		return real.request();
	}

}
