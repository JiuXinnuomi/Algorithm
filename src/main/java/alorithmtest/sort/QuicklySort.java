package alorithmtest.sort;

/**
 * 快速排序 ★★★★★
 */
public class QuicklySort {

	/**
	 * 定义一个准基数，将整个数组分成大小俩部分
	 * 从右边开始找，找到比准基数小的数据，与之交换位置，寻找的索引下标减一
	 * 再从左边开始找，找到比准基数大的数据，与之交换位置，寻找的索引下标加一
	 * 最后将分出来的三部分，左右俩部分继续进行递归
	 * @param data 整个数据组
	 * @param left 数组中最左边的下标
	 * @param right 数组中最右边的下标
	 */
	public static void qSort(int[] data, int left, int right) {

		int base = data[left]; // 就是我们的基准数，取序列的第一个,不能用data[0]
		int ll = left; // 表示的是从左边找的位置
		int rr = right; // 表示从右边开始找的位置

		/*
         2个判断条件，指针和数据条件都成立时，防止数组越界
         只需要再判断一次指针，就可以确保数据条件一定成立，不需要再判断数据
         */
		while (ll < rr) {
			// 从右边挨个找比准基数大的数
			while (ll < rr && data[rr] >= base) {
				rr--;
			}
			if (ll < rr) { // 表示是找到有比之大的，互换位置
				int temp = data[rr];
				data[rr] = data[ll];
				data[ll] = temp;
				ll++;	//此处ll自增不会影响结果，但是计算时会少做一步操作，优化算法
			}
			while (ll < rr && data[ll] <= base) {
				ll++;
			}
			if (ll < rr) { //找到有比之小的，互换位置
				int temp = data[rr];
				data[rr] = data[ll];
				data[ll] = temp;
				rr--;	//此处同理
			}
		}

		/*
         递归判断时，必须考虑左右各2种情况。
         可能左边分完，右边还能份分很多次
         肯定是递归 分成了三部分,左右继续快排，注意要加条件不然递归就栈溢出了
         */
		if (left < ll)
			qSort(data, left, ll - 1);
		if (ll < right)
			qSort(data, ll + 1, right);

	}
}
