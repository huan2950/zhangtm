/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int i = 0, j = n - 1;
        while (i < m && j >= 0){
            if (matrix[i][j] == target)return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
// @lc code=end

