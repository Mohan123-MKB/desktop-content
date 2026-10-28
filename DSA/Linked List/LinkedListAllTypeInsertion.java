class Node {
   int data;
   Node next;
   Node(int data){
      this.data=data;
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   Node insertAtBeginning(Node head, int data){
      Node newNode=new Node(data);
      if(head==null){
         head=newNode;
      }
      else{
         newNode.next=head;
         head=newNode;
      }
      return head;
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   Node insertAtEnd(Node head, int data){
      Node newNode=new Node(data);
      if(head==null){
         head=newNode;
      }
      else{
         Node temp=head;
         while(temp.next!=null){
            temp=temp.next;
         }
         temp.next=newNode;
      }
      return head;
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   Node insertAtPosition(Node head, int data, int position){
      //case:1 when linked list is empty
      if(head==null){
         if(position==1){
            return new Node(data);
         }   
         else{
            System.out.println("Position out of bounds");
            return head;
         }   
      }
      //case:2 when linked list is not empty
      Node n=new Node(data);
      if(position==1){
         n.next=head;
         head=n;
         return head;
      }
      //case:3 when position is greater than 1
      int count=0;
      Node temp=head;
      while(temp!=null){
         count++;
         if(count==position-1){
            n.next=temp.next;
            temp.next=n;
            break;
         }
         temp=temp.next;
      }  
      return head;
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   Node insertBeforeValueNode(Node head,int data,int value){
      Node n=new Node(data);
      //case:1 when linked list is empty
      if(head==null){
         return null;
      }
      //case:2 when head node is the value node
      if(head.data==value){
         n.next=head;
         head=n;
         return head;
      }
      //case:3 when value node is present in the linked list
      Node temp=head;
      while(temp.next!=null){
         if(temp.next.data==value){
            n.next=temp.next;
            temp.next=n;
            break;
         }
         temp=temp.next;
      }
      return head;
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   Node insertAfterValueNode(Node head,int data,int value){
      Node n=new Node(data);
      //case:1 when linked list is empty
      if(head==null){
         return null;
      }
      //case:2 when value node is present in the linked list
      Node temp=head;
      while(temp!=null){
         if(temp.data==value){
            n.next=temp.next;
            temp.next=n;
            break;
         }
         temp=temp.next;
      }
      return head;
   }
}
public class LinkedListAllTypeInsertion {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        FormLinkedList li=new FormLinkedList();
        Node head=li.arrToList(arr);
        head=li.insertAtBeginning(head, 5);
         li.traverse(head);
        head=li.insertAtEnd(head, 105);
         li.traverse(head);
        head=li.insertAtPosition(head, 25, 3);
         li.traverse(head);
        head=li.insertBeforeValueNode(head, 35, 40);
         li.traverse(head);
        head=li.insertAfterValueNode(head, 45, 40);
         li.traverse(head);
        System.out.println("LinkedList Formed");      
    }  
}

