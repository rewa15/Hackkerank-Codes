import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    // Code: Simple Recursion
    public static int knapsack(int[] value, int[] weight, int w, int n)
    {
        // Choose the minimum possible valid input
        // Base case
        
        if(n==0 || w==0)
         return 0;
         
        // Choice, diagram
        if(weight[n-1] <= w)
        {
            return Math.max(value[n-1]+knapsack(value,weight,w-weight[n-1],n-1), knapsack(value,weight,w,n-1));
        }
        
        else // when weight of n-1th item is greater than w, cannot include
        {
            return knapsack(value,weight,w,n-1);
        }
    }
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int i=0; i<t; i++)
	    {
	        int n = sc.nextInt();
	        int w = sc.nextInt();
	        int[] value = new int[n];
	        int[] weight = new int[n];
	        for(int j=0; j<n; j++)
	        {
	            value[j] = sc.nextInt();
	        }
	        
	        for(int k=0; k<n; k++)
	        {
	            weight[k] = sc.nextInt();
	        }
	        System.out.println(knapsack(value, weight, w, n));
	    }
	 }
}
