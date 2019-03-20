package dfs;

/**
 * Leetcode 200
 * 经典中的经典，利用dfs，把遇到的 1 的小岛周围的全部设为1
 * Created by yangw on 2018/12/25.
 */
public class NumberOfisland {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ;j< grid[0].length ;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1') return;
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}