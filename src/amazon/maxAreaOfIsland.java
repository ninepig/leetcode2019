package amazon;

/**
 * Created by yangw on 2019/4/2.
 */
public class maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int area = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1) {
                    int thisArea = dfs(grid,i,j,0);
                    area = Math.max(thisArea,area);
                }
            }
        }

        return area;
    }

    private int dfs(int[][] grid, int i , int j , int area){
        if(i >= 0 && i< grid.length && j>=0 && j< grid[0].length && grid[i][j] == 1){
            area++;
            grid[i][j] = 0;
            area = dfs(grid,i+1,j,area);
            area = dfs(grid,i,j+1,area);
            area = dfs(grid,i,j-1,area);
            area = dfs(grid,i-1,j,area);
            return area;
        }
        return area;
    }
}
