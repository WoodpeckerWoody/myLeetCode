import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if (n <= 0) return res;
        dfs(0, n, 0, 0, temp, res);
        return res;
    }

    public static void dfs(int start, int n, int left, int right, List<String> temp, List<String> res) {
        if (left == n && right == n) {
            String join = String.join("", temp);
            res.add(join);
            return;
        }
        for (int i = start; i < 2 * n; i++) {
            if (left <= n && right <= n && left >= right) {
                temp.add("(");
                dfs(i + 1, n, left + 1, right, temp, res);
                temp.remove(temp.size() - 1);
                temp.add(")");
                dfs(i + 1, n, left, right + 1, temp, res);
                temp.remove(temp.size() - 1);
            }

        }

    }
}
