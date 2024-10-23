package hot100;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class MinStack {

    class Node {
        int val;
        Node next;
        int min;

        public Node() {
            this.min = Integer.MAX_VALUE;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node top;

    public MinStack() {
        top = new Node();
    }

    public void push(int val) {
        Node node = new Node(val, top.next);
        top.next = node;
        node.min = top.min;
        top.min = Math.min(val, top.min);
    }

    public void pop() {
        Node cur = top.next;
        if (cur.val == top.min) {
            top.min = cur.min;
        }
        top.next = cur.next;
        cur.next = null;
    }

    public int top() {
        return top.next.val;
    }

    public int getMin() {
        return top.min;
    }
}
