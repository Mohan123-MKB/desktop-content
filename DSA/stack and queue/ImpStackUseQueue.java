import java.util.*;
public class ImpStackUseQueue{
    Queue<Integer> q=new LinkedList<>();
    public void push(int x){
        q.add(x);
        //rotate queue to put the new element in front
        int size=q.size();
        for(int i=0;i<size-1;i++){
            q.add(q.remove());
        }
    }
    //remove element on top of stack
    public int pop(){
        if(q.isEmpty()){
            return -1;
        }
        return q.remove();
    }
    //get top element
    public int top(){
        if(q.isEmpty()){
            return -1;
        }
        return q.peek();
    }
    //return true if stack is empty
    public boolean empty(){
        return q.isEmpty();
    }
    public static void main(String[] args) {
        ImpStackUseQueue st=new ImpStackUseQueue();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.empty());
    }

}