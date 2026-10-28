import java.util.*;

class MyQueue{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    public void enqueue(int x){
        s1.push(x);
    }
    public int dequeue(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1:s2.pop();
    }
}

class MyCircularQueue{
    int[] data;
    int front,rear,size,capacity;

    public MyCircularQueue(int k){
        data=new int[k];
        capacity=k;
        front=0;
        rear=-1;
        size=0;
    }
    public boolean enqueue(int value){
        if(isFull())
        return false;
        rear=(rear +1) % capacity;
        data[rear]=value;
        size++;
        return true;
    }
    public boolean dequeue(){
        if(isEmpty())
        return false;
        front=(front+1) % capacity;
        size--;
        return true;
    }
    public int Front(){
        return isEmpty() ? -1: data[front];
    }
    public int Rear(){
        return isEmpty() ? -1: data[rear];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==capacity;
    }
}
public class QueueQn {
    //generate binary numbers 1 to n
    public static void genBinNumbs(int n){
        Queue<String> q=new LinkedList<>();
        q.add("1");
        for(int i=1;i<=n;i++){
            String front=q.remove();
            System.out.print(front+" ");
            q.add(front + "0");
            q.add(front + "1");
        }
    }

    //reverse stack
     public static void reverseStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) temp.push(stack.pop());
        System.out.println("Reversed Stack: " + temp);
    }

    //reverse queue
    public static void printReverse(Queue<Integer> qi) {
        Stack<Integer> s = new Stack<>();
        for (int item : qi) s.push(item);
        while (!s.isEmpty()) System.out.print(s.pop() + " ");
    }

    //check palindrome queue
      public static boolean isPalindrome(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        for (int val : q) s.push(val);

        for (int val : q) {
            if (val != s.pop()) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        MyQueue mq=new MyQueue();
        mq.enqueue(10);
         mq.enqueue(30);
          mq.enqueue(60);
           mq.enqueue(70);
            mq.enqueue(90);
            System.out.println(mq.dequeue());
            System.out.println(mq.dequeue());

        MyCircularQueue q = new MyCircularQueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.isFull()); // true
        q.dequeue();
        System.out.println(q.Front()); 
        System.out.println(q.Rear());

        genBinNumbs(5); 
        System.out.println();

        Stack<Integer> stack = new Stack<>();
        stack.push(1); stack.push(2); stack.push(3);
        reverseStack(stack);

        Queue<Integer> qi = new LinkedList<>();
        qi.add(1); qi.add(2); qi.add(3); qi.add(4);
        printReverse(qi); 
        System.out.println();

        Queue<Integer> qe = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));
        System.out.println("Is palindrome? " + isPalindrome(qe));
    }
    
}
