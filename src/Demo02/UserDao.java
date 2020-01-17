package Demo02;

import Demo01.User;

public interface UserDao {
    //根据id查询
    User findUserById(int id);
    //添加
    void addUser(User user);
    //删除
    void delUser(int id);
    //更新
    void updateUser(User user);
}
