public class leetcode79 {

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
//        String word = "ABCB";


        System.out.println(exist(board, word));
    }
    public static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exist(board, word, i, j, 0, word.length(), visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word, int x, int y, int nowLen, int length, boolean[][] visited) {
        if (nowLen == length) {
            return true;
        }
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || visited[x][y] || board[x][y] != word.charAt(nowLen)) {
            return false;
        }
        visited[x][y] = true;


        for (int[] direction : directions) {
            if (exist(board, word, x + direction[0], y + direction[1], nowLen + 1, length, visited)) {
                return true;
            }
        }

        visited[x][y] = false;
        return false;
    }
}
