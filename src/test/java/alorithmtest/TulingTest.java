package alorithmtest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: knigh
 */
public class TulingTest {

    @Test
    public void test01(){
        int divide = divide(15, 2);
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{5,6,7,8};
        System.out.println(a+"============"+b);
        a = b;
        System.out.println(a);
    }

    /**
     * 不用乘，除求余
     */
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648
            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
            if ((a >> i) - b >= 0) { // a >= (b << i)
                a -= (b << i);
                res += (1 << i);
            }
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }

    /**
     * 计算素数的个数(暴力法)
     */
    public int primeCount1(int a) {
        int count = 0;
        for (int i=2; i<a; i++){
            count += isPrime(i)? 1:0;
        }
        return count;
    }
    public boolean isPrime(int x){
        for (int i=2; i<Math.sqrt(x); i++){
            if (x%i == 0){
                return false;
            }
        }
        return true;
    }

    //eratosthenes埃筛选法 =====
    public int primeCount2(int n){
        int count = 0;
        boolean[] isPrime = new boolean[n]; //false代表素数，boolean初始化默认为false
        for (int i=2; i<n; i++){
            if (!isPrime[n]){
                count++;
                for (int j = i*i; j<n; j += i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    /**
     * 删除数组中重复的元素，同时不能使用新数组(双指针算法)
     */
    public int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j=1; j<nums.length; j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    /**
     *
     */


}
