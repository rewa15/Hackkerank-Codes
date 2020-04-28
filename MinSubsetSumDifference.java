import java.io.*;
import java.util.*;

// This is a minimum difference subset problem.
// For maximum, simply take a null set, and on the other hand another array, we will get max difference
public class Main
{
    public static int minSum(int[] arr,int n,int w,boolean[][] dp)
    {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<w+1; j++)
            {
                if(i==0)
                 dp[i][j]=false;
                 
                if(j==0)
                 dp[i][j]=true;
            }
        }
        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<w+1; j++)
            {
                if(arr[i-1] <=j)
                 dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                 
                else
                 dp[i][j] = dp[i-1][j];
            }
        }
        
        int var=w/2;
        for(int j=0; j<=var; j++)
        {
            if(dp[n-1][j]==true)
                list.add(j);
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0; i<list.size();i++)
        {
            min=Math.min(min,w-2*list.get(i));
        }
        
        return min;
    }
    public static int subsetSum(int[] arr,int n)
    {
        int sum=0;
        for(int i=0; i<n; i++)
         sum+=arr[i];
         
         int w=sum;
         boolean[][] dp=new boolean[n+1][w+1];
         return minSum(arr,n,w,dp);
        
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
	   System.out.println(subsetSum(arr,n));
	}

}

