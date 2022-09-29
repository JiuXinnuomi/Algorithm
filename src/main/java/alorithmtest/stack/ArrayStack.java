package alorithmtest.stack;

/**
 * @author: knigh
 * 用数组实现的栈
 */
public class ArrayStack<T> implements MyStack<T>{

    private Object[] a;
    private int n = 0;

    public ArrayStack(int cap) {
        a = new Object[cap];
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    @Override
    public MyStack<T> push(T item) {

        judgeSize();
        a[n++] = item;

        return null;
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public T pop() {

        if (isEmpty()){
            return null;
        }else {
            T item = (T) a[--n];
            a[n] = null;
            return item;
        }
    }

    /**
     * 返回栈大小
     * @return
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * 判断数组是否需要扩容
     */
    private void judgeSize(){
        if (n >= a.length){
            reSize(2 * a.length);
        }else if (n > 0 && n <= a.length/2){
            reSize(a.length * 2/3);
        }
    }

    /**
     * 数组扩容
     * @param size
     */
    private void reSize(int size){
        T[] temp = (T[]) new Object[size];
        for (int i=0; i<n; i++){
            temp[i] = (T) a[i];
        }
        a = temp;
    }
}
