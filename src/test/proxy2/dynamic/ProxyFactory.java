package test.proxy2.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object obj){
        this.target = obj;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object res = null;
                try {
                    res = method.invoke(target, args);
                    System.out.println("提交事务");
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("事务回滚");
                }
                return res;
            }
        });
    }
}
