import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        if (grid.length <= 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(grid[0][0]);
        HashSet<Integer> visited = new HashSet<>();
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                for (int j = 1; j * j <= cur; j++) {
                    int next = cur - j * j;
                    if (next == 0) return res;
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

        }
        return -1;
    }

    public static void bfs(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();

    }
}
