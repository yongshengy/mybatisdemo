package local.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Test1.class.getClassLoader().getResourceAsStream("config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
       Account record = new Account();
       record.setId(1);
       record.setUsername("admin");
       record.setPassword("admin");
       record.setAge(10);
//        accountMapper.insert(record);
//        sqlSession.commit();

        AccountExample accountExample = new AccountExample();
        List<AccountExample.Criteria> oredCriteria = accountExample.getOredCriteria();
        AccountExample.Criteria criteria = new AccountExample.Criteria();
        criteria.andAgeBetween(0, 20);
        oredCriteria.add(criteria);

        List<Account> accounts = accountMapper.selectByExample(accountExample);
        System.out.println(accounts.size());

    }
}
