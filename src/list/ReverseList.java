package list;

import java.util.Stack;

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
    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归法
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归反转子链表
        ListNode newHeadNode = reverse2(head.next);
        //前节点和后节点反转
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }

    /**
     *  堆栈法（不推荐）
     */
    public static ListNode reverse3(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode temp = newHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            temp.next = node;
            temp = node;
        }
        temp.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode solution = reverse3(listNode);
        while (solution != null) {
            System.out.println(solution.value);
            solution = solution.next;
        }
    }
}
