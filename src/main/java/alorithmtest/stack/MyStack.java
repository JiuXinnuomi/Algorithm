package alorithmtest.stack;

/**
 * @author: knigh
 */
public interface MyStack<T> {

    MyStack<T> push(T item);		//入栈

    T pop();	//出栈

    int size();	// 大小

    boolean isEmpty(); //判断是否为空

}
