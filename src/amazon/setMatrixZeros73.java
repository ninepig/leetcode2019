package amazon;

/**
 * Created by yangw on 2019/4/15.
 */
public class setMatrixZeros73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int fr = 1, fc = 1;
        for (int i = 0 ; i < matrix.length ;i++ ){
            for (int j = 0 ; j < matrix[0].length ;j++){
                if(matrix[i][j] == 0){
                    if(i == 0) fr = 0;
                    if(j == 0) fc = 0;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1 ; i < matrix.length;i++){
            for (int j = 1 ; j <matrix[0].length ;j++){
                if(matrix[i][0]==0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr == 0){
            for (int i = 0 ; i < matrix[0].length ; i++){
                matrix[0][i] = 0;
            }
        }
        if(fc == 0){
            for ( int i = 0; i<matrix.length ; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
