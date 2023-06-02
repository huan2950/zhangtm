package utils;

// @lc code=start
import java.util.List;


import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

class Solution {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        char ch = '.';
        char[] charArray = new char[n];
        Arrays.fill(charArray,ch);
        String charStr = new String(charArray);
        boolean[] cols = new boolean[n];
        boolean[] main = new boolean[2*n-1];//用来表示主对角线是否放置了皇后(行-列=const)
        boolean[] sub = new boolean[2*n-1];//用来表示副对角线是否放置了皇后(行+列=const)
        for (int i = 0; i < n; i++) {
            board.add(charStr);
        }
        //此时charStr = "....."
        backtrack(board, cols, main, sub, 0);
        return res;

    }

    public void backtrack(List<String> board, boolean[] cols, boolean[] main, boolean[] sub, int row){
        int n = board.size();
        if (row == n){
            res.add(new ArrayList<String>(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!cols[i] && !main[row-i+n-1] && !sub[row+i]){
                StringBuffer sb = new StringBuffer(board.get(row));//get the string to replace "." with "Q"
                //选择
                sb.setCharAt(i, 'Q');
                board.set(row, sb.toString());
                cols[i] = true;
                main[row-i+n-1] = true;
                sub[row+i] = true;

                backtrack(board, cols, main, sub, row+1);
                // 撤销选择
                sb.setCharAt(i, '.');
                board.set(row, sb.toString());
                cols[i] = false;
                main[row-i+n-1] = false;
                sub[row+i] = false;

            }
        }
    }
}


public class Test {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        // int[][] matrix = {{0,0}};
        int n = 4;
        // Get the answer
        List<List<String>> lists = solution.solveNQueens(n);
        // Print the answer
        System.out.println(lists);
    }
}

