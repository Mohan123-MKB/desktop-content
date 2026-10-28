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
}
public class ArrayToLinkedList {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90,100};
        FormLinkedList li=new FormLinkedList();
        Node head=li.arrToList(arr);
         li.traverse(head);
        System.out.println("LinkedList Formed");      
    }  
}
