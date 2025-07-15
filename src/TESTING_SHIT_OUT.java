public class TESTING_SHIT_OUT {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(check_power_of_2(n));
    }
    public static boolean check_power_of_2(int n){
        int check = n & (n - 1);
        return check == 0;
    }
}