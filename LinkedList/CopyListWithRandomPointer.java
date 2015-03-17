/*
 Copy List With Random Pointer
 
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 
 Return a deep copy of the list.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        //HashMap method: runtime:O(N) space:O(N)
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode temp = newHead;
        RandomListNode node = head.next;
        while (node != null){
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            temp.next = newNode;
            temp = temp.next;
            node = node.next;
        }
        node = head;
        RandomListNode copy = newHead;
        while (node != null){
            copy.random = map.get(node.random);
            copy = copy.next;
            node = node.next;
        }
        return newHead;
    }
}
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        //Pointer Method runtime:O(N) space:O(1)
        //copy each node and put them next to each node
        RandomListNode node = head;
        while (node != null){
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        //copy random pointer to the new node
        node = head;
        while (node != null){
            if (node.random != null)
                node.next.random = node.random.next;//not node.random, since it's link to the newNode
            node = node.next.next;
        }
        //devide the list into two list by link new node together
        RandomListNode newHead = head.next;
        node = head;
        while (node != null){
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            if (newNode.next != null)
                newNode.next = newNode.next.next;
            node = node.next;
        }
        return newHead;
    }
}