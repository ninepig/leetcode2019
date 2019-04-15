package amazon;

/**
 * Created by yangw on 2019/4/13.
 */
public class findCelebreties {
    public int findCelebrity(int n) {
        if (n==0){
            return -1;
        }
        int candidate = 0;
        //find the only candidate.,lable from 0--n-1;
        for(int i = 1;i<n;i++){
            //if candidate konow i ,set i to candidate
            if(knows(candidate,i)){
                i =candidate;
            }
        }

        for(int i = 0;i<n;i++){
            //if candidate know anyone or anyone don't know candidate
            if(candidate!=i&&(knows(candidate,i))||!knows(i,candidate)){
                return -1;
            }
        }
        return candidate;
    }

    boolean knows(int a, int b){
        return false;
    }
}
