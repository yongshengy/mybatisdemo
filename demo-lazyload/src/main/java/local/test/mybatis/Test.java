package local.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

    public static void main(String[] args) {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Test.class.getClassLoader().getResourceAsStream("config.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
        Order order = orderRepository.findById(1);
        System.out.println(order.getName());
        System.out.println(order.getCustomer().getName());
    }
}
