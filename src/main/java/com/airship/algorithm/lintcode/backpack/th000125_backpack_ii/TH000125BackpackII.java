package com.airship.algorithm.lintcode.backpack.th000125_backpack_ii;

/**
 * 
 * Title：125. Backpack II<br>
 * https://www.lintcode.com/problem/backpack-ii/description
 * <p>
 * 对比:92题的[价值]和[重量]未分开,125题的[价值]和[重量]是分开的.
 * <p>
 * Description:<br>
 * Given n items with size Ai and value Vi, and a backpack with size m. What's
 * the maximum value can you put into the backpack?
 * <p>
 * Notice:<br>
 * You cannot divide item into small pieces and the total size of items you
 * choose should smaller or equal to m.
 * <p>
 * Example:<br>
 * Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack
 * with size 10. The maximum value is 9.
 * <p>
 * Challenge:<br>
 * O(n x m) memory is acceptable, can you do it in O(m) memory?
 * 
 * @author Airship 2018年5月5日
 * @see [相关类/方法]
 * @since 1.0
 */
public class TH000125BackpackII
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        TH000125BackpackII test = new TH000125BackpackII();
        test.action();
    }

    public void action()
    {
        int m = 10;
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
        System.out.println(backPackII(m, A, V));
    }

    /**
     * Answer:O(n x m) time and O(n x m) memory.
     * 
     * @param m:
     *            An integer m denotes the size of a backpack
     * @param A:
     *            Given n items with size A[i]
     * @param V:
     *            Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V)
    {
        // write your code here
        int maxValue = 0;
        int n = A.length;
        int[][] value = new int[n + 1][m + 1];// 从1开始.
        for (int i = 0; i <= n; i++)
        {// 初始化第0列.
            value[i][0] = 0;
        }
        for (int j = 0; j <= m; j++)
        {// 初始化第0行.
            value[0][j] = 0;
        }
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (j >= A[i - 1])
                {// 能装下第i个物品时(第i个物品的[价值]和[重量]均放在i-1下标处).
                    value[i][j] = Math.max(value[i - 1][j],
                            value[i - 1][j - A[i - 1]] + V[i - 1]);
                }
                else
                {// 不能装下第i个物品时.
                    value[i][j] = value[i - 1][j];
                }
            }
        }
        maxValue = value[n][m];
        return maxValue;
    }

}
