import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class EvenOdd{
    public static Node segEvenOdd(Node head){
        Node evenStart=null,evenEnd=null;
        Node oddStart=null,oddEnd=null;
        Node temp=head;
        while(temp !=null){
            if(temp.data % 2==0){
                if(evenStart==null){
                    evenStart=temp;
                    evenEnd=evenStart;
                }
                else{
                    evenEnd.next=temp;
                    evenEnd=evenEnd.next;
                }
            }
            else{
                if(oddStart==null){
                    oddStart=temp;
                    oddEnd=oddStart;
                }
                else{
                    oddEnd.next=temp;
                    oddEnd=oddEnd.next;
                }
            }
            temp=temp.next;
        }
        if(evenStart==null)
        return oddStart;
        if(oddStart==null)
        return evenStart;
        evenEnd.next=oddStart;
        oddEnd.next=null;
        return evenStart;
    }
    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        Node head=null,temp=null;
        System.out.println("Enter the number of elements:");
        int n=sc.nextInt();
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
        }
        System.out.println("Original List:");
        print(head);
        head=segEvenOdd(head);
        System.out.println("Segregated List:");
        print(head);

    }
}
