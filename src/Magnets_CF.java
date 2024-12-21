import java.util.*;
public class Magnets_CF
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(),c=1,a=sc.nextInt(),b;
        for(int i=1;i<n;i++)
        {
            b=sc.nextInt();
            if(a!=b)
                c++;
            a=b;
        }
        System.out.print(c);
    }
}