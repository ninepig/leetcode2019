package amazon;

/**
 * Created by yangw on 2019/4/10.
 */
public class FloodFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;

        int color = image[sr][sc];
        if(color != newColor) dfs(image, sr , sc , newColor, color);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor,int color){

        if(image[sr][sc] == color){
            image[sr][sc] = newColor;
            if(sr > 0)dfs(image,sr-1,sc,newColor,color);
            if(sc > 0)dfs(image,sr,sc-1,newColor,color);
            if(sr < image.length - 1) dfs(image, sr + 1 ,sc, newColor, color);
            if(sc < image[0].length - 1) dfs(image, sr, sc+1 ,newColor ,color);
        }

    }
}
