//  Creating Strings

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static String s;
    static List<String> permutations = new ArrayList<>();
    static int[] charCount = new int[26];
    static void search(String current)
    {
        if (current.length() == s.length()) {
            permutations.add(current);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0)
            {
                charCount[i]--;
                search(current + (char)(i+'a'));
                charCount[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)- 'a']++;
        }
        search("");
        System.out.println(permutations.size());
        for (String permutation : permutations)
            System.out.println(permutation);


    }
}