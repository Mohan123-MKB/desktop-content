import java.util.*;
public class ImpQueueUseStack {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    //Enqueue operation(push)
    public void enqueue(int x){
        s1.push(x);
    }

    //Dequeue operation(pop)
    public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        if(s2.isEmpty()){
            //move all elements from s1 to s2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    //front of queue
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    //check if the queue is empty
    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
    public static void main(String[] args) {
        ImpQueueUseStack q=new ImpQueueUseStack();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());

    }
    
}
