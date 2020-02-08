package Demo05;

import Demo01.User;

import java.util.List;

public interface OrdersMapperCustom {

    List<OrdersCustom> findOrdersUser();

    List<Orders> findOrdersUserResultMap();

    List<Orders> findOrdersAndOrdersDetails();

    List<User> findUserAndOrderDetials();
}
