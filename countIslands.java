import java.util.*;

public class countIslands {
    public static void main(String[] args) {
        countIslands main = new countIslands();
        char[][] grid = new char[][] {
                {
                        '1', '1', '1', '1', '0'
                },
                {
                        '1', '1', '0', '1', '0'
                },
                {
                        '1', '1', '0', '0', '0'
                },
                {
                        '0', '0', '0', '0', '0'
                }
        };
        int result = main.numIslands(grid);
        System.out.println(result);
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        Stack<StackObject> stack = new Stack<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    visited[i][j] = true;
                    stack.push(new StackObject(i, j));

                    while(!stack.isEmpty()) {
                        StackObject currentObject = stack.pop();
                        int curI = currentObject.i;
                        int curJ = currentObject.j;

                        if(!((curI+ 1) == grid.length) && !visited[curI+ 1][curJ] && grid[curI+1][curJ] == '1') {
                            visited[curI+ 1][curJ] = true;
                            stack.push(new StackObject(curI+ 1, curJ));
                        }

                        if(!((curJ+ 1) == grid[0].length) && !visited[curI][curJ + 1] && grid[curI][curJ + 1] == '1') {
                            visited[curI][curJ + 1] = true;
                            stack.push(new StackObject(curI, curJ + 1));
                        }

                        if(!(curJ == 0) && !visited[curI][curJ - 1] && grid[curI][curJ - 1] == '1') {
                            visited[curI][curJ - 1] = true;
                            stack.push(new StackObject(curI, curJ - 1));
                        }

                        if(!(curI == 0) && !visited[curI - 1][curJ] && grid[curI - 1][curJ] == '1') {
                            visited[curI - 1][curJ] = true;
                            stack.push(new StackObject(curI -1, curJ));
                        }

                    }
                }
            }
        }

        return result;
    }

    class StackObject {
        int i;
        int j;
        public StackObject(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}