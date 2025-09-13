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
    private ListNode findNth(ListNode head,int k ){
        int cnt=1;
        ListNode temp=head;
        while(temp.next!=null){
            if(cnt==k)return temp;
            cnt++;
            temp=temp.next;
        }
        return temp;

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)return head;
        int len=1;
        ListNode tail=head;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0){
            return head;
        
        }
        
        k=k%len;
        tail.next=head;
        ListNode newLast=findNth(head,len-k);
        head=newLast.next;
        newLast.next=null;
        return head;
    }
}