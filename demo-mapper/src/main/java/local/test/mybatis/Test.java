package local.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Test.class.getClassLoader().getResourceAsStream("config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 基本类型作为参数
        Student student = studentMapper.findById(1);
        System.out.println(student);

        // 包装类为参数
        Student student1 = studentMapper.findById1(1);
        System.out.println(student1);

        // String为参数
        Student student2 = studentMapper.findByName("yang");
        System.out.println(student2);

        // 多个参数 使用param1 param2 区分顺序
        Student student3 = studentMapper.findByIdAndName(1, "yang");
        System.out.println(student3);

        // 使用POJO对象作为参数 使用属性名读取参数 #{id}
        Student param = new Student();
        param.setId(1);
        param.setName("yang");
        Student student4 = studentMapper.findByStudent(param);
        System.out.println(student4);

        // ====================================================
        // 返回值类型

        // int 或者 java.lang.Integer , String , POJO
        int count = studentMapper.count();
        System.out.println(count);




    }
}
