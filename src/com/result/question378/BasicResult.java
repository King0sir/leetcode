package com.result.question378;

/**
 * Created by kingsir on 16-8-1.
 */
public class BasicResult {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int[][] matrix = new int[][]{{1,3,5},{6,7,12},{11,14,14}};
        int k = 2;
        BasicResult basicResult = new BasicResult();
        int res = basicResult.kthSmallest(matrix,k);
        System.out.println(res);

//        int[] a = new int[]{1, 5, 9, 10, 11, 12, 13, 15};
//        int re = basicResult.getBiggerIndex(a,4);
//        System.out.println(re);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        while (min < max){
            int mid = (min + max)/2;
            int count = 0;
            for(int i = 0;i< n;i++){
                count += this.getBiggerIndex(matrix[i],mid);
            }
            if(count < k){
                min = mid + 1;
            }else {
                max = mid;
            }
        }
        return min;
    }

    private int getBiggerIndex(int[] array, int target){
        int len = array.length;
        int small = 0;
        int big = len-1;
        while ( small < big ){
            int mid = (small+big)/2;
            if(array[mid] <= target){
                small = mid + 1;
            }else{
                big = mid;
            }
        }
        if(array[small] > target){
            return small ;
        }
        return big +1;
    }

    private int getBigger(int[] array,int target){
        for(int i=0;i< array.length;i++){
            if(array[i] > target){
                return i;
            }
            if(array[i] == target){
                return i+1;
            }
        }
        return 0;
    }
}
