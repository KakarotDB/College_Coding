//  A. Boy or Girl

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        pw.println((int) input.chars().distinct().count() % 2 == 0 ?"CHAT WITH HER!" : "IGNORE HIM");
        pw.flush();
        pw.close();
        br.close();
    }

}