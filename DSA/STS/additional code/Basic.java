
import java.util.*;
public class Basic {
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int sum=0,avg=0,prod=1,smallest=0,largest=0;
        sum =a+b+c;
        avg=sum/3;
        prod =a*b*c;
         if(a<b && a<c){
            smallest=a;
         }
         else if(b<a && b<c){
            smallest=b;
         }
         else{
            smallest=c;
         }
         if(a>b && a>c){
            largest=a;
         }
         else if(b>a && b>c){
            largest=b;
         }
         else{
            largest=c;
         }
        System.out.println("sum :" +sum);
        System.out.println();
        System.out.println("avg :"+avg);
        System.out.println();
        System.out.println("prod :"+prod);
        System.out.println();
        System.out.println("small number :"+smallest);
        System.out.println();
        System.out.println("large number :"+largest);
        System.out.println();
   


    }
    
}
