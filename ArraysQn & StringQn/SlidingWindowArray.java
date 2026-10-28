import java.util.*;

//first window -> slide window -> add new and remove old ->do action based on problem -> return answer
public class SlidingWindowArray{
    //1. Maximum sum subarray of size k
    public static int maxSumSubarray(int[] arr,int k){
        int n=arr.length;
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int maxSum=sum;
        //slide window
        for(int i=k;i<n;i++){
            sum +=arr[i]-arr[i-k]; //add right element and remove left element
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }

    //2. Minimum sum subarray of size k
     public static int minSumSubarray(int[] arr,int k){
        int n=arr.length;
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int minSum=sum;
        //slide window
        for(int i=k;i<n;i++){
            sum +=arr[i]-arr[i-k];
            minSum=Math.min(minSum,sum);
        }
        return minSum;
     }

    //3. Maximum product subarray of size k
    public static int maxProductSubarray(int[] arr,int k){
        int n=arr.length;
        int prod=1;
        //first window
        for(int i=0;i<k;i++){
            prod *=arr[i];
        }
        int maxProd=prod;
        //slide window
        for(int i=k;i<n;i++){
            prod = (prod /arr[i-k]) * arr[i];//remove first element in old window and add new element
            maxProd=Math.max(maxProd,prod);
        }
        return maxProd;
    }

    //4. Minimum product subarray of size k
    public static int minProductSubarray(int[] arr,int k){
        int n=arr.length;
        int prod=1;
        //first window
        for(int i=0;i<k;i++){
            prod *=arr[i];
        }
        int minProd=prod;
        //slide window
        for(int i=k;i<n;i++){
            prod = (prod /arr[i-k]) * arr[i];//remove first element in old window and add new element
            minProd=Math.min(minProd,prod);
        }
        return minProd;
    }

    //5. subarray of size k with maximum even sum
    public static int maxEvenSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int maxEvenSum=(sum % 2==0) ? sum:Integer.MIN_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2==0){
                maxEvenSum=Math.max(maxEvenSum,sum);
            }
        }
        return maxEvenSum;
    }

    //6. subarray of size k with maximum odd sum
    public static int maxOddSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int maxOddSum=(sum % 2 !=0) ? sum:Integer.MIN_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2 !=0){
                maxOddSum=Math.max(maxOddSum,sum);
            }
        }
        return maxOddSum;
    }

    //7. subarray of size k with minEvenSumSubarray
    public static int minEvenSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int minEvenSum=(sum % 2 ==0) ? sum:Integer.MAX_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2 ==0){
                minEvenSum=Math.min(minEvenSum,sum);
            }
        }
        return minEvenSum;
    }

    //8. subarray of size k with  minOddSumsubarray
    public static int minOddSumSubarray(int[] arr,int k){
        int sum=0;
        //first window
        for(int i=0;i<k;i++){
            sum +=arr[i];
        }
        int minOddSum=(sum % 2 !=0) ? sum:Integer.MAX_VALUE;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] -arr[i-k];
            if(sum % 2 !=0){
                minOddSum=Math.min(minOddSum,sum);
            }
        }
        return minOddSum;
    }

    //9. Average of subarrays of size k
    public static double[] avgs(int arr[],int k){
        double[] res=new double[arr.length];
        int sum=0; //initialize sum
        //first window
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        res[0]=(double)sum/k;
        //slide window
        for(int i=k;i<arr.length;i++){
            sum+=arr[i]-arr[i-k]; //remove left and add right
            res[i-k+1]=(double)sum/k; //update ans at each step
        }
        return res;
    }

    //10.first negative number in every window(brute force)
    public static List<Integer> fNI(int arr[],int k){
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<=arr.length-k){
            int fNeg=0;
            for(int j=i;k<i+k;j++){
                if(arr[j]<0){
                    fNeg=arr[j];
                    break;
                }
            }
            res.add(fNeg);
        }
        return res;
    } 
    //deque(optimal) to maintain decresing order
    public static List<Integer> fNeg(int[] arr,int k){ //time compl is O(n) each element is processed once
        ArrayList<Integer> res=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                dq.add(i); //store index of negative numbers in current window
            }
            if(i>=k-1){ //window is ready
                while(!dq.isEmpty() && dq.peek()<=i-k){
                    dq.poll(); //remove out-of window[when the window slides,if the front index is out of range]
                }
                res.add(dq.isEmpty() ?0:arr[dq.peek()]); //add first neg or 0
            }
        }

        return res;
    }
   //          why deque works?
    // Front of deque=first neg in cur window / always holds the minimum for the current window
    // Back of deque=future negatives
    // Remove expired indices when they slide out of the window
    // Add new negatives when they enter the window
    // so that we never rescan the whole window-just peek at the front of the deque

    //11.Minimum in every window(brutte force)
    public static List<Integer> minInWindow(int[] arr,int k){
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<=arr.length-k;i++){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<i+k;j++){
                min=Math.min(min,arr[j]);
            }
            res.add(min);
        }
        return res;
    }
    //Deque (optimal minInWindow)
    List<Integer> minInWindowDeque(int[] arr,int k){
        ArrayList<Integer> res=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            //Remove indices out of window
            while(!dq.isEmpty() && dq.peek()<=i-k){
                    dq.poll(); //remove out-of window[when the window slides,if the front index is out of range]
            }
            //Maintain increasing order
            while(!dq.isEmpty() && arr[dq.peekLast()] > arr[i]){
                    dq.pollLast();
            }
            dq.add(i);
            //First element in deque is min
            if(i>=k-1){
                res.add(arr[dq.peek()]);
            }
        }
        return res;
    }
    //12.Maximum in every window(brutte force)
    public static List<Integer> manInWindow(int[] arr,int k){
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<=arr.length-k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max=Math.max(max,arr[j]);
            }
            res.add(max);
        }
        return res;
    }
    //Maximum in every window(deque is used in min,max problems || and no need to rescan each window || so just book keeping O(n))
    //Deque (optimal maxInWindow)
    List<Integer> maxInWindowDeque(int[] arr,int k){
        ArrayList<Integer> res=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            //Remove indices out of window
            while(!dq.isEmpty() && dq.peek()<=i-k){
                    dq.poll(); //remove out-of window[when the window slides,if the front index is out of range]
            }
            //Maintain decreasing order
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                    dq.pollLast();
            }
            dq.add(i);
            //First element in deque is max
            if(i>=k-1){
                res.add(arr[dq.peek()]);
            }
        }
        return res;
    }

    public static void main(String ar[]){
        int[] arr={2,4,7,6,8};
        int k=2;
        System.out.println(minOddSumSubarray(arr,k));
        System.out.println(minSumSubarray(arr,k));

    }

}