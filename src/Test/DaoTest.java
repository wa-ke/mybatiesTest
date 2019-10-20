package Test;

import ClassMap.User;
import Dao.UserDao;
import Dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DaoTest {




    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("Config/Configure.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        //查找
        User user = userDao.findUserById(5);
        System.out.println(user);

    }
}
