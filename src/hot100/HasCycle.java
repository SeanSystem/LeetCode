package hot100;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean res = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                res = true;
                break;
            }
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
