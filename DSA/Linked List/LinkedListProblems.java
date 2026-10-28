import java.util.*;
class Node{
    int data;
    Node next;
    Node(int val){
        data=val;
        this.next=null;
    }
}
class FormLinkedList{
    Node head;
    Node arrToList(int[] arr){
        if(arr.length==0){
            return null;
        }
        head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            temp.next=new Node(arr[i]);
            temp=temp.next;
        }
        return head;
    }

   void traverse(Node head){
      Node temp=head;
      while(temp!=null){
         System.out.print(temp.data+" ");
         temp=temp.next;
      }
      System.out.println();
   }
////////////////////////////////////////////////////////////////////
    int lengthLL(Node head){
        int count=0;
        Node temp=head;
        while(temp !=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
///////////////////////////////////////////////////////////////
    Node findMiddle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
////////////////////////////////////////////////////////////////
    void reverse(Node head){
        Node prev=null;
        Node temp=head;
        Node next;
        while(temp !=null){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head=prev;
    }
////////////////////////////////////////////////////////////////
    boolean detectLoop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
////////////////////////////////////////////////////////////////
    Node mergeSortedLL(Node l1,Node l2){
        Node dummy=new Node(0);
        Node temp=dummy;
        while(l1 !=null && l2 !=null){
            if(l1.data<=l2.data){
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null){
            temp.next=l1;
        }
        if(l2!=null){
            temp.next=l2;
        }
        return dummy.next;
    }
////////////////////////////////////////////////////////////////
    Node duplicates(Node head){
        Node temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return head;
    }
////////////////////////////////////////////////////////////////
    

}
public class LinkedListProblems {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        FormLinkedList li=new FormLinkedList();
        Node head=li.arrToList(arr);
        System.out.println("LinkedList 1 Formed...");
        li.traverse(head);

        int[] arr2={10,40,30,60,50,70,23,55,90,130};
        FormLinkedList li2=new FormLinkedList();
        Node head2=li2.arrToList(arr2);
        System.out.println("LinkedList 2 Formed...");
        li2.traverse(head2);

        int[] arr3={1,1,2,3,4,5,5,6};
        FormLinkedList li3=new FormLinkedList();
        Node head3=li3.arrToList(arr3);
        System.out.println("LinkedList 3 Formed...");
        li3.traverse(head3);

        

        int res=li.lengthLL(head);
        System.out.println(res);

        Node mid=li.findMiddle(head);
        System.out.println(mid);

        li.reverse(head);
        li.traverse(head);

        if(li.detectLoop(head)){
            System.out.println("Loop detected....");
        }else{
            System.out.println("Loop Not detected...");
        }

        FormLinkedList merLL=new FormLinkedList();
        Node merged=merLL.mergeSortedLL(head,head2);
        merLL.traverse(merged);

        Node dupRem=li3.duplicates(head3);
        li.traverse(dupRem);
    } 
}
