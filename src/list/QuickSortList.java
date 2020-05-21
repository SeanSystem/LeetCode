package list;

/**
 * 链表快速排序
 *
 * @author Sean
 * @date 2020/05/21
 */
public class QuickSortList {

    public static ListNode quick_sort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode portion = portion(head, end);
            quick_sort(head, portion);
            quick_sort(portion.next, end);
        }
        return head;
    }

    private static ListNode portion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;
        while (p2 != null) {
            if (p2.value < head.value) {
                p1 = p1.next;
                int temp = p2.value;
                p2.value = p1.value;
                p1.value = temp;
            }
            p2 = p2.next;
        }
        //判断是否是有序的，有序则不交换p1和head的值
        if (head != p1) {
            int temp = p1.value;
            p1.value = head.value;
            head.value = temp;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode1 = quick_sort(listNode, null);
        while (listNode1 != null) {
            System.out.println(listNode1.value);
            listNode1 = listNode1.next;
        }
    }
}
