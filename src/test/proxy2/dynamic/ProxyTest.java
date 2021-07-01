package test.proxy2.dynamic;

import test.proxy2.IUserDao;
import test.proxy2.UserDao;

public class ProxyTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getClass());
        ProxyFactory factory = new ProxyFactory(userDao);
        IUserDao proxy = (IUserDao) factory.getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
