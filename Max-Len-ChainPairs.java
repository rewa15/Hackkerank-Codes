public class MaxLengthChainOfPairs
{
    public int maxChainLength(PairVal pair_arr[], int n)
    {
        int i, j, max = 0;
        int MaxChainLen[] = new int[n];
        for (i = 0; i < n; i++)
        {
            MaxChainLen[i] = 1;
        }
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < i; j++)
            {
                if (pair_arr[i].a > pair_arr[j].b && MaxChainLen[i] < MaxChainLen[j] + 1)
                    MaxChainLen[i] = MaxChainLen[j] + 1;
            }
        }
        for (i = 0; i < n; i++)
        {
            if (max < MaxChainLen[i])
                max = MaxChainLen[i];
        }
        return max;
    }
 
    public static void main(String... arg)
    {
        PairVal pair_arr[] = new PairVal[4];
        pair_arr[0] = new PairVal(5, 24);
        pair_arr[1] = new PairVal(15, 25);
        pair_arr[2] = new PairVal(27, 40);
        pair_arr[3] = new PairVal(50, 60);
        int n = 4;
        MaxLengthChainOfPairs maxLengthChainOfPairs = new MaxLengthChainOfPairs();
        System.out.println("the length of maximum size chain is " 
            + maxLengthChainOfPairs.maxChainLength(pair_arr, n));
    }
}
 
class PairVal
{
    int a;
    int b;
 
    PairVal(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}
