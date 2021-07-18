import java.util.LinkedList;
import java.util.Queue;

public class leetcode1091 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int preLength = grid[now[0]][now[1]];
            for (int i = 0; i < 8; i++) {
                int newX = now[0] + directions[i][0];
                int newY = now[1] + directions[i][1];
                if (isInSqure(newX, newY, n) && grid[newX][newY] == 0  ) {
                    grid[newX][newY] = preLength + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return grid[n - 1][n - 1] == 0 ? -1 : grid[n - 1][n - 1]; // 如果最后终点的值还是0，说明没有到达
    }
    private static boolean isInSqure(int x, int y, int len) {
        return (x>=0 && y>=0 && x <len && y<len);
    }
}
