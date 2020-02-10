package local.test.mybatis.my;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyInvocationHandler implements InvocationHandler {

    public Object getInstance(Class cls) {
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[] { cls }, this);
        return newProxyInstance;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 类似UserDaoImpl, 这里需要读取数据库配置文件，得到连接信息，然后是Mapper文件，
        // 根据method，对应找到sql语句，和参数，返回值类型，执行sql，并返回
        // TODO ...
        // 1. read configuration file , and get the connection which will use
        Map<String, String> map = getC3p0Properties();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(map.get("driver"));
        dataSource.setJdbcUrl(map.get("url"));
        dataSource.setUser(map.get("username"));
        dataSource.setPassword(map.get("password"));
        dataSource.setInitialPoolSize(20);
        dataSource.setMaxPoolSize(40);
        dataSource.setMinPoolSize(2);
        dataSource.setAcquireIncrement(5);
        Connection connection = dataSource.getConnection();

        // 2. read the mappers files, and user the class + method, get the sql,

        // 3. user the connection execute the sql (use the params and resultset to the type(setter)), then return this value.




        return null;
    }
    public static Map<String, String> getC3p0Properties() {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(MyInvocationHandler.class.getResourceAsStream("/config.xml"));
            Element root = document.getRootElement();
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                if ("environments".equals(element.getName())) {
                    Iterator<Element> iterator1 = element.elementIterator();
                    while(iterator1.hasNext()) { // environment
                        Element element1 = iterator.next();
                        Iterator<Element> iterator2 = element1.elementIterator();
                        while(iterator2.hasNext()) {
                            Element element2 = iterator2.next();
                            if ("dataSource".equals(element2.getName())) {
                                if ("POOLED".equals(element2.attributeValue("type"))) {
                                    Iterator<Element> iterator3 = element2.elementIterator();
                                    while(iterator3.hasNext()) {
                                        Element element3 = iterator3.next();
                                        map.put(element3.attributeValue("name"), element3.attributeValue("value"));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }
}
