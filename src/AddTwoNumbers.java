import java.io.*;
import java.lang.*;
import java.util.*;
public class AddTwoNumbers {

    public static void main(String args[]) {

        //Add two numbers where both are in String format
        System.out.println("415. Add Strings:::: Testing \"123\" & \"11\"");
        String sum = addStrings("123", "11");
        System.out.println(sum);
        sum = add("999", "8998");
        System.out.println("Sum simple method:"+sum);
        System.out.println("-----------------------");

        //Add two numbers where one is in array form and the other is an int
        System.out.println("989. Add to Array-Form of Integer:::: Testing array [2,0,0,0] & int 399");
        int input[] = new int[]{2,0,0,0};
        System.out.println(addToArrayForm(input, 399));
        System.out.println("-----------------------");

        //Add two numbers where both are in LL form
        ListNode num1dig1 = new ListNode(2);
        ListNode num1dig2 = new ListNode(3);
        ListNode num1dig3 = new ListNode(4);
        num1dig1.next = num1dig2;
        num1dig2.next = num1dig3;
        num1dig3.next = null; //So num1 = 432 2->3->4

        ListNode num2dig1 = new ListNode(5);
        ListNode num2dig2 = new ListNode(5);
        num2dig1.next = num2dig2;
        num2dig2.next = null; // num2 = 55 5->5 sum = 487 7->8->4

        ListNode sumUsingLinkedLists = findSumUsingLinkedLists(num1dig1, num2dig1);
        System.out.println("Leetcode problem 2: Add Two Numbers");
        while(sumUsingLinkedLists!=null) {
            System.out.print(" "+sumUsingLinkedLists.val);
            sumUsingLinkedLists = sumUsingLinkedLists.next;
        }
        System.out.println("\n-----------------------");

    }

    public static ListNode findSumUsingLinkedLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode sum = null;
        ListNode head = null;
        int carry = 0;
        while(p1!=null || p2!=null) {
            int val = carry;
            if(p1!=null) {
                val += p1.val;
                p1 = p1.next;
            }
            if(p2!=null) {
                val += p2.val;
                p2 = p2.next;
            }
            if(head==null) {
                head = new ListNode(val%10);
                head.next = null;
                sum = head;
            } else {
                ListNode temp = new ListNode(val%10);
                sum.next = temp;
                temp.next = null;
                sum = temp;
            }
            carry = val/10;
        }
        if(carry>0) {
            ListNode temp = new ListNode(carry);
            sum.next = temp;
        }
        return head;
    }

    public static String addStrings(String num1, String num2) {
        int p1 = num1.length() -1;
        int p2 = num2.length() -1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1>=0 || p2>=0) {
            int dig1 = p1>=0 ? num1.charAt(p1) - '0' : 0;
            int dig2 = p2>=0 ? num2.charAt(p2) - '0' : 0;
            int val = (dig1 + dig2 + carry)%10;
            carry = (dig1 + dig2 + carry)/10;
            sb.append(val);
            p1--;
            p2--;
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static String add(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        return String.valueOf(n1+n2);
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {

        int p1 = num.length -1;
        int x = k;
        int carry = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(p1>=0 || x>0) {
            int dig = p1>=0 ? num[p1] : 0;
            int val = (dig + x%10 + carry)%10;
            list.add(val);
            carry = (dig + x%10 + carry)/10;
            x = x/10;
            p1--;
        }
        if(carry>0) {
            list.add(carry);
        }
        Collections.reverse(list);
        return list;
    }
}