import java.util.Scanner;

public class Keyboard_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char shift = sc.next().charAt(0);
        String mole_input = sc.next();
        String row1 = "qwertyuiop", row2 = "asdfghjkl;", row3 = "zxcvbnm,./";
        String output = "";
//        System.out.println(shift+"\n"+mole_input);
        if (shift == 'R')
        {
            for (int i = 0; i < mole_input.length(); i++)
            {
                char ch = mole_input.charAt(i);
                if (row1.contains(Character.toString(ch)))
                    output+= row1.charAt(row1.indexOf(ch)-1);
                else if (row2.contains(Character.toString(ch)))
                {
                    output += row2.charAt(row2.indexOf(ch) - 1);
                }
                else
                    output+= row3.charAt(row3.indexOf(ch)-1);





            }

        }
        else
        {
            for (int i = 0; i < mole_input.length(); i++)
            {
                char ch = mole_input.charAt(i);
                if (row1.contains(Character.toString(ch)))
                    output+= row1.charAt(row1.indexOf(ch)+1);
                else if (row2.contains(Character.toString(ch)))
                {
                    output += row2.charAt(row2.indexOf(ch) + 1);
                }
                else
                    output+= row3.charAt(row3.indexOf(ch)+1);





            }

        }
        System.out.println(output);
        sc.close();

    }
}
