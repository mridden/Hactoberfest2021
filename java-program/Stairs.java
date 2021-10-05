class Main
{
 
    public static int tWays(int n)
    {
    
        if (n < 0) {
            return 0;
        }
 
       
        if (n == 0) {
            return 1;
        }
 
        return tWays(n - 1) + tWays(n - 2) + tWays(n - 3);
    }
 
    public static void main(String[] args)
    {
        int n = 4;
        System.out.printf("Total ways to reach the %d'th stair are %d",
                            n, tWays(n));
    }
}
