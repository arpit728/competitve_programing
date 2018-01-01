package misc;

import java.util.ArrayList;

/**
 * Created by hardCode on 4/12/2017.
 */
public class LinkedList {


    Node head;

    class Node{
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    void insertAtBeg(int data){
        if (head==null){
            head=new Node(data);
            return;
        }
        Node tempNode=new Node(data);
        tempNode.next=head;
        head=tempNode;
    }

    ArrayList<Integer>traverse(){
        ArrayList<Integer>list=new ArrayList<>();
        Node temp=head;

        while (temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        return list;
    }
    int length(){
        Node temp=head;
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    LinkedList sum(LinkedList list1,LinkedList list2){
        int l1=list1.length();
        int l2=list2.length();
        LinkedList newList=new LinkedList();
        int diff=Math.abs(l1-l2);

        if (l1==l2){
            int carry=listSum(newList,list1.head,list2.head);
            if (carry>0)
                newList.insertAtBeg(carry);
            return newList;
        }
        Node tempStart;
        if (l1>l2){
            tempStart=move(list1,diff);
            int carry=listSum(newList,tempStart,list2.head);
            carry=sumWithCarry(newList,list1.head,tempStart,carry);
            if (carry>0)
                newList.insertAtBeg(carry);
        }
        else
        {
            tempStart=move(list2,diff);
            int carry=listSum(newList,list1.head,tempStart);
            carry=sumWithCarry(newList,list2.head,tempStart,carry);
            if (carry>0)
                newList.insertAtBeg(carry);
        }

        return newList;
    }

    private int sumWithCarry(LinkedList newList, Node head, Node tempStart, int carry) {

        if (head.next==tempStart){
            int sum=carry+head.data;
            newList.insertAtBeg(sum%10);
            return sum/10;
        }

        int tempCarry=sumWithCarry(newList,head.next,tempStart,carry);
        int sum=tempCarry+head.data;
        newList.insertAtBeg(sum%10);
        return sum/10;
    }

    private Node move(LinkedList list1, int diff) {
        Node temp=list1.head;
        for (int i = 0; i < diff; i++) {
            temp=temp.next;
        }

        return temp;
    }

    private int listSum(LinkedList newList,Node head1, Node head2) {
        if (head1.next==null && head2.next==null){
            int sum=head1.data+head2.data;
            newList.insertAtBeg(sum % 10);
            return sum/10;
        }
        int carry=listSum(newList,head1.next,head2.next);
        int sum=head1.data+head2.data+carry;
        newList.insertAtBeg(sum%10);
        return sum/10;
    }



    void reverseChunkWiseWithoutSpace(int chunkSize){

        this.head= reverseChunkWiseWithoutSpace(head, chunkSize);
    }

    private Node reverseChunkWiseWithoutSpace(Node head, int chunkSize) {

        Node curr=head;
        Node prev=null;
        Node temp;
        int count=0;
        while (curr!=null && count<chunkSize){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        if (curr!=null)
            head.next= reverseChunkWiseWithoutSpace(curr, chunkSize);

        return prev;
    }

    void reverseChunkWise(int chunkSize){

        int l=length();
        int n= (int) Math.ceil((double)l/chunkSize);

        Node tempStart = head,prevEnd=null,nextStart;

        for (int i = 0; i < n; i++) {
            nextStart= reverseChunk(prevEnd, tempStart, tempStart.next, chunkSize - 1);
            if (i==n-1)tempStart.next=null;
            prevEnd=tempStart;
            tempStart=nextStart;
        }
    }

    private Node reverseChunk(Node prevEnd, Node prev, Node curr, int chunkSize) {

        if (curr==null)return null;

        if (curr.next==null || chunkSize==1) {

            Node temp = curr.next;
            curr.next = prev;

            if (prevEnd != null) {
                prevEnd.next = curr;
            } else {
                this.head = curr;
                //System.out.println(head.data);
            }

            return temp;
        }
        Node temp= reverseChunk(prevEnd, curr, curr.next, chunkSize - 1);
        curr.next=prev;
        return temp;
    }
    private void reverse() {

        Node prev = null, curr = head, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head = prev;

    }

    private void recursiveReverse() {
        recursiveReverse(null,head);
    }

    private void recursiveReverse(Node prev, Node curr) {
        if (curr == null) {
            head = prev;
            return;
        }

        recursiveReverse(curr, curr.next);
        curr.next = prev;
    }
    public static void main(String[] args) {

        LinkedList list=new LinkedList();
       /* LinkedList list1=new LinkedList();
        LinkedList list2=new LinkedList();

        list2.insertAtBeg(3);
        list2.insertAtBeg(6);
        list2.insertAtBeg(5);

        list1.insertAtBeg(2);
        list1.insertAtBeg(4);
        list1.insertAtBeg(8);*/

        list.insertAtBeg(9);
        list.insertAtBeg(8);
        list.insertAtBeg(7);
        list.insertAtBeg(6);
        list.insertAtBeg(5);
        list.insertAtBeg(4);
        list.insertAtBeg(3);
        list.insertAtBeg(2);
        list.insertAtBeg(1);

        System.out.println(list.traverse());

        list.recursiveReverse();
        System.out.println(list.traverse());

        list.reverseChunkWise(3);
        System.out.println(list.traverse());
        list.reverseChunkWiseWithoutSpace(3);
        System.out.println(list.traverse());
        list.reverse();
        System.out.println(list.traverse());



    }




}

