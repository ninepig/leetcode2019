package facebook;

/**
 * Created by yangw on 2019/3/30.
 */
public class gameOfLife289 {
    // 00 dead  01 next live 10 next dead  11 next live
    // 利用十进制来做这个。
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        for(int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++) {
                int x = getLiveNum(board, i, j);
                if (board[i][j] == 0) {
                    if( x == 3) board[i][j] += 10;
                }else {
                    if(x == 2 || x == 3) board[i][j] += 10;
                }
            }
        }

        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                board[i][j] /= 10;
            }
        }
    }

    /**
     *  周围8格的写法
     * @param board
     * @param x
     * @param y
     * @return
     */
    private int getLiveNum(int[][] board, int x, int y){
        int c=0;
        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || (i==x && j==y)) continue;
                if(board[i][j]%10==1) c++;
            }
        }
        return c;
    }

}
