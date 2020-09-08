package test.proxy.dynamicproxy;

public class IronManVIPMovie implements VIPMovie {
    @Override public void vipPlay() {
        System.out.println("vip影厅正在播放的电影是《钢铁侠》");
    }
}
