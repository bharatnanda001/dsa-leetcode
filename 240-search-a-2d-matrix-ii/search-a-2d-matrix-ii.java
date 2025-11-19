class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix , 0 , matrix[0].length - 1 , target);
    }
    public boolean helper(int[][] matrix , int row , int col , int target){
        if(row >= matrix.length || col < 0){
            return false;
        }
        if(target == matrix[row][col]){
            return true;
        }
        else if (target > matrix[row][col]){
            return helper(matrix , row + 1 , col , target);
        }
        else{
            return helper(matrix , row , col - 1, target);
        }
    }
}