package facebook;

public class ticTacToe348 {
    int n ;
    int[] cols;
    int[] rows;
    int diag;
    int antiDiag;
    public ticTacToe348(int n) {
        this.n = n;
        cols = new int[n];
        rows = new int[n];
        diag = 0;
        antiDiag = 0;
    }

    public int move(int row, int col, int player) {
        if(player == 1){
            cols[col]++;
            rows[row]++;
            if(row == col) diag++;
            if(row + col == n - 1) antiDiag++;
        }
        if(player == 2){
            cols[col]--;
            rows[row]--;
            if(row == col) diag--;
            if(row + col == n - 1) antiDiag--;
        }
        if(cols[col] == n || rows[row] == n || diag == n || antiDiag == n){
            return 1;
        }
        if(cols[col] == -n || rows[row] == -n || diag == -n || antiDiag == -n){
            return 2;
        }
        return 0;
    }
}
