package Demo03;

import Demo01.User;
import Demo04.UserCustomer;
import Demo04.UserQueryVo;

import java.util.List;

public interface UserMapper {
    //根据id查询
    User findUserById(int id);
    //添加
    void addUser(User user);
    //删除
    void delUser(int id);
    //更新
    void updateUser(User user);
    //查询多条 mybatis根据返回对象自动判断使用selectOne还是select
    // 但是查询到多条的返回值有多条，使用selectOne将会报记录条数错误
    List<User> findUserByName(String s);

    //综合查询
    List<UserCustomer> findUserList(UserQueryVo userQueryVo);

    //综合总数查询
    int findUserCount(UserQueryVo userQueryVo);

    //resultMap查询
    User findUserByIdResultMap(int id);
}
