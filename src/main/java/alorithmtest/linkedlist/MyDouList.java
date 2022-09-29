package alorithmtest.linkedlist;

/**
 * 双向链表
 * @author: knigh
 */
public interface MyDouList<T> {

    /**
     * 头部插入数据
     * @param data
     */
    public void insertHead(T data);

    /**
     * 中间插入数据
     * 33位就是32位后面
     * @param data
     * @param position
     */
    public void insertMid(T data,int position);

    /**
     * 尾部插入数据
     * @param data
     */
    public void insertTail(T data);

    /**
     * 删除头部节点
     */
    public T deleteHead();

    /**
     * 删除指定数据
     * @param data
     */
    public T deleteKey(T data);

    /**
     * 删除指定索引
     * @param position
     */
    public T deletePos(int position);

    /**
     * 删除尾部节点
     */
    public T deleteEnd();

    /**
     * 获取链表长度
     * @return
     */
    public int size();

    /**
     * 判断链表是否存在
     * @return
     */
    public boolean isEmpty();

}
