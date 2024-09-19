package hot100;

import java.util.List;

public class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode middle = findMiddle(head);
        ListNode revNode = reverse(middle);
        ListNode p1 = head;
        ListNode p2 = revNode;
        boolean res = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverse(revNode);
        return res;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        boolean palindrome = isPalindrome(n1);

        System.out.println(palindrome);
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
