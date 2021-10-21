 
 
//  QUESTION
// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
// A province is a group of directly or indirectly connected cities and no other cities outside of the group.
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
// Return the total number of provinces.



//FUNCTION IMPLEMENTATION

class Solution {
    public int findCircleNum(int[][] M) { //<-entry
        
        int[] unionFindSet = new int[M.length];
        for (int i = 0; i< unionFindSet.length; i++){
            unionFindSet[i] = -1;
        }
        
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union(unionFindSet, i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i< unionFindSet.length; i++){
            if (unionFindSet[i] < 0) count++;
        }
        return count;
       
    }
    
    
   public static int findRoot(int[] unionSet, int v) {
        int index = v;
        int value = unionSet[v];
        while (value > 0) {
            index = value;
            value = unionSet[value];
        }

        return index;
    }

    public static void union(int[] unionSet, int first, int second) {
        int x = findRoot(unionSet, first);
        int y = findRoot(unionSet, second);

        if(x == y) {
            return;
        }
        if (Math.abs(unionSet[x]) <= Math.abs(unionSet[y])) {
            unionSet[y] -= Math.abs(unionSet[x]);
            unionSet[x] = y;
            while ( first != y) {
                 int parent = unionSet[first];
                 unionSet[first] = y;
                 first = parent;
            }
        } else {
            unionSet[x] -= Math.abs(unionSet[y]);
            unionSet[y] = x;
            while ( second != x) {
                 int parent = unionSet[second];
                 unionSet[second] = x;
                 second = parent;
            }
        }
    }

}