import java.util.Arrays;
import java.util.Scanner;

public class BuySellStocks_APNADSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Maximum profit is : " +
                maximum_Profit_Possible(prices));
    }
    //Below is O(n) approach
    public static int maximum_Profit_Possible(int[] prices) {
        if (Trapping_Rainwater_APNADSA.isDescending(prices) || isAllPricesSame(prices))
           return 0;
        int day = 0 ;
        int minimum_buy_Price = prices[0];
        int sell_Price = 0;
        int max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            minimum_buy_Price = Math.min(minimum_buy_Price, prices[i]);
            sell_Price = prices[i];
//            max_profit = Math.max(max_profit, (sell_Price - minimum_buy_Price));
            if ((sell_Price - minimum_buy_Price) > max_profit)
            {
                max_profit =(sell_Price-minimum_buy_Price);
                day = i;
            }
        }
        System.out.println("Maximum profit can be achieved on day " + (day+1));
        return max_profit;
    }

    //Given below is an O(n^2) solution
//    static int maximum_Profit_Possible(int[] prices)
//    {
//        if (Trapping_Rainwater_APNADSA.isDescending(prices) || isAllPricesSame(prices))
//            return 0;
//        int max_profit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            int current_Profit = 0;
//            for(int j = i+1; j < prices.length; j++)
//            {
//                current_Profit = prices[j] - prices[i]; //calculating current profit from current day to future day
//                max_profit = Math.max(max_profit, current_Profit); //finding which one is maximum
//            }
//        }
//        return max_profit;
//    }
    static boolean isAllPricesSame(int[] prices) //checks to see if all prices are same
    {
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] != prices[i+1])
                return false;
        }
        return true;
    }

}