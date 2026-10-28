import java.util.*;
public class Arrayp {
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int[] grade_arr=new int[20];
        int count=0;
        while(count<grade_arr.length){
            int in=sc.nextInt();
            grade_arr[count]=in;
            if(in==-1){
                break;
            }
            count++;
        }
        if(count==0){
            System.out.println("No grade");
        }
        double ansr=calAvg(grade_arr,count);
        System.out.println(ansr);
    }
    static double calAvg(int[] grade_arr,int count){
        int tot=0;
        for(int n:grade_arr){
            tot +=n;
        }
        double ans=tot/count;
        return ans;
    }
    
}
