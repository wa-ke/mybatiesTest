package Demo05;

import Demo01.User;
import Demo03.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class OrderTest {
//    一对一查询 ,resultType
    @Test
    public void findOrdersUser() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建mapper对象,mybatis自动生成mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();

        System.out.println(list);
        sqlSession.close();
    }
//    resultMap
    @Test
    public void findOrdersUserResultMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建mapper对象,mybatis自动生成mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> orders = ordersMapperCustom.findOrdersUserResultMap();

        System.out.println(orders);

        sqlSession.close();

    }
//    一对多
@Test
public void findOrdersAndOrdersDetails() throws IOException {
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
            build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //创建mapper对象,mybatis自动生成mapper代理对象
    OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

    List<Orders> orders = ordersMapperCustom.findOrdersAndOrdersDetails();

    System.out.println(orders);

    sqlSession.close();

}
//多对多查询
    @Test
    public void findUserAndOrderDetials() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("Config/sqlMapperConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建mapper对象,mybatis自动生成mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<User> users = ordersMapperCustom.findUserAndOrderDetials();
        System.out.println(users);

        sqlSession.close();

    }
}
