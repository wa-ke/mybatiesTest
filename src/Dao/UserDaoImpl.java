package Dao;

import ClassMap.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {


        //SqlSession线程不安全，在方法体内创建
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return user;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        user.setUserName("钱八");
        user.setSex('1');
        user.setDate(new Date());
        user.setAddress("河南洛阳");
        sqlSession.insert("test.insertIntoUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser",id);

        //提交事务
        sqlSession.commit();


        sqlSession.close();
    }
}
