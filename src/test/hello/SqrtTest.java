package test.hello;

public class SqrtTest {

    private static int count = 0;
    /**
     * 对v开根号，要求误差小于等于t
     */
    public static double sqrt(int v, double t){
        if(v < 0){
            throw new IllegalArgumentException("v must >= 0");
        }

        for(int i = 0;i < v;i++){
            count++;
            if(i * i == v){
                return i;
            }
            if(i * i < v && (i + 1) * (i + 1) > v){
                return sqrt(v, (double)(i), (double)(i+1), t);
            }
        }
        return -1d;
    }
    private static double sqrt(int v, double min, double max, double t){
        count++;
        if(max - min < t){
            return (min + max) / 2;//返回max或者min也行
        }
        double mid = (min + max) / 2;
        if(mid * mid > v){
            return sqrt(v, min, mid, t);
        }else{
            return sqrt(v, mid, max, t);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        double d = sqrt(v, 0.000000001);
        System.out.println(d);
        System.out.println(Math.abs(d - Math.sqrt(v)));
        System.out.println(count);
    }
}
