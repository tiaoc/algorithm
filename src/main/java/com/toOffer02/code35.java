package com.toOffer02;

import java.util.HashMap;

public class code35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap <Node, Node> used = new HashMap<>();
        return dfs(head,used);
    }
    private Node dfs(Node head,HashMap<Node,Node> used){
        if(head==null) return null;
        if(used.containsKey(head)) {
            return used.get(head);
        }
        else {
            Node node = new Node(head.val);
            used.put(head, node);//put要在遍历之前，如果是之后，那么每次判断都不包含key了
            node.next = dfs(head.next, used);
            node.random = dfs(head.random, used);
            return node;
        }
    }
}
