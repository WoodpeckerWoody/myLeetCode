public class leetcode130 {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
//        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};

        solve(board);
        for (char[] chars : board) {
            System.out.println(chars);

        }
    }

    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if (col <= 0) return;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && isInEdge(i, j, row, col)) {
                    dfs(i, j, row, col, board, visited);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // 任何边界上的 'O' 都不会被填充为 'X'；任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
    public static void dfs(int x, int y, int row, int col, char[][] board, boolean[][] visited) {
        visited[x][y] = true;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (isInArea(newX, newY, row, col) && board[newX][newY] == 'O' && !visited[newX][newY]) {
                dfs(newX, newY, row, col, board, visited);
            }
        }
    }

    public static boolean isInArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    public static boolean isInEdge(int x, int y, int row, int col) {
        return x == 0 || x == row - 1 || y == 0 || y == col - 1;
    }
}
