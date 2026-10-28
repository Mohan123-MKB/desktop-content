class Node {
    int data;
    Node next;
    Node back;

    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class DoublyLL {
    //arr to list
    private static Node arrToList(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    //print list
    private static void print(Node head) {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " --> ");
            t = t.next;
        }
        System.out.println("null");
    }
    //delete head node
    private static Node deleteHead(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node prev=head;
        head=head.next;
        head.back=null;
        prev.next=null;
        return head;
    }
    //delete tail node
    private static Node deleteTail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node temp=head;
        while(temp.next !=null){
            temp=temp.next;
        }
        Node tail=temp.back;
        tail.next=null;
        temp.next=null;
        return head;
    }
    //delete kth element node
    private static Node deleteKthElement(Node head,int k){
        if(head==null){
            return null;
        }
        int count=0;
        Node temp=head;
        while(temp !=null){
            count++;
            if(count==k){
                break;
            }
            temp=temp.next;
        }
        Node prev=temp.back;
        Node front=temp.next;
        if(prev==null && front==null){
            return null;
        }
        else if(prev==null){
            return deleteHead(head);
        }
        else if(front==null){
            return deleteTail(head);
        }
        else{
            prev.next=front;
            front.back=prev;
            temp.next=null;
            temp.back=null;
            return head;
        }
    }
    //delete target node
  private static Node deleteTarget(Node head, Node target) {
    if (target == null) return head;

    Node prev = target.back;
    Node next = target.next;

    if (prev == null && next == null) {
        return null; // Only one node in the list
    } else if (prev == null) {
        return deleteHead(head); // Target is head
    } else if (next == null) {
        return deleteTail(head); // Target is tail
    } else {
        prev.next = next;
        next.back = prev;
        target.next = null;
        target.back = null;
        return head;
    }
}











    public static void main(String ar[]) {
        int[] arr = { 1, 3, 2, 54, 6, 9, 67, 2 };
        Node head = arrToList(arr);
        print(head);
        head=deleteHead(head);
        print(head);
        head=deleteTail(head);
         print(head);
         head=deleteKthElement(head,5);
         print(head);
         Node nodeToDelete = head;
    while (nodeToDelete != null && nodeToDelete.data != 9) {
        nodeToDelete = nodeToDelete.next;
    }
    head = deleteTarget(head, nodeToDelete);
    System.out.println("After deleting node with value 9:");
    print(head);
         
    }
}
