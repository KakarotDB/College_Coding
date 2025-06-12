//  B. Chemistry

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
            String input = br.readLine();
            int[] frequency_of_characters = new int[26];
            for (int i = 0; i < n; i++) {
                frequency_of_characters[input.charAt(i)-'a']++;
            }
            int number_of_odd_frequencies = 0;
            for (int i = 0; i < 26; i++) {
                number_of_odd_frequencies+=frequency_of_characters[i]%2;
            }
            if (number_of_odd_frequencies > k+1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }

    }
}