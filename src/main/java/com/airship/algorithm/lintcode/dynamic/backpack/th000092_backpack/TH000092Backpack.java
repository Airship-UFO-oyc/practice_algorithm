package com.airship.algorithm.lintcode.dynamic.backpack.th000092_backpack;

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
public class TH000092Backpack
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        TH000092Backpack test = new TH000092Backpack();
        test.action();
    }

    public void action()
    {
        int[] A = {2, 3, 5, 7};
        System.out.println(backPack(12, A));
    }

    /**
     * Answer:O(n x m) time and O(n x m) memory.
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
        int[][] value = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
        {
            value[i][0] = 0;
        }
        for (int j = 0; j <= m; j++)
        {
            value[0][j] = 0;
        }
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (A[i - 1] <= j)
                {// 能装下第i个物品.
                    value[i][j] = Math.max(value[i - 1][j],
                            value[i - 1][j - A[i - 1]] + A[i - 1]);
                }
                else
                {// 不能装下第i个物品.
                    value[i][j] = value[i - 1][j];
                }
            }
        }
        maxValue = value[n][m];
        return maxValue;
    }

}
