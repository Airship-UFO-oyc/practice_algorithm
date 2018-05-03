package com.airship.algorithm.lintcode.backpack.th000092_backpack;

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
        
    }
    
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int maxValue = 0;
        int n = A.length; 
        int[][] value = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            value[i][0]=0;
        }
        for(int j=0;j<=m;j++) {
            value[0][j]=0;
        }
        
        return maxValue;
    }

}
