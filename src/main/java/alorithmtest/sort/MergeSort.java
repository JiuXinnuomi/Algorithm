package alorithmtest.sort;

import java.util.Arrays;

/**
 * 归并排序  ★★★★★
 * @author: knigh
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] data = { 9, 5, 6, 8, 0, 3, 7, 1 };
        megerSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        //JDK里面的排序源码
    }

    /**
     * 递归拆分，用数组索引下标进行拆分
     * @param data 数组
     * @param left 最左边索引下标
     * @param right 最右边索引下标
     */
    public static void megerSort(int[] data, int left, int right) { // 数组的两端
        // 相等了就表示只有一个数了 不用再拆了,一定要有结束条件
        if (left < right) {
            int mid = (left + right) / 2;
            megerSort(data, left, mid);
            megerSort(data, mid + 1, right);
            // 分完了 接下来就要进行合并，也就是我们递归里面归的过程
            meger(data, left, mid, right);
        }
    }

    /**
     * 合并排序
     * @param data 原数组
     * @param left 最左边索引下标
     * @param mid 每次拆分后的中间索引下标
     * @param right 最右边索引下标
     */
    public static void meger(int[] data, int left, int mid, int right) {
        int[] temp = new int[data.length];		//借助一个临时数组用来保存合并的数据

        /*
          利用指针思想，插入一次比较出的值，向后移一位
          新new一个同长度数组，依次插入二分后较小的数
         */
        int point1 = left;		//表示的是左边的第一个数的位置
        int point2 = mid + 1;	//表示的是右边的第一个数的位置
        int loc = left;		//表示的是我们当前已经到了哪个位置了

        /*
          先判断同时都还未比较的数据，没有一个指针已经走到最右边
          有一个走到终点后，再进行额外判断
         */
        while(point1 <= mid && point2 <= right){
            if(data[point1] < data[point2]){
                temp[loc ++] = data[point1 ++];
            }else{
                temp[loc ++] = data[point2 ++];
            }
        }

        /*
          初步合并完成后，如果还存在左边小于右边较多
          则需要挨个把右边的数据插入数组，左边数据也同理
          最后再将原数组赋值为临时数组，可用return临时数组代替
         */
        while(point1 <= mid){
            temp[loc ++] = data[point1 ++];
        }
        while(point2 <= right){
            temp[loc ++] = data[point2 ++];
        }
        if (right + 1 - left >= 0)   //study
            System.arraycopy(temp, left, data, left, right + 1 - left);
    }
}
