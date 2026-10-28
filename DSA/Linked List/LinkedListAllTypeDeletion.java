class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
class LinkedListAllTypeDeletion{
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

    void print(Node head){
        Node temp=head;
        while(temp !=null){
            System.out.print(temp.val+"--->"+" ");
            temp=temp.next;
        }
    }

    private static Node removeHead(Node head){
        if(head==null){
            return head;
        }
        head=head.next;
        return head;
    }

    private static Node removeTail(Node head){
        //case:1 if head is null or linked list has only one node
        if(head==null || head.next==null){
            return null;
        }
        //case:2 if linked list has more than one node
        Node t=head;
        while(t.next.next !=null){
            t=t.next;
        }
        t.next=null;
        return head;
    }

    private static Node removeKthElemNode(Node head,int k){
        //cases:1 if head is null or k is less than or equal to 0
        if(head==null || k<=0){
            return head;
        }
        //case:2 if head is the kth element node to be removed
        if(k==1){
            head=head.next;
            return head;
        }
        //case:3 if kth element node is present in the linked list
        int count=0;
        Node temp=head;
        Node prev=null;
        while(temp !=null){
            count++;
            if(count==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    private static Node removeElement(Node head,int element){
        //case:1 if head is null
        if(head==null){
            return head;
        }
        //case:2 if head is the element to be removed
        if(head.val==element){
            head=head.next;
            return head;
        }
        //case:3 if element is present in the linked list
        Node temp=head;
        Node prev=null;
        while(temp !=null){
            if(temp.val==element){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }


    public static void main(String ar[]){
        int[] arr={10,40,80,67,90,45,34,25,13,68,35,31};
        LinkedListAllTypeDeletion l=new LinkedListAllTypeDeletion();
        Node head=l.arrToList(arr);
        l.print(head);
        System.out.println();
        head=removeHead(head);
        l.print(head);
        System.out.println();
        head=removeTail(head);
        l.print(head);
        System.out.println();
        head=removeKthElemNode(head,5);
        l.print(head);
        System.out.println();
        head=removeElement(head,68);
        l.print(head);
    }
}