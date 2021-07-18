public class eightQueen {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] s =  {{'0','1'},{'1','0'}};
        char[][] s1 =  {{'0'}};

        System.out.println(maximalSquare(s1));
    }

    public static int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int ch = matrix[i][j] - '0';
                if (i == 0 || j == 0) {
                    dp[i][j] = ch;
                } else {
                    if (ch == 0) {
                        dp[i][j] = 0;
                    } else {
                        int tempMin = Math.min(dp[i][j - 1], dp[i - 1][j]);
                        dp[i][j] = Math.min(tempMin, dp[i - 1][j - 1]) + 1;
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }


}
