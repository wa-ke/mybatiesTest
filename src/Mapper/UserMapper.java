package Mapper;

import ClassMap.User;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id);

    public List<User> findUserName(String s);

    public void insertIntoUser(User user);

    public void deleteUser(int id);

    public void updateUserById(User user);
}


//          mapper构建方法
//          xml中的namespace的等于mapper的接口地址
//          方法名和statement中的id一致
//          mapper不需要创建实现类，自动生成代理对象