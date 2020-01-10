package AmazonOA2;

import java.util.HashMap;
import java.util.Map;

public class L38DeepCopy {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val,Object o, Object o1) {
            this.val = val;
            this.next = null;
            this.random = null;
        }


    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null)return head;
            Node curr = head;
            Map<Node, Node> map= new HashMap<>();
            while(curr!=null){
                map.put(curr,new Node(curr.val,null, null));
                curr = curr.next;
            }
            /////////注意深拷贝， 要单独赋值，故currencies。next  curr.random 用第二个while来赋值
            //https://www.youtube.com/watch?v=oXABtaRa37U
            curr = head;
            while(curr!=null){
                map.get(curr).next = map.get(curr.next);
                map.get(curr).random = map.get(curr.random);
                curr = curr.next;
            }
            return map.get(head);
        }
    }
}}
