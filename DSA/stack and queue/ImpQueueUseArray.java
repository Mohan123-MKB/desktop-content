import java.util.*;
public class ImpQueueUseArray {
    int[] arr;
    int front,rear,size,capacity;

    public ImpQueueUseArray(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        front=0;
        rear=-1;
        size=0;
    }
    //Enqueue(add element to rear)
    public void enqueue(int item){
        if(isFull()){
            return;
        }
        rear++;
        arr[rear]=item;
        size++;
    }
    //Dequeue(remove element from front)
    public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        int item=arr[front];
        front++;
        size--;
        return item;
    }
    //peek(view front element)
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    //check if queue is empty
    public boolean isEmpty(){
        return size==0;
    }
    //check if queue is full
    public boolean isFull(){
        return size==capacity;
    }
    //print the queue
    public void printQueue(){
        if(!isEmpty()){
            return;
        }
        for(int i=front;i<=rear;i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ImpQueueUseArray q=new ImpQueueUseArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.enqueue(40);
        q.enqueue(50);
        q.printQueue();
    }
}
