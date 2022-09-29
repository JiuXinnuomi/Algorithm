package alorithmtest.linkedlist;

/**
 * 约瑟夫问题
 * 点名，点到谁，淘汰谁
 * @author: knigh
 */
public class JosephList {

    private static final OneWayCiList<Integer> joseList = new OneWayCiList<>();
    /**
     * 点名
     * @param n 点名的位置
     */
    public static int joseph(int n){

        joseList.jose = joseList.head;

        while (joseList.size != 1) {
            joseList.joseDelete(n);
            joseList.display();
        }
        return joseList.getData(1);
    }

    /**
     * 约瑟夫数组初始化
     * @param number 初始化数组
     */
    public static void init(int[] number){

        for (int i: number){
            joseList.insertTail(i);
        }
        joseList.display();
    }

    public static void main(String[] args) {
        int[] msg = new int[]{9,7,5,8,6,4,5,3,0,1,2};
        init(msg);
        System.out.println(joseph(5));
    }

}
