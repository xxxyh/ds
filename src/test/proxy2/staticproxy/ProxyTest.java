package test.proxy2.staticproxy;

import test.proxy2.UserDao;

public class ProxyTest {
    public static void main(String[] args) {
        UserDao target = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
