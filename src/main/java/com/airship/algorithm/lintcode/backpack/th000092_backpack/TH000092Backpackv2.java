package com.airship.algorithm.lintcode.backpack.th000092_backpack;

/**
 * 
 * 92. Backpack
 * <p>
 * Description: Given n items with size Ai, an integer m denotes the size of a
 * backpack. How full you can fill this backpack?
 * <p>
 * Notice:You can not divide any item into small pieces.
 * <p>
 * Example: If we have 4 items with size [2, 3, 5, 7], the backpack size is 11,
 * we can select [2, 3, 5], so that the max size we can fill this backpack is
 * 10. If the backpack size is 12. we can select [2, 3, 7] so that we can
 * fulfill the backpack. You function should return the max size we can fill in
 * the given backpack.
 * <p>
 * Challenge: O(n x m) time and O(m) memory. O(n x m) memory is also acceptable
 * if you do not know how to optimize memory.
 * 
 * @author Airship 2018年5月4日
 * @see [相关类/方法]
 * @since 1.0
 */
public class TH000092Backpackv2
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        TH000092Backpackv2 test = new TH000092Backpackv2();
        test.action();
    }

    public void action()
    {
        int[] A = {2, 3, 5, 7};
        System.out.println(backPack(12, A));
    }

    /**
     * Answer:O(n x m) time and O(m) memory.
     * <p>
     * 参考：https://blog.csdn.net/qq_37119057/article/details/79324485
     * <p>
     * 01背包中中状态转移方程：f[i][v]=max{f[i-1][v], f[i-1][v-c[i]]+w[i]};
     * <p>
     * 目标：第i次循环结束后f[v]中表示的就是我们定义的状态f[i][v]
     * <P>
     * 方法：在第二层循环中，需要逆序以v=V..0的顺序推f[v]，才能保证推f[v]时f[v-c[i]]保存的是状态f[i-1][v-c[i]]的值。
     * 即每次进入第二层循环时，被子问题f[v-c[i]]与f[v]都保存的是上个循环即i=i-1时候的值
     * 
     * @param m:
     *            An integer m denotes the size of a backpack
     * @param A:
     *            Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A)
    {
        // write your code here
        int maxValue = 0;
        int n = A.length;
        int[] value = new int[m + 1];
        for (int j = 0; j <= m; j++)
        {
            value[j] = 0;
        }
        for (int i = 1; i <= n; i++)
        {
            for (int j = m; j >= 1; j--)
            {
                if (A[i - 1] <= j)
                {// 能装下第i个物品.
                    value[j] = Math.max(value[j],
                            value[j - A[i - 1]] + A[i - 1]);
                }
                else
                {// 不能装下第i个物品.
                    value[j] = value[j];
                }
            }
        }
        maxValue = value[m];
        return maxValue;
    }

}
