import java.util.*;
import java.io.*;

public class Main
{
    public static boolean canPartition(int[] arr)
    {
       // Firstly check for even/odd sum, odd sum cannot be partitioned
       
       int total=0;
       for(int i=0; i<arr.length; i++)
       {
           total+=arr[i];
       }
       
       if(total%2!=0)
        return false;
        
       return canPart(arr,0,0,total);
    }
    
    public static boolean canPart(int[] arr, int index, int sum, int total)
    {
        if(sum*2 ==total)
         return true;
        
        if(sum > total/2 || index > arr.length)
         return false;
         
        return canPart(arr, index+1, sum, total) || canPart(arr, index+1, sum+arr[index], total);
         
    }
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++)
		{
		    arr[i]=sc.nextInt();
		}
		System.out.print(canPartition(arr));
	}
}
