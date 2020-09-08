package test;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class IpTest {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
            NetworkInterface netCard = NetworkInterface.getByInetAddress(address);
            byte[] addr = netCard.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < addr.length; i++) {
                if (addr[i] != 0) {
                    sb.append("-");
                }

                String string = Integer.toHexString(addr[i] & 0xff);
                sb.append(string.length() == 1 ? "0" + string : string);
            }
            System.out.println(sb.substring(1).toUpperCase());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
