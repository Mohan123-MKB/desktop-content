
import java.util.*;
public class StackPermutation {
    public static boolean stackPermutation(int[] arr,int[] tar){
        Stack<Integer> st=new Stack<>();
        int i=0;
        for(int n:arr){
            st.push(n);
            while(!st.isEmpty() && st.peek()==tar[i]){
                st.pop();
                i++;
            }
        }
        return st.isEmpty();
    }
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] tar=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println();
        for(int i=0;i<n;i++){
            tar[i]=sc.nextInt();
        }
        boolean res=stackPermutation(arr,tar);
        System.out.println(res);
    }
}
