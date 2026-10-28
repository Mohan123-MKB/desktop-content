import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LoopDetection {
    public static boolean hasLoop(Node head){
        Node slow=head,fast=head;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            return true;
        }
        return false;
    }
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        Node head=null,temp=null,loop=null;
        System.out.println("Enter the number of elements:");
        int n=sc.nextInt();
        System.out.println("Enter the position to create loop: ");
        int pos=sc.nextInt();
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            Node node=new Node(data);
            if(head==null)
            {
                head=node;
                temp=node;
            }
            else{
                temp.next=node;
                temp=temp.next;
            }
            if(i==pos){
                loop=node;
            }
        }
        if(pos !=-1 && loop !=null){
            temp.next=loop;
        }
        if(hasLoop(head)){
            System.out.println("Loop detected");
        }
        else{
            System.out.println("Loop Not detected");
        }
    } 
}
