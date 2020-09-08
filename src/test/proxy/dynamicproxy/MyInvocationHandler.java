package test.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object object;

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        playStart();
        Object invoke = method.invoke(object, args);
        playEnd();
        return invoke;
    }

    public MyInvocationHandler(Object object){
        this.object = object;
    }

    private void playStart(){
        System.out.println("电影开始前播放广告");
    }

    private void playEnd(){
        System.out.println("电影结束了，继续播放广告");
    }
}
