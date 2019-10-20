package Test;

import ClassMap.User;
import Mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;


public class UserMapperTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Config/Configure.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //自动生成代理对象，无需实现类


//        User u = userMapper.findUserById(2);

        List<User> u = userMapper.findUserName("五");
        for (Iterator<User> iterator = u.iterator(); iterator.hasNext(); ) {
            User next =  iterator.next();
            System.out.println(next);

        }
        sqlSession.close();


    }
}
