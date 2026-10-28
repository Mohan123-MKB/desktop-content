import java.util.*;
public class MaxSlideWindow {
   public static int[] maxWindow(int[] arr,int n,int k){
    if(arr==null || arr.length==0 || k<=0 || k>arr.length){
        return new int[0];
    }
    int[] result=new int[n-k+1];
    for(int i=0;i<=n-k;i++){
        int max=Integer.MIN_VALUE;
        for(int j=i;j<i+k;j++){
            max=Math.max(max,arr[j]);
        }
        result[i]=max;
    }
    return result;
}
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int slide=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] res=maxWindow(arr,n,slide);
        System.out.println(Arrays.toString(res));

    }
}
