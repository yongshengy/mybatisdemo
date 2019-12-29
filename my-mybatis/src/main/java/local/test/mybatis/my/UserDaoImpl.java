package local.test.mybatis.my;

import java.sql.*;

/**
 * JDBC的实现
 */
public class UserDaoImpl implements UserDao {

    public User get(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mybatisdemo";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from t_user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userid = resultSet.getInt(1);
                String name = resultSet.getString(2);
                resultSet.getString(3);
                User user = new User();
                user.setId(userid);
                user.setUsername(name);
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return user;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试JDBC
     * @param args
     */
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.get(1);
        System.out.println(user.getUsername());
    }
}
