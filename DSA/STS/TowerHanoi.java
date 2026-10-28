import java.util.*;
public class TowerHanoi {
    public static void tOfHanoi(int n,char fromrod,char helprod,char torod){
        if(n==1){
            System.out.println("Move disk from " + fromrod + "---->" + torod);
            return;
        }
        tOfHanoi(n-1,fromrod,torod,helprod);
        tOfHanoi(1,fromrod,helprod,torod);
        tOfHanoi(n-1,helprod,fromrod,torod);
    }
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enetr the number of risks:");
        int n=sc.nextInt();
        tOfHanoi(n,'A','B','C');
    } 
}
