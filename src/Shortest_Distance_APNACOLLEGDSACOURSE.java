import java.util.Scanner;

public class Shortest_Distance_APNACOLLEGDSACOURSE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        path = path.toUpperCase();
        long count_of_North = path.chars().filter(ch->ch=='N').count();
        long count_of_South = path.chars().filter(ch->ch=='S').count();
        long count_of_West = path.chars().filter(ch->ch=='W').count();
        long count_of_East = path.chars().filter(ch->ch=='E').count();
        long y = count_of_North-count_of_South;
        long x = count_of_East-count_of_West;
        double distance = Math.sqrt((Math.pow(x,2)+Math.pow(y,2)));
        System.out.println(distance);
    }
}
