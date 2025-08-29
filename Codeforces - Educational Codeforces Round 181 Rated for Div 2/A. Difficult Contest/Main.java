//  A. Difficult Contest

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            char[] input = s.toCharArray();
            Arrays.sort(input);
            pw.println(new StringBuilder(new String(input)).reverse());
        }
        pw.flush();
        pw.close();
        br.close();
    }
}