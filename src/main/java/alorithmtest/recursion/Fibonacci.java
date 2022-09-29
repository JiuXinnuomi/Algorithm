package alorithmtest.recursion;

/**
 * 递归&分治&回溯 思想
 */

public class Fibonacci {

	private static int data[]; // 初始换全部是0

	/**
	 * 斐波那契数列 普通递归求解
	 * 分析一段代码好坏，有两个指标，时间复杂度和空间复杂度 都是：O(2^n)
	 * 递归的终止条件
	 * 继续递归的过程
	 * @param n
	 * @return
	 */
	public static int fab(int n) {
		if (n <= 2)
			return 1;
		return fab(n - 1) + fab(n - 2);
	}

	/**
	 * 求N的阶乘 普通递归
	 * @param n
	 * @return
	 */
	public static int fac(int n) {
		if (n <= 1)
			return 1;
		return n * fac(n - 1);
	}

	/**
	 * 斐波那契数列 循环求解
	 * 递归优化方法一
	 * 设定三个变量，分别赋值需求值n，上次结果，上上次结果
	 * @param n
	 * @return
	 */
	public static int noFab(int n) {
		// 循环
		if (n <= 2)
			return 1;
		int a = 1;
		int b = 1;
		int c = 0;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	/**
	 * 斐波那契数列 添加缓存的递归
	 * 递归优化方法二
	 * 用数组来做缓存 将为了O(n)，空间也降至为O(n)
	 * @param n
	 * @return
	 */
	public static int fab2(int n) {
		if (n <= 2)
			return 1;
		if (data[n] > 0) {
			return data[n];
		}
		int res = fab2(n - 1) + fab2(n - 2);
		data[n] = res;
		return res;
	}

	/**
	 * 斐波那契数列 尾递归
	 * 递归优化方法三
	 * 时间复杂度和空间复杂度 都是： O(n)
	 * 和递归是反向运算
	 * @param pre 上上一次运算出来的结果
	 * @param res 上一次运算出来结果
	 * @param n 是肯定有的
	 * @return
	 */
	public static int tailfab(int pre,int res,int n) {
		if (n <= 2)
			return res; // 递归的终止条件
		return tailfab(res, pre + res, n - 1);		//JDK源码
	}

	/**
	 * 求N的阶乘 尾递归
	 * 递归优化方法三
	 *
	 * @param n 初始设定值
	 * @param res 上一次运算的结果
	 * @return
	 */
	public static int tailFac(int n, int res) {
		System.out.println(n + ":" + res);
		if (n <= 1)
			return res;
		return tailFac(n - 1, n * res);	//倒着算
	}
	
	

	
	public static void main(String[] args) {
		for (int i = 1; i <= 45; i++) {
			long start = System.currentTimeMillis();
			System.out.println(i + ":" + tailfab(1,1,i) + " 所花费的时间为"
					+ (System.currentTimeMillis() - start) + "ms");
		}
		//tailFac(5, 1);
		
		/*
		 * for (int i = 1; i <= 45; i++) { long start =
		 * System.currentTimeMillis(); System.out.println(i + ":" + fab(i) +
		 * " 所花费的时间为" + (System.currentTimeMillis() - start) + "ms"); }
		 */

		/*for (int i = 1; i <= 45; i++) {
			long start = System.currentTimeMillis();
			System.out.println(i + ":" + noFab(i) + " 所花费的时间为"
					+ (System.currentTimeMillis() - start) + "ms");
		}
		System.out.println("==================================");
		System.out.println("加了缓存的情况");
		for (int i = 1; i <= 45; i++) {
			data = new int[46];
			long start = System.currentTimeMillis();
			System.out.println(i + ":" + fab2(i) + " 所花费的时间为"
					+ (System.currentTimeMillis() - start) + "ms");
		}*/
	}
}
