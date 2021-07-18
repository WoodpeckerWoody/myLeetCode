import java.util.*;

public class Main {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
//        System.out.println(count(m,n,dp));
//        System.out.println(f(m,n));
        visited[2][2] = true;
        System.out.println(step(4,4,5,4));
    }


    // 深度优先 模板
    public static int col = 5;
    public static int row = 4;

    public static boolean[][] visited = new boolean[100][100];
    public static int step(int x, int y, int m, int n) {
        if (x== m && y ==n) {
            return 1;
        }
        if (x < 0 || y < 0 || x > col || y > row) {
            return 0;
        }
        if (visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        int sum = 0;
        // 右
        sum += step(x+1,y,m,n);
        // 下
        sum += step(x,y+1,m,n);

        // 左
        sum += step(x-1,y,m,n);

        // 上
        sum += step(x,y-1,m,n);

        visited[x][y] = false;
        return sum;
    }

    public static int f(int m, int n ) {
        if (m <0 || n<0){
            return 0;
        }
        if (m == 0 || n==0){
            return 1;
        }

        return f(m-1,n)+f(m,n-1);

    }

        public static int count(int m, int n, int[][] dp ) {
        if (m <0 || n<0){
            dp[m][n] = 0;
        }
        if (m == 0 || n==0){
            dp[m][n] = 1;
        }
//        if (m == 0 || n==0){
//            return 1;
//        }
            dp[0][0] = 1;

            for (int i = 0; i < m+1; i++) {
                for (int j = 0; j < n+1; j++) {
                    if (i == 0 || j==0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }

                }
            }
        return dp[m][n];
    }


    // 49. 字母异位词分组
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
            map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);

        }
        return new ArrayList<>(map.values());
    }




    public static String longestCommonPrefix(String[] strs) {
        int num = strs.length;

        if (num <= 1) return "";
        String cap = strs[0];
        System.out.println(cap);
        System.out.println(cap.startsWith(cap));
        for (String string : strs) {
            System.out.println(string + "ssss");

            while (!string.startsWith(cap)) {
                System.out.println(string);
                System.out.println("cap is " + cap);

                //公共前缀不匹配就让它变短！
                cap = cap.substring(0, cap.length() - 1);
            }
        }
        return cap;
    }




    // leetcode8  可以用正则   Character.isDigit() 判断是否用了数字
    public static int myAtoi(String s) {
        if (s.trim().length() == 0 || !String.valueOf(s.trim().charAt(0)).matches("[\\s\\+\\-0-9]")) {
            return 0;
        }
        if (s.trim().length() > 1 && !String.valueOf(s.trim().charAt(1)).matches("[\\.0-9]")) {
            return 0;
        }
        String res = s.replaceAll("[^0-9]", " ");
        String[] s1 = res.split(" ");
        String str = "";

        for (String num : s1) {
            if (!num.equals("")) {
                str = num;
                break;
            }
        }

        char c = str.charAt(0);
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                if (i == 0 || s.charAt(i - 1) == '+') {
                    flag = true;
                }
                if (i > 0 && (s.charAt(i - 1) == '-')) {
                    flag = false;
                }
            }
        }

        try {
            return flag ? Integer.parseInt(str) : -1 * Integer.parseInt(str);
        } catch (Exception e) {
            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }

    // leetcode5  可以用正则解决
    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        int start = 0;
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        start = l;
                        maxEnd = r;
                    }
                }
            }
        }

        return s.substring(start, maxEnd + 1);

    }
}
