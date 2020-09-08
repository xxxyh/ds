package test;

import java.io.IOException;
import java.util.Scanner;

public class CPUTest {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Process process = Runtime.getRuntime()
                .exec("dmidecode -t processor | grep 'ID'");
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        System.out.println(property + ": " + serial);

        System.out.println("time:" + (System.currentTimeMillis() - start));

    }

}