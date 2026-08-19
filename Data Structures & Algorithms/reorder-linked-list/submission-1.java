class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;

        slow.next = null; // Split the list

        while (curr != null) {
            ListNode temp = curr.next; // Save next node

            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // 3. Merge both halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode curr1 = first.next;
            ListNode curr2 = second.next;

            first.next = second;
            second.next = curr1;

            first = curr1;
            second = curr2;
        }
    }
}