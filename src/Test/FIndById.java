package Test;

import ClassMap.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FIndById {


    //根据id查询
    public static void findUserById() throws IOException {

        //获取到xml文件流
        InputStream inputStream = Resources.getResourceAsStream("Config/Configure.xml");

        //创建session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建session
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //获取到单条记录，
        User user = sqlSession.selectOne("test.findUserById",1);



        System.out.println(user);


        sqlSession.close();
    }

    //根据用户名模糊查询
    public static void findUserByName() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Config/Configure.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();




        //查询多条记录时,需要使用容器类,
        List<User> user = sqlSession.selectList("test.findUserName","五");


//        List<User> user = sqlSession.selectList("test.findUserName","%五%");

        for (Iterator<User> iterator = user.iterator(); iterator.hasNext(); ) {
            User next =  iterator.next();
            System.out.println(next);
        }

        sqlSession.close();
    }
    //添加用户
    public static void insertIntoUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Config/Configure.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUserName("钱七");
        user.setSex('1');
        user.setDate(new Date());
        user.setAddress("河北天津");
        sqlSession.insert("test.insertIntoUser",user);

        //提交事务
        System.out.println(user.getId());
        sqlSession.commit();


        sqlSession.close();
    }
    //删除用户
    public static void deleteUserById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Config/Configure.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser",1);

        //提交事务
        sqlSession.commit();


        sqlSession.close();
    }

    //更改用户信息
    public static void updateUserById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Config/Configure.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        User user = new User();
        user.setId(2);
        user.setUserName("张三");
        user.setSex('1');
        user.setDate(new Date());
        user.setAddress("河北天津");


        sqlSession.delete("test.updateUserById",user);

        //提交事务
        sqlSession.commit();


        sqlSession.close();
    }

    public static void main(String[] args) throws IOException {
//        findUserById();
//        findUserByName();
//            insertIntoUser();

//        deleteUserById();

        updateUserById();
    }
}
