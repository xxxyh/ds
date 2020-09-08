package test.proxy.staticproxy;

public class MovieStaticProxy implements Movie {
    Movie movie;

    public MovieStaticProxy(Movie movie){
        this.movie = movie;
    }

    @Override
    public void play() {
        playStart();
        movie.play();
        playEnd();
    }

    private void playStart(){
        System.out.println("电影开始前播放广告");
    }

    private void playEnd(){
        System.out.println("电影结束了，继续播放广告");
    }

}
