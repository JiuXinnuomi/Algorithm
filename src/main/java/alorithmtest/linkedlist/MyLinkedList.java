package alorithmtest.linkedlist;

/**
 * 单向链表
 * @param <T>
 */
public class MyLinkedList<T> {
	
	private ListNode<T> head;
	private int size = 0;		//

	/**
	 * 插入链表的头部
	 * @param data 插入的数据
	 */
	public void insertHead(T data){
		ListNode<T> newNode = new ListNode(data);
		//如果原来就有数据呢？
		newNode.next = head;		//栈内存的引用
		head = newNode;
		size ++;
		//插入O(1)
	}

	/**
	 * 插入链表的中间
	 * @param data 插入的数据
	 * @param position 插入的位置
	 */
	public void insertNth(T data,int position){
		if(position == 0) {		//这个表示插入在头部了
			insertHead(data);
		}else{
			ListNode<T> cur = head;
			for(int i = 1; i < position ; i++){
				cur = cur.next;		//一直往后遍历   p=p->next;  ->是c++里面的往后找指针
			}
			ListNode<T> newNode = new ListNode(data);
			//
			newNode.next = cur.next;		//新加的点指向后面 保证不断链
			cur.next = newNode;			//把当前的点指向新加的点
		}
		size++;
	}
	/*int a = 1;
	int b = a;
	int a = 2;*/

	/**
	 * 头部删除
	 */
	public void deleteHead(){//O(1)
		head = head.next;
	}

	/**
	 * 中间删除
	 * @param position 删除的位置
	 */
	public void deleteNth(int position){//O(n)
		if(position == 0) {
			deleteHead();
		}else{
			ListNode<T> cur = head;
			for(int i = 1; i < position ; i ++){
				cur = cur.next;
			}
			cur.next = cur.next.next; //cur.next 表示的是删除的点，后一个next就是我们要指向的
		}
		size--;
	}

	/**
	 * 查找数据
	 * @param data 需要查找的数据
	 */
	public void find(T data){//O(n)
		ListNode<T> cur = head;
		while(cur != null){
			if(cur.value == data) break;
			cur = cur.next;
		}
	}

	public int getSize(){
		return size;
	}

	/**
	 * 打印数据
	 */
	public void print(){
		ListNode<T> cur = head;
		while(cur != null){
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}
//	public static void main(String[] args) {
//		MyLinkedList<Integer> myList = new MyLinkedList<>();
//		myList.insertHead(5);
//		myList.insertHead(7);
//		myList.insertHead(10);
//		myList.print(); // 10 -> 7 -> 5
//		myList.deleteNth(0);
//		myList.print(); // 7 -> 5
//		myList.deleteHead();
//		myList.print(); // 5
//		myList.insertNth(11, 1);
//		myList.print(); // 5 -> 11
//		myList.deleteNth(1);
//		myList.print(); // 5
//	}
}
