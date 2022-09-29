package alorithmtest.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 用数组来统计14亿人的年龄分布
 */
public class AgeStas {

    public static void main(String[] args) throws Exception {
        String str = null;
        String fileName = "";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);

        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(isr);
        int tot = 0;
        int[] data = new int[200];
        while ((str = br.readLine()) != null){
            int age = Integer.valueOf(str);
            data[age]++;
            tot++;
        }

        System.out.println("总数据大小" + tot);

        for (int i=0; i<200; i++){
            System.out.println(i + ":" + data[i]);
        }

        System.out.println("计算花费时间：" + (System.currentTimeMillis()-start) + "ms");


    }
}
