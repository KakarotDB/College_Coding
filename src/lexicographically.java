import java.util.Scanner;

public class lexicographically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter("[\\s,]+");
        String string1 = sc.nextLine();
        String string2 = sc.nextLine();
        if(string2.compareToIgnoreCase(string1)==0)
            System.out.println("0");
        else if (string2.compareToIgnoreCase(string1)>=0) {
            System.out.println("-1");
        }
        else
            System.out.println("1");
    }
}
