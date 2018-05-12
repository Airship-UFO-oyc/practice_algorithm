package com.airship.algorithm.acmsjtueducn.dynamic.backpack;

import java.util.Scanner;

/**
 * 
 * 1013. 无限背包<br>
 * <p>
 * Description<br>
 * 你现在有一个体积为V的大袋子，有N种物品，假设每种物品的数量有无限多个，而且第i种物品的体积是c[i],价值是w[i],请选择一些物品放入袋中，使袋中物品的价值总和最大。<br>
 * 
 * 注意每种物品的数量是无限多的；对于放入袋中的同种物品数量没有限制。<br>
 * 
 * Input Format<br>
 * 第一行包含两个正整数V和N，分别代表袋子的体积和物品的种类数。<br>
 * 
 * 以下N行分别由2个正整数组成，代表每种物品的体积和价值。<br>
 * 
 * V≤10000,N≤1000。<br>
 * 
 * 保证操作可在C++ int范围内完成。<br>
 * 
 * Output Format<br>
 * 输出一个整数，表示最大的价值总和<br>
 *
 * Sample Input<br>
 * 5 3<br>
 * 2 3<br>
 * 3 2<br>
 * 4 1<br>
 * Sample Output<br>
 * 6<br>
 * 
 * @author Airship 2018年5月12日
 * @see [相关类/方法]
 * @since 1.0
 */
public class TH0001013_InfiniteBackpack
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        new TH0001013_InfiniteBackpack().action();

    }

    // 提交模板.
    //
    // import java.util.Scanner;
    //
    // public class Main {
    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // int a = in.nextInt();
    // int b = in.nextInt();
    // System.out.println(a + b);
    // }
    // }

    /**
     * 思想：f[i][v]=max{f[i-1][v], f[i-1][v-c[i]]+w[i]}; <br>
     * 改进：f[v]=max{f[v],f[v-c[i]]+w[i]}
     */
    private void action()
    {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int N = in.nextInt();
        int[] value = new int[V + 1];// 背包大小
        int[] C = new int[N + 1];// 记录每件物品的花费
        int[] W = new int[N + 1];// 记录每件物品的价值
        C[0] = W[0] = 0;
        for (int i = 1; i <= N; i++)
        {
            C[i] = in.nextInt();
            W[i] = in.nextInt();
        }
        for (int i = 0; i <= V; i++)
        {
            value[i] = 0;
        }
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= V; j++)
            {
                if (j >= C[i])
                {
                    value[j] = Math.max(value[j], value[j - C[i]] + W[i]);
                }
            }
        }
        System.out.println(value[V]);
    }

}
