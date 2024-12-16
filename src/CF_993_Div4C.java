import java.util.Scanner;

public class CF_993_Div4C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0)
        {
            int answer = 0;
            int m = sc.nextInt();int a = sc.nextInt();int b = sc.nextInt(); int c = sc.nextInt();
            if (m>=a && m>=b)
            {
                answer=a+b;
                answer+=Math.min((m-a)+(m-b),c);
            }
            else if (m>=a && m<b) {
                answer=a+m;
                answer+=Math.min(m-a,c);
                
            } else if (m<a && m<b) {
                answer=m+m;

            }
            else
            {
                answer+=b;
                answer +=m;
                answer+=Math.min(m-b,c);
            }
            System.out.println(answer);

        }
        sc.close();
    }
}
