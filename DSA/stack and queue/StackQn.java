import java.util.*;
class MinStack{
    Stack<Integer> st=new Stack<>();
    Stack<Integer> minSt=new Stack<>();
    public void push(int x){
        st.push(x);
        if(minSt.isEmpty() || x<=minSt.peek()){
            minSt.push(x);
        }
    }
    public void pop(){
        if(!st.isEmpty()){
           if(st.peek().equals(minSt.peek())){
              minSt.pop();
           }
           st.pop();
        }
    }
    public int top(){
        return st.peek();
    }
    public int getMin(){
        return minSt.peek();
    }
}

public class StackQn{
    
    //valid parentheses
    public static boolean isValid(String s){
        Stack<Character> ss=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(')
            ss.push(')');
            else if(ch=='{')
            ss.push('}');
            else if(ch=='[')
            ss.push(']');
            else if(ss.isEmpty() || ss.pop() !=ch)
            return false;
        }
        return ss.isEmpty();
    }

    //Remove all adjacent duplicates
    public static String removeDuplicates(String s1){
        Stack<Character> st=new Stack<>();
        for(char ch:s1.toCharArray()){
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder res=new StringBuilder();
        for(char ch:st){
            res.append(ch);
        }
        return res.toString();
    }

    //Min Stack

    //Next greater element
    public static void printNGE(int[] arr){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                int index=st.pop();
                System.out.println(arr[index]+"-->"+arr[i]);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            System.out.println(arr[st.pop()]+"-->-1");
        }
    }
    //evaluate reverse polish notation
    public static int evaRPN(String[] tokens){
        Stack<Integer> st=new Stack<>();
        for(String token:tokens){
            if("+-*/".contains(token)){
                int b=st.pop(),a=st.pop();
                switch(token){
                    case "+":st.push(a+b);
                    break;
                    case "-":st.push(a-b);
                    break;
                    case "*":st.push(a*b);
                    break;
                    case "/":st.push(a/b);
                    break;
                }
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
    

    public static void main(String ar[]){
        String s="{[()]}";
        System.out.println(isValid(s));
        System.out.println(removeDuplicates("abbaca"));
        MinStack ms=new MinStack();
        ms.push(7);
        ms.push(9);
        ms.push(1);
        ms.push(5);
        System.out.println("Min: "+ms.getMin());
        ms.pop();
        System.out.println("Top: "+ms.top());
        System.out.println("Min: "+ms.getMin());
        int[] arr={4,5,2,25};
        printNGE(arr);
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evaRPN(tokens));
    }
}