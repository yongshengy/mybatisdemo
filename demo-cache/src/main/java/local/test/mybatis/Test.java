package local.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Test.class.getClassLoader().getResourceAsStream("config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
        Classes classes = classesMapper.findById(1);
        System.out.println(classes);
        // second
        Classes classes1 = classesMapper.findById(1);
        System.out.println(classes1);
        // 一级缓存是在SqlSession中
        sqlSession.close();

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        ClassesMapper classesMapper1 = sqlSession1.getMapper(ClassesMapper.class);
        Classes classes2 = classesMapper1.findById(1);
        System.out.println(classes2);
//        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ClassesMapper classesRepository = sqlSession.getMapper(ClassesMapper.class);
//        Classes classes = classesRepository.findById(1);
//        System.out.println(classes);
//        sqlSession.close();
//        sqlSession = sqlSessionFactory.openSession();
//        classesRepository = sqlSession.getMapper(ClassesMapper.class);
//        Classes classes2 = classesRepository.findById(1);
//        System.out.println(classes2);
//        sqlSession.close();

    }
}
