package Demo04;


import java.util.List;

//综合查询类
public class UserQueryVo {
    //写入要查询的属性
    private UserCustomer userCustomer;

    private List<Integer> integers;

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public UserCustomer getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(UserCustomer userCustomer) {
        this.userCustomer = userCustomer;
    }

}
