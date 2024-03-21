import java.util.LinkedList;
import java.util.Queue;

class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> bfsQueue = new LinkedList<>();

        //Initialize stack, set water.
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    bfsQueue.add(new int[]{i, j, 0});
                }
            }
        }

        while(!bfsQueue.isEmpty()) {
            int[] curMember = bfsQueue.poll();

            if(res[curMember[0]][curMember[1]] == 0) {
                res[curMember[0]][curMember[1]] = curMember[2];

                for(int i = 0; i < dir.length; i++) {
                    int x = curMember[0] + dir[i][0];
                    int y = curMember[1] + dir[i][1];

                    if(x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) {
                        bfsQueue.add(new int[]{x, y, curMember[2] + 1});
                    }
                }
            }
        }

        return res;
    }
}