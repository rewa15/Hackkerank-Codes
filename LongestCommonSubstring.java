import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {

    public static int lcsCount(String s1,String s2,int n,int m,int[][] dp)
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                 dp[i][j]=0;
            }
        }
        
        int res=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                  dp[i][j] = 1 + dp[i-1][j-1];
                  res = Math.max(res,dp[i][j]);
                }
                  
                else
                  dp[i][j] = 0;
            }
        }
        return res;
    }
    
	public static void main (String[] args)
	 {
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    while(t-- > 0)
	    {
	        int n = scan.nextInt();
	        int m = scan.nextInt();
	        String str1 = scan.next();
	        String str2 = scan.next();
	        int[][] dp = new int[n+1][m+1];
	        int ans = lcsCount(str1,str2,n,m,dp);
	        System.out.println(ans);
	    }
	 }
}
