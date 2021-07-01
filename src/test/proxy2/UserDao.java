package test.proxy2;

import test.proxy2.IUserDao;

import java.util.Random;

public class UserDao implements IUserDao {
    Random random = new Random();
    @Override public void save() {
        System.out.println("保存用户");
        int i = random.nextInt();
        if(i % 2 == 0){
            i = 1 / 0;
        }
    }
}
