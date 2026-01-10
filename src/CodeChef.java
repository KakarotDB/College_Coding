import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(st.nextToken()));
            }
            int count = 0;

            for(int i = n; i >= 1; i--) {
                int pos = a.indexOf((long)i);
                int right = a.size() - pos - 1;
                count += Math.min(pos, right);
                a.remove(pos);
            }
            pw.println(count);
        }
        pw.flush();
        pw.close();
        br.close();
	}
}
