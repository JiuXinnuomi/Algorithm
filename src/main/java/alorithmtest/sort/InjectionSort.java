package alorithmtest.sort;

/**
 * 插入排序，希尔，归并的核心思想  ★★★★★
 * 1.将数组分成已排序段和未排序段。初始化时已排序端只有一个元素
 * 2.到未排序段取元素插入到已排序段，并保证插入后仍然有序
 * 3.重复执行上述操作，直到未排序段元素全部加完。
 * @author: knigh
 */
public class InjectionSort {

    public static void main(String[] args) {

        int[] a = new int[]{9,8,7,0,4,2,3,6};
        int n = a.length;

        /*
          拿到未排序元素，将其存放data中
          将已排序的依次和data比较，大于交换，小于break
         */
        for (int i=1; i<n; i++){
            int data = a[i];
            int j = i - 1;
            for (; j>=0; j--){
                if (a[j] > data){   //这步决定了排序的稳定性
                    a[j+1] = a[j];  //j-- 由a[i]的左方开始向前循环，所以使用a[j+1]作为上一位
                }else{
                    break;  //因为前面已经是排好序的 那么找到一个比他小的就不用找了，因为前面的肯定更小
                }
            }
            a[j+1] = data;  //找到位置后，将data插入当前位置
            System.out.print("数组第"+ i +"的循环结果是:\t");
            for (int value : a) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
