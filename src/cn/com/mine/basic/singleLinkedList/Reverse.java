package cn.com.mine.basic.singleLinkedList;

public class Reverse {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		print(node);
		print(reverse3(node));
	}

	public static void print(Node node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	// 方法1
	public static Node reverseList(Node head) {

		// 如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
		if (head == null || head.next == null) {
			return head;
		}

		Node current = head;
		Node next = null; // 定义当前结点的下一个结点
		Node reverseHead = null; // 反转后新链表的表头

		while (current != null) {
			next = current.next; // 暂时保存住当前结点的下一个结点，因为下一次要用

			current.next = reverseHead; // 将current的下一个结点指向新链表的头结点
			reverseHead = current;

			current = next; // 操作结束后，current节点后移
		}

		return reverseHead;
	}
	
	public Node reverse2(Node node, Node prev) {
	    if (node.next == null) {
	      node.next = prev;
	      return node;
	    } else {
	      Node re = reverse2(node.next, node);
	      node.next = prev;
	      return re;
	    }
	}
	public static Node reverse3(Node node) {
	    if(node.next==null)return node;
	    Node next = node.next;
	    node.next = null;
	    Node re = reverse3(next);
	    next.next = node;
	    return re;
	  }
}
