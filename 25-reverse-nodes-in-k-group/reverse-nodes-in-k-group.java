/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newhead;
    }

    ListNode getKthNode(ListNode head, int k){
        ListNode temp = head;   
        k -= 1;                 
        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode newHead = null;  

        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);  
            if (kthNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break; 
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);

            if (prev != null) {
                prev.next = kthNode;
            } else {
                newHead = kthNode; 
            }

            prev = temp; 
            temp = nextNode;
        }

        if (newHead != null) {
            return newHead;
        } else {
            return head;  
        }
    }
}
