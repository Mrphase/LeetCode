package AmazonOA2;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->
 */


public class L21ListNode {
    public void creatListNode(ListNode L, ArrayList<Integer> N){
        int i = 0;
        if(!N.isEmpty()){
            ListNode newNode = new ListNode(0);
            newNode.val = N.get(0);
            newNode.next = null;
            L.next =   newNode;
            N.remove(0);
            creatListNode(newNode,N);
        }

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> newList = new ArrayList<>();
        if(listNode != null){
            this.printListFromTailToHead(listNode.next);
            newList.add(listNode.val);
        }
        System.out.print(newList.toString()+" <- ");
        return newList;
    }


    public ListNode mergeTwoLists(ListNode L1, ListNode L2) {
        ListNode L3 = new ListNode(0);

        while(L1!=null || L2!=null){
            if(L1==null){L3.next = L2;}
            if(L2==null){L3.next = L1;}


            if(L1.val <=L2.val){L3.next = L1; L1 = L1.next;}
            else{L3.next = L2; L2 = L2.next;}

        }
        return L3;

    }

    public static void main(String[] args) {
        ListNode L2 = new ListNode(0);
        L21ListNode L21 = new L21ListNode();
        int[] a =  new int[]{1,2,3};
        ArrayList<Integer> B = new ArrayList<>();
        for(int i : a) B.add(i);

        System.out.println(B.toString());


        L21.creatListNode(L2,B);

        L21.printListFromTailToHead(L2.next);
    }

}
