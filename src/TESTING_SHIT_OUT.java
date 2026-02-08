import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TESTING_SHIT_OUT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        pw.println(Arrays.toString(a.toArray()));
        for(int i = 0; i < 3; i++) a.addFirst(a.removeLast());
        pw.println(Arrays.toString(a.toArray()));
        pw.flush();
        pw.close();
    }
}
