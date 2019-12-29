package local.test.mybatis.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    public Object getInstance(Class cls) {
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[] { cls }, this);
        return newProxyInstance;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 类似UserDaoImpl, 这里需要读取数据库配置文件，得到连接信息，然后是Mapper文件，
        // 根据method，对应找到sql语句，和参数，返回值类型，执行sql，并返回
        // TODO ...
        return null;
    }
}
