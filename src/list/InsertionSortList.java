package list;

/**
 * 插入排序堆链表进行排序
 *
 * @author by Sean
 * @date 2020/5/20 22:19
 */
public class InsertionSortList {

    public static ListNode solution(ListNode head){
        if(head == null){
            return null;
        }
        //新链表用于存放排好序的元素
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre;
        while (cur != null){
            ListNode next = cur.next;
            pre = temp;
            //找到当前元素插入点
            while (pre.next != null && pre.next.value < cur.value){
                pre = pre.next;
            }
            //元素插入
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode solution = solution(listNode);
        while (solution !=null){
            System.out.println(solution.value);
            solution = solution.next;
        }
    }
}
