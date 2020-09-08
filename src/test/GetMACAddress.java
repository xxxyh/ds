package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class GetMACAddress {
    public String getMACAddress(String ipAddress) {
        String str, strMAC = "", macAddress;
        try {
            Process pp = Runtime.getRuntime().exec("nbtstat -a " + ipAddress);
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        strMAC = str.substring(str.indexOf("MAC Address") + 14);
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Can't Get MAC Address!";
        }

        if (strMAC.length() < 17) {
            return "Error!";
        }
        macAddress = strMAC.substring(0, 2) + ":"
                + strMAC.substring(3, 5) + ":"
                + strMAC.substring(6, 8) + ":"
                + strMAC.substring(9, 11) + ":"
                + strMAC.substring(12, 14) + ":"
                + strMAC.substring(15, 17);

        return macAddress;
    }

    public static void main(String[] args) {
        GetMACAddress getMACAddress = new GetMACAddress();
        System.out.println(getMACAddress.getMACAddress("39.108.145.221"));

        try {
            java.lang.Process proc = Runtime.getRuntime().exec("ipconfig /all");
            InputStream istr = proc.getInputStream();
            byte[] data = new byte[1024];
            istr.read(data);
            String netdata = new String(data);
            System.out.println("Your Mac Address=" + procAll(netdata));
        } catch (IOException e) {
            System.out.println("error=" + e);
        }
    }

    public static String procAll(String str) {
        return procStringEnd(procFirstMac(procAddress(str)));
    }

    public static String procAddress(String str) {
        int indexof = str.indexOf("Physical Address");
        if (indexof > 0) {
            return str.substring(indexof);
        }
        return str;
    }

    public static String procFirstMac(String str) {
        int indexof = str.indexOf(":");
        if (indexof > 0) {
            return str.substring(indexof + 1).trim();
        }
        return str;
    }

    public static String procStringEnd(String str) {
        int indexof = str.indexOf("/r");
        if (indexof > 0) {
            return str.substring(0, indexof).trim();
        }
        return str;
    }
}