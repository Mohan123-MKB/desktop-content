import java.util.*;
public class Celebrity {
    public static int findCelebrity(int m[][],int n){
        int cand=0;
        for(int i=1;i<n;i++){
            if(m[cand][i]==1){
                cand=i;
            }
        }
        for(int i=0;i<n;i++){
            if(i !=cand && (m[cand][i]==1 || m[i][cand]==0)){
                return -1;
            }
        }
        return cand;
    }
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] m=new int[n][n];
        System.out.println("Enter the matrix (0 or 1):");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;i++){
                m[i][j]=sc.nextInt();
            }
        }
        int res=findCelebrity(m,n);
        if(res !=-1)
        System.out.println(res);
        else
        System.out.println("No celebrity");
    }   
}
