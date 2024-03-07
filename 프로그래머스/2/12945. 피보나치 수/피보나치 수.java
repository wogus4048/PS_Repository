import java.util.*;
import java.math.*;
class Solution {
    static BigInteger[] dp;
    public static int solution(int n) {
        int answer = 0;
        BigInteger input = new BigInteger(n+"");
        dp = new BigInteger[n+1];

        if(n==0) return 0;
        if(n==1) return 1;

        fibo(new BigInteger(n+""));
        return dp[n].intValue();

    }
    public static void fibo(BigInteger n)
    {
        dp[0] = new BigInteger(0+"");
        dp[1] = new BigInteger(1+"");

        for(int i=2;i<=n.intValue();i++)
        {
            dp[i] = (dp[i-1].add(dp[i-2])).remainder(new BigInteger(1234567+"")) ;
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(10));

    }
}