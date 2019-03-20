package unionfind;

/**
 * Created by yangw on 2019/3/1.
 */
public class UnionFindSet {
    private int[] parents;
    private int[] ranks;

    // Initialize parents root id
    // Initial ranks value
    public UnionFindSet(int size){
        parents = new int[size+1];
        ranks = new int[size+1];
        for(int i = 0 ; i < size ; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    /**
     * Merge two nodes into one tree.
     * @param u first node.
     * @param v second node.
     * @return
     * If two nodes have same root. Means they are in the same tree.
     * If not, merge them based on ranks
     */
    public boolean Union(int u , int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return false;
        if(ranks[pu] > ranks[pv]) parents[pu] = pv;
        else if(ranks[pu] < ranks[pv] ) parents[pv] = pu;
        else {
            parents[pv] = pu;
            // 如果rank 相同，需要更新ranks值
            ranks[pu] += 1;
        }
        return true;
    }

    public int find(int u){
        // find the root of this tree
        while (parents[u] != u){
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }
}
