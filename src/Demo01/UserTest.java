package Demo01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserTest {

    //根据id进行查询
    @Test
    public void findUserById() throws IOException {
        //创建会话工厂，引入Config文件
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession操纵数据库,输入statement 的id值："test.findUserById"
        User user = sqlSession.selectOne("test.findUserById",1);

        System.out.println(user);

        sqlSession.close();

    }

    //模糊查询列表
    @Test
    public void findUserByName() throws IOException {
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("test.findUserByName","s");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    //添加用户
    @Test
    public void addUser() throws IOException {
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setName("ww");
        user.setPassword("asdhkjh");
        user.setBirthday(new Date());

        sqlSession.insert("test.addUser",user);

        //提交事务
        sqlSession.commit();

        System.out.println(user.getId());
        sqlSession.close();
    }

    //删除用户
    @Test
    public void delUser() throws IOException {
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.delUser",8);

        sqlSession.commit();
        sqlSession.close();
    }

    //更新用户
    @Test
    public void updateUser() throws IOException {
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();

        //设置要更改的id
        user.setId(7);

        //设置要更改的属性值
        user.setName("sl");
        user.setPassword("qweac");
        user.setBirthday(new Date());

        sqlSession.update("test.updateUser",user);

        sqlSession.commit();
        sqlSession.close();
    }
}
