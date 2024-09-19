package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = createNewNode(head);
        Node curr = head;
        Node temp = newHead;
        Node newHeadTemp = newHead;
        while (curr != null) {
            map.put(curr, temp);
            curr = curr.next;
            temp.next = createNewNode(curr);
            temp = temp.next;
        }
        while (newHeadTemp != null) {
            Node random = newHeadTemp.random;
            if (random != null) {
                newHeadTemp.random = map.get(random);
            }
            newHeadTemp = newHeadTemp.next;
        }
        return newHead;
    }

    public Node createNewNode(Node head) {
        if (head == null) {
            return null;
        }
        Node newNode = new Node(head.val);
        newNode.random = head.random;
        return newNode;
    }

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
