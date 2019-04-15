package amazon;

/**
 * Created by yangw on 2019/4/9.
 */
public class searchMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int x = matrix.length - 1;
        int y = 0;

        while (x >= 0 && y < matrix[0].length){
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                y++;
            }else {
                x--;
            }
        }
        return false;
    }

}
