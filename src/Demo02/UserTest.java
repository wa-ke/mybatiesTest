package Demo02;

import Demo01.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class UserTest {

    @Test
    public void findUserById() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

       User user = userDao.findUserById(1);

        System.out.println(user);
    }

}
