package test.proxy.dynamicproxy;

import test.proxy.staticproxy.CaptainAmericaMovie;
import test.proxy.staticproxy.Movie;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        //新版本 jdk产生代理类
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        VIPMovie vipMovie = new IronManVIPMovie();
        MyInvocationHandler handler = new MyInvocationHandler(vipMovie);
        VIPMovie vipMovieProxy = (VIPMovie) Proxy.newProxyInstance(IronManVIPMovie.class.getClassLoader(), IronManVIPMovie.class.getInterfaces(), handler);
        vipMovieProxy.vipPlay();

        Movie movie = new CaptainAmericaMovie();
        MyInvocationHandler handler1 = new MyInvocationHandler(movie);
        Movie movieProxy = (Movie) Proxy.newProxyInstance(CaptainAmericaMovie.class.getClassLoader(), CaptainAmericaMovie.class.getInterfaces(), handler1);
        movieProxy.play();
        System.out.println("VIP 影厅《钢铁侠》代理类：" + vipMovieProxy.getClass());
        System.out.println("普通影厅《美国队长》：" + movieProxy.getClass());
    }
}
