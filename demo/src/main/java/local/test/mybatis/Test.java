package local.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {

    public static void main(String[] args) {
        /**
         * 使用原生接口执行sql
         */
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "local.test.mybatis.UserMapper.get";
        User user = sqlSession.selectOne(statement, 1);
        System.out.println(user.getUsername());

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.get(1);
        System.out.println(user1.getUsername());

    }
}
