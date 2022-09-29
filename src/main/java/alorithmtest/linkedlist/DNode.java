package alorithmtest.linkedlist;

/**
 * 双向链表的节点
 * @author: knigh
 */
public class DNode<T> {

    T value;		//值
    DNode<T> next;		//下一个的指针
    DNode<T> pre;		//指向的是前一个指针

    DNode(T value){
        this.value = value;
        this.next = null;
        this.pre = null;
    }

}
