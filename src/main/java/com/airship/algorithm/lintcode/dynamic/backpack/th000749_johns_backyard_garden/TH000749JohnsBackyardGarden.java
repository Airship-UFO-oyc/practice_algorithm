package com.airship.algorithm.lintcode.dynamic.backpack.th000749_johns_backyard_garden;

/**
 * 
 * 749. John's backyard garden
 * <p>
 * 无限背包.
 * <p>
 * https://www.lintcode.com/en/problem/johns-backyard-garden/
 * <p>
 * John wants to build a back garden on the empty space behind his home. There
 * are two kinds of bricks now, one is 3 dm high and the other is 7 dm high.
 * John wants to enclose a high x dm wall. If John can do this, output YES,
 * otherwise NO.
 * <p>
 * Notice: X is an integer, and it's range is [3, 1000].
 * 
 * @author Airship 2018年5月13日
 * @see [相关类/方法]
 * @since 1.0
 */
public class TH000749JohnsBackyardGarden
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        new TH000749JohnsBackyardGarden().action();

    }

    public void action()
    {
        int x = 13;
        System.out.println(isBuild(x));
    }

    /**
     * @param x:
     *            the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x)
    {
        // write you code here
        String mark = "NO";
        int[] value = new int[x + 1];
        int[] CW = {0, 3, 7};
        value[0] = 0;
        for (int i = 1; i <= 2; i++)
        {
            for (int j = 1; j <= x; j++)
            {
                if (j >= CW[i])
                {
                    value[j] = Math.max(value[j], value[j - CW[i]] + CW[i]);
                }
            }
        }
        if (value[x] == x)
        {
            mark = "YES";
        }
        return mark;
    }

}
