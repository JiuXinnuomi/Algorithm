package alorithmtest.linkedlist;

/**
 * 单向循环链表
 * 链表一定要建立头节点，尾节点来帮助判断位置
 * 改动头节点和尾节点时，要在最后将尾节点的next设置为头节点
 * @author: knigh
 */
public class OneWayCiList<T> {

    ListNode<T> head;
    ListNode<T> tail;
    ListNode<T> jose;
    int size = 0;

    public OneWayCiList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 按位置插入节点
     * 当前节点需要定位在删除位置前一位
     * @param position  位置
     * @param data  数据
     */
    public void insert(int position, T data){
        if (position > size+1){
            throw new RuntimeException("插入位置错误");
        }
        ListNode<T> newNode = new ListNode<>(data);
        ListNode<T> current = head;
        for (int i=1; i<position-1; i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /**
     * 删除位置节点
     * 当前节点需要定位在插入位置前一位
     * 判断时，都以当前节点的下一位作为判断标准
     * @param position  位置
     */
    public void delete(int position){
        if (position > size){
            throw new RuntimeException("删除位置错误");
        }
        if (position == 1){
            deleteHead();
        }else {
            ListNode<T> current = head;
            for (int i=1; i<position-1; i++){
                current = current.next;
            }
            if (current.next == tail){
                current.next = head;
                tail = current;
            }else {
                current.next = current.next.next;
            }
        }
        size--;
    }

    /**
     * 删除头部
     */
    public void deleteHead(){
        head = head.next;
    }

    /**
     * 约瑟夫问题的删除位置节点方法
     * 当前节点需要定位在插入位置前一位
     * @param position  位置
     */
    public void joseDelete(int position){

        ListNode<T> current = jose;
        if (position == 1) {
            deleteHead();
        }else {
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            if (current.next == head) {
                tail.next = current.next.next;
                head = current.next.next;
            } else if (current.next == tail) {
                current.next = head;
                tail = current;
            } else {
                current.next = current.next.next;
            }
        }
        jose = current.next;
        size--;

    }

    /**
     * 获取指定位置数据
     * 当前节点需要定位在查找位置
     * @param position 位置
     * @return 返回数据
     */
    public T getData(int position){
        if (position > size){
            throw new RuntimeException("查找位置错误");
        }
        ListNode<T> current = head;
        for (int i=1; i<position; i++){
            current = current.next;
        }
        return current.value;
    }

    /**
     * 头部插入 √
     * @param data 数据
     */
    public void insertHead(T data){
        ListNode<T> newNode = new ListNode<>(data);
        if (size < 1){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        tail.next = head;
        size++;
    }

    /**
     * 尾部插入 √
     * @param data 数据
     */
    public void insertTail(T data){
        ListNode<T> newNode = new ListNode<>(data);
        if (size < 1){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head;
        size++;
    }

    /**
     * 展示链表所有数据
     */
    public void display(){
        ListNode<T> current = head;
        for (int i=0; i<size; i++){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//        OneWayCiList<Integer> list = new OneWayCiList<>();
//        for (int i=0; i<10; i++){
//            list.insertTail(i);
//        }
//        list.delete(10);
//        list.insert(5,7);
//        System.out.println("");
//        System.out.println(list.getData(10));
//        list.display();
//    }
}
