package list;

/**
 * 链表节点
 *
 * @author by Sean
 * @date 2020/5/20 22:21
 */
public class ListNode {

     int value;

     ListNode next;

    public ListNode(int value){
        this.value =value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
