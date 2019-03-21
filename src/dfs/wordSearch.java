package dfs;

/**
 * Leetcode 79 word search
 * https://leetcode.com/problems/word-search/
 * dfs
 */
public class wordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0 ||word == null ||word.length()==0){
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                boolean res = helper(board,word,used,i,j,0);
                if(res)return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] used, int i, int j, int index) {
        if(word.length() == index){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||used[i][j]||word.charAt(index)!=board[i][j]) return false;
        used[i][j] = true;
        boolean res = helper(board,word,used,i+1,j,index+1)||helper(board,word,used,i-1,j,index+1)||
                helper(board,word,used,i,j+1,index+1)||helper(board,word,used,i,j-1,index+1);
        used[i][j] = false;
        return res;
    }
}
