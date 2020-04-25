import java.io.*;
import java.util.*;

public class Main
{
    public static int subsetSum(int[] arr,int n, int w, int[][] dp)
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=w;j++)
            {
                if(i==0)
                 dp[i][j]=0;
                
                if(j==0)
                 dp[i][j]=1;
                 
            }
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=w;j++)
            {
                if(arr[i-1]<=j)
                 dp[i][j]=dp[i-1][j-arr[i-1]] + dp[i-1][j];
                 
                else 
                 dp[i][j]=dp[i-1][j];
                 
            }
        }
        return dp[n][w];
    }
	public static void main(String[] args) 
	{
	   Scanner sc = new Scanner(System.in);
	   int n=sc.nextInt();
	   int[] arr = new int[n];
	   for(int i=0; i<n; i++)
	   {
	       arr[i]=sc.nextInt();
	   }
	   int w=sc.nextInt();
	   
	   int[][] dp = new int[n+1][w+1];
	   System.out.println(subsetSum(arr,n,w,dp));
	}
}

