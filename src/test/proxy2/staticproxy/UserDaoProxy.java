package test.proxy2.staticproxy;

import test.proxy2.IUserDao;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao dao){
        this.target = dao;
    }

    @Override public void save() {
        System.out.println("开启事务");
        try {
            target.save();
            System.out.println("提交事务");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("事务回滚");
        }
    }
}
