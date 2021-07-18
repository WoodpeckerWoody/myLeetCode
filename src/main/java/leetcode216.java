import java.util.ArrayList;
import java.util.List;

public class leetcode216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(1, 1));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n<k) return res;
        List<Integer> temp = new ArrayList<>();
        dfs(k, n, 1, temp, res);

        return res;

    }

    public static void dfs(int k, int n, int start, List<Integer> temp, List<List<Integer>> res) {
        if (temp.stream().mapToInt(num -> num).sum() == n && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < 10; i++) {
            if (i > n) break;
            if (n - i < 0 || temp.size() > k) break;
            temp.add(i);
            dfs(k, n, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
