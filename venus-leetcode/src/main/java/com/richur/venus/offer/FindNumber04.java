package com.richur.venus.offer;

public class FindNumber04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int colum = matrix.length;
        int row= matrix[0].length;
        int i = colum - 1;
        int j = 0;
        while(j < row && i >= 0) {
            //System.out.println(i+":"+j);
            if(matrix[i][j] == target) {
                return true;
            }
            if(matrix[i][j] > target) {
                i --;
            } else {
                j ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[1][2];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        findNumberIn2DArray(matrix, 1);
    }
}
