package alorithmtest.linkedlist;

/**
 * 单向节点
 * @author: knigh
 */
public class ListNode<T> {

        T value;		//值
        ListNode<T> next;	//下一个的指针

        ListNode(T value){
            this.value = value;
            this.next = null;
        }
}
