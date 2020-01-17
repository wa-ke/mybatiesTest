package Demo03;

import Demo01.User;
import Demo04.UserCustomer;
import Demo04.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class UserTest {


    @Test
    public void findUserById() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建mapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法

        User user = userMapper.findUserById(1);

        System.out.println(user);

        sqlSession.close();

    }

    //用户信息的综合查询
    @Test
    public void findUserList() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建mapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setName("s");
        userCustomer.setPassword("a");

        userQueryVo.setUserCustomer(userCustomer);

        List<UserCustomer> userCustomers =  userMapper.findUserList(userQueryVo);

        System.out.println(userCustomers);

    }
    //用户信息的综合总数查询
    @Test
    public void findUserCount() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建mapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setName("s");
        userCustomer.setPassword("a");

        userQueryVo.setUserCustomer(userCustomer);

        int count =  userMapper.findUserCount(userQueryVo);

        System.out.println(count);

    }
}
