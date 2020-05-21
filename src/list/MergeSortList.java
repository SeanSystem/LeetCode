package list;

/**
 * 归并排序链表
 *
 * @author Sean
 * @date 2020/05/21
 */
public class MergeSortList {

    /**
     * 单链表的归并排序
     */
    public static ListNode merge_sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //得到链表中间的数
        ListNode middle = getMiddle(head);
        ListNode sHalf = middle.next;
        //拆分链表
        middle.next = null;
        //递归调用
        return merge(merge_sort(head), merge_sort(sHalf));
    }


    /**
     * 合并排好序的链表
     */
    public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummyHead, curr;
        dummyHead = new ListNode(0);
        curr = dummyHead;
        while (a != null && b != null) {
            if (a.value <= b.value) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        curr.next = (a == null) ? b : a;
        return dummyHead.next;
    }

    /**
     * 找到中间点，然后分割
     */
    public static ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        //快慢指针
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode1 = merge_sort(listNode);
        while (listNode1 !=null){
            System.out.println(listNode1.value);
            listNode1 = listNode1.next;
        }
    }
}
