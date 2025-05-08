import java.util.Scanner;
import java.math.*;
public class Function_Overloading_Example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(area(7));
        System.out.println(area(10,10));
    }
    // function area calculates area of circle, and area of rectangle.
    public static float area(int r)
    {
        return (float) (Math.PI*r*r);
    }
    public static float area(int length, int breadth)
    {
        return length*breadth;
    }
}
