//  B. Make it Divisible by 25

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String n = br.readLine();
            List<String> possible_values = new ArrayList<>(Arrays.asList("00", "25", "50", "75"));
            int ans = Integer.MAX_VALUE;
            for (String possibleValue : possible_values) {
                ans = min(ans, min_Operations(n, possibleValue));
            }
            pw.println(ans);



        }
        pw.flush();
        pw.close();
        br.close();

    }

    public static int min_Operations(String n, String possibleValues) {
        int operations = 0;
        int checker_Index = possibleValues.length() - 1;
        for (int i = n.length() - 1; i >= 0; i--){
            if (n.charAt(i) == possibleValues.charAt(checker_Index)){
                checker_Index--;
                if (checker_Index<0)
                    break;
            }
            else
                operations++;
        }
        if (checker_Index >= 0)
            operations = Integer.MAX_VALUE;
        return operations;

    }
}