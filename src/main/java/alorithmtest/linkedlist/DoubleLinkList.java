package alorithmtest.linkedlist;

/**
 * 双向链表
 * @param <T>
 */
public class DoubleLinkList<T> {		// 双向链表

	private DNode head;		//头
	private DNode tail;		// 尾
	
	DoubleLinkList(){
		head = null;
		tail = null;
	}

	/**
	 * 链表插入头部节点
	 * @param data
	 */
	public void inserHead(T data){
		DNode newNode = new DNode(data);
		if(head == null){
			tail = newNode;
		}else{
			head.pre = newNode;
			newNode.next = head;
		}
		head = newNode;
	}

	/**
	 * 链表删除头部节点
	 */
	public void deleteHead(){
		if(head == null) return ;		//没有数据
		if(head.next == null){		//就一个点
			tail = null;
		}else{
			head.next.pre = null;	
		}
		head = head.next;
	}

	/**
	 * 删除指定数据
	 * @param data
	 */
	public void deleteKey(T data){
		DNode current = head;
		while (current.value != data) {
			if (current.next == null) {
				System.out.println("没找到节点");
				return ;
			}
			current = current.next;
		}
		if (current == head) {// 指向下个就表示删除第一个
			deleteHead();
		} else {
			current.pre.next = current.next;
			if(current == tail){		//删除的是尾部
				tail = current.pre;
				current.pre = null;
			}else{
				current.next.pre = current.pre;
			}
		}
	}
}
