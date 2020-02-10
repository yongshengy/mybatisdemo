package local.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NewTest {

    public static void main(String[] args) {
        // 多表查询
        // 一对多
        // 多对多

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(NewTest.class.getClassLoader().getResourceAsStream("config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        NewStudentMapper newStudentMapper = sqlSession.getMapper(NewStudentMapper.class);
        NewStudent newStudent = newStudentMapper.findById(1);
        System.out.println(newStudent);

        ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
        Classes classes = classesMapper.findById(1);
        System.out.println(classes.getNewStudents().size());

        // 多对多 就是两边都是 collections



    }
}
