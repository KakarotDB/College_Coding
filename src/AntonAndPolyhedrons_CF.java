import java.util.Scanner;

public class AntonAndPolyhedrons_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number_of_faces = 0;
        while (n-->0)
        {
            char ch = sc.next().charAt(0);
            switch (ch)
            {
                case 'T':
                    number_of_faces+=4;
                    break;
                case 'C':
                    number_of_faces+=6;
                    break;
                case 'O':
                    number_of_faces+=8;
                    break;
                case 'D':
                    number_of_faces+=12;
                    break;
                case 'I':
                    number_of_faces+=20;
                    break;

            }

        }
        System.out.println(number_of_faces);
    }
}
