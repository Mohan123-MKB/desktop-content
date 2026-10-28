import java.util.*;
class MinStack{
    Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack(){
        st=new Stack<>();
        minst=new Stack<>();
    }
    //push
    public void push(int x){
        st.push(x);
        if(minst.isEmpty() || x<=minst.peek()){
            minst.push(x);
        }
    }
    //pop
    public void pop(){
        if(!st.isEmpty()){
            if(st.peek().equals(minst.peek())){
                minst.pop();
            }
            st.pop();
        }
    }
    public int top(){
        if(!st.isEmpty()){
            return st.peek();
        }
        return -1;
    }
    public int getMin(){
        if(!minst.isEmpty()){
            return minst.peek();
        }
        return -1;
    }
}
public class MinStackTest{
    public static void main(String ar[]){
        MinStack ms=new MinStack();
        ms.push(10);
        ms.push(20);
        ms.push(30);
        ms.push(40);
        ms.push(50);
        ms.pop();
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());

    }

}
