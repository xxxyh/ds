package leetcode;

public class Solution468 {
    public String validIPAddress(String IP) {
        if(isIpv4(IP)){
            return "IPv4";
        }else if(isIpv6(IP)){
            return "IPv6";
        }else{
            return "Neither";
        }
    }

    private boolean isIpv4(String ip){
        if(ip.endsWith(".")){
            return false;
        }
        String[] splits = ip.split("\\.");
        if(splits.length != 4){
            return false;
        }
        for(String split : splits){
            if(split.length() < 1 || split.length() > 3){
                return false;
            }
            if(split.length() != 1 && split.charAt(0) == '0'){
                return false;
            }
            for(int i = 0;i < split.length();i++){
                char c = split.charAt(i);
                if(c > '9' || c < '0'){
                    return false;
                }
            }
            Integer val = Integer.valueOf(split);
            if(val > 255){
                return false;
            }
        }
        return true;
    }
    private boolean isIpv6(String ip){
        if(ip.endsWith(":")){
            return false;
        }
        String[] splits = ip.split(":");
        if(splits.length != 8){
            return false;
        }
        for(String split : splits){
            if(split.length() < 1 || split.length() > 4){
                return false;
            }

            for(int i = 0;i < split.length();i++){
                char c = split.charAt(i);
                if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution468().validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
    }
}

