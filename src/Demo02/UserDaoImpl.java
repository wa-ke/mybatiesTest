package Demo02;

import Demo01.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {


    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return user;
    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.addUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delUser(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.delUser",id);
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //


        sqlSession.close();

    }
}
