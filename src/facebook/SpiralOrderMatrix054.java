package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/3/29.
 */
public class SpiralOrderMatrix054 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;

        int rowBegin = 0 , colounmBegin = 0, rowEnd = matrix.length - 1 , coloumEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colounmBegin <= coloumEnd){
            // Travel to right!
            for (int i = colounmBegin ; i <= coloumEnd ; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Travel to down!
            for (int i = rowBegin ; i <= rowEnd ; i++){
                res.add(matrix[i][coloumEnd]);
            }
            coloumEnd--;

            // Travel to left!
            if (rowBegin <= rowEnd) {
                for (int i = coloumEnd; i >= colounmBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // Travel to up!
            if (colounmBegin <= coloumEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colounmBegin]);
                }
                colounmBegin++;
            }
        }
        return res;
    }
}
