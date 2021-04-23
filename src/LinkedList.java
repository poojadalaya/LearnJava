import java.util.*;
import java.io.*;

public class LinkedList {

    /* A LL is a linear data structure, in which the elements are not stored at contiguous memory locations.
        Advantages over arrays
           1) Dynamic size
           2) Ease of insertion/deletion
        Disadvantages:
            1) Random access cannot be done - we have to traverse
            2) Memory is assigned for head node
    * */
    static ListNode head;
    public static void main(String args[]) {

        addNode(25);
        addNode(10);
        printNodes();
        ListNode deletedNode = deleteNthNode(2);
        System.out.println("Deleted Node:"+deletedNode.val);

    }

    public static ListNode deleteNthNode(int n) {
        int cnt = 0;
        ListNode p = head;
        while(p!=null) {
            cnt++;
            if(cnt == n) break;
            p = p.next;
        }
        return p;
    }

    public static void addNode(int val) { //Add at the end
        //Maintaining a head node

        if(head==null) {
            head = new ListNode(val); //Why to waste the head node with a dummy value - so use the first value
        } else {
            ListNode x = head;
            while(x.next!=null) {
                x = x.next; //Essentially get the last node element
            }

            ListNode newNode = new ListNode(val);
            x.next = newNode;
            newNode.next = null;
        }
    }

    public static void printNodes() {
        ListNode x = head;
        while(x!=null) {
            System.out.println(x.val);
            x = x.next;
        }
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
