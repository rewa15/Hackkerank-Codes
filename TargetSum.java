import java.io.*;
import java.util.*;

public class Main
{
    public static int subsetSum(int[] arr,int n,int w,int[][] dp) // return count of subset sum
    {
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<w+1; j++)
            {
                if(i==0)
                 dp[i][j]=0;
                 
                if(j==0)
                 dp[i][j]=1;
            }
        }
        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<w+1; j++)
            {
                if(arr[i-1] <=j)
                 dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                 
                else
                 dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][w];
    }
    public static int findSum(int[] arr,int n,int diff)
    {
        int sum=0;
        for(int i=0; i<n; i++)
         sum+=arr[i];
         
         int w=(int)((diff+sum)/2);
         int[][] dp=new int[n+1][w+1];
         return subsetSum(arr,n,w,dp);
        
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
	   int diff=1;
	   System.out.println(findSum(arr,n,diff));
	}

}


