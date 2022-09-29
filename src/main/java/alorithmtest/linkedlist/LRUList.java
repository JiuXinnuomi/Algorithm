package alorithmtest.linkedlist;

/**
 * @author: knigh
 */
public class LRUList<T> {

    MyArrayList<T> lruList = new MyArrayList<>();
    int len = lruList.size();

    public void LRU(T data){
        lruList.remove(data);
        lruList.addHead(data);
    }

    public T get(int i){
        return lruList.get(i);
    }

    public static void main(String[] args) {
        int[] lru = new int[]{9,8,7,6,5,4,3,2,3,4,5,6,7};
        LRUList<Integer> list = new LRUList<>();
        for(int i: lru){
            list.LRU(i);
        }
        for (int i=0; i<list.len; i++){
            System.out.println(list.get(i));
        }
    }

}
