import java.util.*;
public class Maths {
    //sum
    static int sum(int n){
        int s=0;
        while(n>0){
            s+=n%10;// remainder we get or last digit get
            n/=10; //qutient we get or last digit remove
        }
        return s;
    }
    //reve a number
    static int rev(int n){
        int r=0;
        while(n>0){
            r=r*10+n%10;
            n/=10;
        }
        return r;
    }
    //palindrome 
    static boolean isPalin(int n){
        int temp=n;
        int r=0;
        while(temp>0){
            r=r*10+temp%10;
            temp/=10;
        }
        return n==r;
    }
    //armstrong num
    static boolean isArms(int n){
        int temp=n;
        int s=0;
        int len=String.valueOf(n).length();
        while(temp>0){
            int digit=temp%10;
            s+=(int)Math.pow(digit,len);
            temp/=10;
        }
        return n==s;
    }
    //count digits
    static int count(int n){
        int c=0;
        while(n>0){
            c++;
            n/=10;
        }
        return c;
    }
    //even or odd
    static String evenOrOdd(int n){
        if(n%2==0){
            return "even";
        }
        else{
            return "odd";
        }
    }
    //perfect number
    static boolean isPerfect(int n){
        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        return sum==n;
    }
    //fibonacci
    static int fibo(int n){
        if(n<=1){
            return 1;
        }
        int dp[]=new int[n+1]; //stores result of subproblems to avoid recomputation
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //fibnacci series
    static ArrayList<Integer> fiboSeries(int n){
        ArrayList<Integer> res=new ArrayList<>();
        if(n==0){
            res.add(0);
        }if(n==1){
            res.add(1);
        }
        int dp[]=new int[n+1]; //stores result of subproblems to avoid recomputation
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        for(int i:dp){
            res.add(i);
        }   
        return res;
    }
    //power of a number
    static int power(int a,int b){
        int res=1;
        for(int i=1;i<=b;i++){
            res*=a;
        }
        return res;
    }
    //Gcd
    static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    //lcm
    static int lcm(int a,int b){
         int gcd=gcd(a,b);
         return (a*b)/gcd;
    }
    //swap
    static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println((a+" "+b));
    }
    //sum on natural number
    static int sumNat(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    //leap year
    static boolean isLeap(int year){
        if((year %4==0 && year %100 !=0) ||year%400==0){
            return true;
        }
        return false;
    }
    //largest of 3 numbers
    static int largest(int a,int b,int c){
        int m=0;
        if(a>b && a>c){
            m=a;
        }else if(b>a && b>c){
            m=b;
        }
        else{
            m=c;
        }
        return m;
    }
    //smallest of 3 numbers
     static int smallest(int a,int b,int c){
        int m=a;
        if(b<m){
            m=b;
        }
        if(c<m){
            m=c;
        }       
        return m;
    }
    static boolean isHarshad(int n){
        int temp=n;
        int sum=0;
        while(temp>0){
            sum+=temp%10;
            temp/=10;
        }
        return n%sum==0;
    }
    static int countEven(int n){
        int c=0;
        while(n>0){
            int digits=n%10;
            if(digits%2==0){
                c++;
            }
            n/=10;
        }
        return c;
    }
    //sum of squares
    static int sumOfSquares(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i*i;
        }
        return sum;
    }
   

    public static void main(String[] ar){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(sum(n));
         System.out.println(rev(n));
          System.out.println(isPalin(n));
           System.out.println(isArms(n));
            System.out.println(count(n));
            System.out.println(evenOrOdd(n));
            System.out.println(isPerfect(n));
            System.out.println(fibo(n));
            System.out.println(fiboSeries(n));
            System.out.println(power(n,3));
            System.out.println(gcd(7,19));
            System.out.println(lcm(12,10));
            System.out.println(largest(5,19,27));
            System.err.println(smallest(1,0,9));
            System.out.println(isHarshad(n));
            System.out.println(sumOfSquares(n));
            System.out.println(countEven(1234));
            swap(5,7);

        sc.close();
    }
}
