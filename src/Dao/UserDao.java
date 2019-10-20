package Dao;

import ClassMap.User;

public interface UserDao {

    //保持健壮性，抛异常
    public User findUserById(int id) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;
}
