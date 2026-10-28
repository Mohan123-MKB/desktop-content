import java.util.*;
public class StockSpan {
    public static int[] calSpan(int[] stockprices,int n){
        int[] span=new int[n];
        span[0]=1;
        for(int i=1;i<n;i++){
            span[i]=1;
            int j=i-1;
            while(j>=0 && stockprices[i]>=stockprices[j]){
                span[i]++;
                j--;
            }
        }
        return span;
    }
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] res=calSpan(arr,n);
        System.out.println(Arrays.toString(res));
    }   
}
