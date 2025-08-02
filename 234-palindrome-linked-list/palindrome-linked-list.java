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
    ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newhead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = reverseLL(slow.next);
        ListNode first = head;
        ListNode second = secondHead;
        boolean palindrome = true;

        while (second != null) {
            if (first.val != second.val) {
                palindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        slow.next = reverseLL(secondHead);
        return palindrome;
    }
}
