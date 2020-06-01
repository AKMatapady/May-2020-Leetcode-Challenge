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
    
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode second;
        ListNode currEven;
        ListNode currOdd;
        
        second = head.next;
        currEven = head.next;
        currOdd = head;
        
        while(currOdd.next != null && currEven.next != null)
        {
            currOdd.next = currEven.next;
            if(currOdd.next != null)
            {
                currOdd = currOdd.next;
                currEven.next = currOdd.next;
                if(currEven.next != null)
                {
                    currEven = currEven.next;
                }
                else
                    break;
            }
            else
                break;
            
        }
        currOdd.next = second;
        
        return head;
    }
}