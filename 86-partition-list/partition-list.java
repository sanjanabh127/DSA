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
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy=new ListNode(0);
        ListNode bigDummy=new ListNode(0);
        ListNode small=smallDummy ;
        ListNode big =bigDummy;
        while(head!=null){
            if(head.val<x){
                small.next=head;
                small=small.next;
            }
            else{
                big.next=head;
                big=big.next;
            }
            head=head.next;
        }
        big.next=null;
        small.next=bigDummy.next;
        return smallDummy.next ;
        
    }
}