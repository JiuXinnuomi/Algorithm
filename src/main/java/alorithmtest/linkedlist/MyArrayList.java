package alorithmtest.linkedlist;


public class MyArrayList<E> implements MyList<E> {

	private static final int DEFAULT_SIZE = 10;
	private Object[] data;
	private int index;
	private int size;

	public MyArrayList() {
		this.data = new Object[DEFAULT_SIZE];
		this.size = DEFAULT_SIZE;
	}

	@Override
	public void add(E e) {
		data[index++] = e;
		if (index == size) { // ����
			this.size = this.size * 2 + 1;
			Object[] newData = new Object[this.size];
			System.arraycopy(data, 0, newData, 0, data.length);
			this.data = newData;
		}
	}

	/**
	 * 头部插入
	 * @param e 数据
	 */
	public void addHead(E e){
		if (index == size){
			data[index] = null;
		}
		if (index - 1 >= 0) System.arraycopy(data, 0, data, 1, index - 1);
		data[0] = e;
	}

	@Override
	public void remove(int i) {
		if (i >= 0 && i < index) {
			if (this.data.length - 1 - i >= 0) System.arraycopy(data, i + 1, data, i, this.data.length - 1 - i);
			this.index--;
		}
	}

	@Override
	public E get(int i) {
		if (i >= 0 && i < index) {
			return (E) this.data[i];
		}
		return null;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public boolean isEmpty() {
		return index <= 0;
	}

	@Override
	public void remove(Object e) {
		if(!isEmpty()) {
			for(int i = 0 ; i < this.data.length ; i ++) {
				if(data[i].equals(e)) {
					remove(i);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(1);
		list.add(5);
		list.add(4);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		Integer integer = 5;
		list.remove(integer);
		System.out.println(list.get(1));
	}
	
}
