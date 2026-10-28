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
   void insert(int data){
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
   }

   void traverse(){
      Node temp=head;
      while(temp!=null){
         System.out.print(temp.data+" ");
         temp=temp.next;
      }
      System.out.println();
   }
}
public class CustomLinkedList{
   public static void main(String ar[]){
      int[] arr={10,20,30,40,50};
      FormLinkedList li=new FormLinkedList();
      for(int n:arr){
         li.insert(n);
      }
      System.out.println("LinkedList Formed");
      li.traverse();
   }
}