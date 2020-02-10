package local.test.mybatis.my;

public class Test {

    public static void main(String[] args) {
        UserDao userDao = (UserDao) new MyInvocationHandler().getInstance(UserDao.class); //not implement done
        User user = userDao.get(1);

    }
}
