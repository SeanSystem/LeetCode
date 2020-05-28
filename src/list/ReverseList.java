package list;

/**
 * 反转链表
 *
 * @author Sean
 * @date 2020/05/28
 */
public class ReverseList {

    /**
     * 迭代法
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode p1 = head;
            ListNode p2 = head.next;
            ListNode p3;
            while (p2 != null) {
                p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;
            }
            head.next = null;
            head = p1;
        }
        return head;
    }

    /**
     * 递归法
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            //递归反转子链表
            ListNode newHeadNode = reverse2(head.next);
            //前节点和后节点反转
            head.next.next = head;
            head.next = null;
            return newHeadNode;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode solution = reverse2(listNode);
        while (solution != null) {
            System.out.println(solution.value);
            solution = solution.next;
        }
    }
}
