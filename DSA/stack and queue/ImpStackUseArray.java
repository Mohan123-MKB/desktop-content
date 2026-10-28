import java.util.*;
public class ImpStackUseArray {
    int[] arr;
    int top;
    int capacity;
    public ImpStackUseArray(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        top=-1;
    }

    //push element to stack
    public void push(int x){
        if(isFull()){
            return;
        }
        arr[++top]=x;
    } 

    //pop element from stack
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        return arr[top--];
    }

    //peek element from stack
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[top];
    }

    //check if stack is empty
    public boolean isEmpty(){
        return top==-1;
    }

   //check if stack is full
   public boolean isFull(){
    return top==capacity-1; //(n=5 means top=4 and capacity=5-1)
   }

   //print stack
   public void print(){
    if(isEmpty()){
        return;   
    }
    for(int i=0;i<=top;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
   }

   public static void main(String[] args) {
    ImpStackUseArray st=new ImpStackUseArray(5);
    st.push(10);
    st.push(20);
    st.push(30);
    st.print();
    System.out.println(st.peek());
    System.out.println(st.pop());
    st.print();
   }
}
