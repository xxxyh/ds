package test.proxy.staticproxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        Movie movie = new CaptainAmericaMovie();
        MovieStaticProxy proxy = new MovieStaticProxy(movie);
        proxy.play();
    }
}
