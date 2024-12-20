import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class freq {
    public static int[] freqArr(String vc) {
        int mp[] = new int[26];
        for(int i=0;i<vc.length();i++){
            mp[vc.charAt(i)-97]++;
        }
        return mp;
    }

    public static void main(String[] args) {
        String vc = "codestock";
        int[] mp = freqArr(vc);
        for (int i = 0; i < 26; i++)
            System.out.println((char)(i + 97) + " " + mp[i]);
    }
}