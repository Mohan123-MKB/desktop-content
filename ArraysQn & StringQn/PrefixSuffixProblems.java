import java.util.*;
public class PrefixSuffixProblems {
    //1. subarraysum
    public static int subarraysum(int[] arr,int l, int r){
        //precompute prefix sum -> prefix[r]-prefix[l-1];
        int n=arr.length;
        int[] prefix=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        return prefix[r]-(l>0 ? prefix[l-1]:0);
    }

    //2. Maximum prefix sum
    public static int maxPrefixSum(int[] arr){
        //keep running prefix sum and track the maximum
        int prefix=0,maxSum=Integer.MIN_VALUE;
        for(int x:arr){
            prefix += x;
            maxSum=Math.max(maxSum,prefix);
        }
        return maxSum;
    }

    //3. Trapping rainwater
    public static int trappingRainWater(int[] arr){
        int n=arr.length;
        int[] prefixMax=new int[n];
        int[] suffixMax=new int[n];
        //Build prefix max
        prefixMax[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixMax[i]=Math.max(prefixMax[i-1],arr[i]);
        }
        //Build suffix max
        suffixMax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i]=Math.max(suffixMax[i+1],arr[i]);
        }
        //compute water
        int water=0;
        for(int i=0;i<n;i++){
            water += Math.min(prefixMax[i],suffixMax[i])-arr[i];
        }
        return water;
    }


    public static void main(String[] args) {
        int[] arr={7,2,4,6,4};
        int l=1;
        int r=3;
        System.out.println(subarraysum(arr,l,r));
        System.out.println(maxPrefixSum(arr));
        System.out.println(trappingRainWater(arr));
    }
}
