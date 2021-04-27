package nowcoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char a = sc.next().charAt(0);
        int[] low = new int[26];
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z'){
                low[c - 'a']++;
            }else if(c >= 'A' && c <= 'Z'){
                low[c - 'A']++;
            }
        }
        if(a >= 'a' && a <= 'z'){
            System.out.println(low[a - 'a']);
        }else{
            System.out.println(low[a - 'A']);
        }
    }
}
