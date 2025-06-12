public class factorUsingRoot {
    public static void main(String[] args) {
        factorUsingRoot obj = new factorUsingRoot();
        obj.Factor(36);
    }
    public void Factor(int n )
    {
        for (int i = 1; i <=Math.sqrt(n) ; i++) {
            if (n%i==0)
            {
                System.out.println(i+ " "+(n/i));
            }
        }
    }
}
