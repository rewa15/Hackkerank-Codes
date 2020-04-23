import java.io.*;
import java.util.*;

public class Main
{
    public static boolean subsetSum(int[] arr, int n, int w, boolean[][] dp)
    {
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=w; j++)
            {
                if(i==0)
                 dp[i][j]=false;
                
                if(j==0)
                 dp[i][j]=true;
            }
        }
        
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=w; j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1] || dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
    }
    public static boolean equalSum(int[] arr,int n)
    {
        int sum=0;
        for(int i=0; i<n; i++)
        {
            sum+=arr[i];
        }
        
        if(sum%2!=0)
         return false;
        
        int w=sum/2;
        else
        {
            boolean[][] dp = new boolean[n+1][w+1]
            return subsetSum(arr,n,w);
        }
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

	   System.out.println(equalSum(arr,n));
	}
}

