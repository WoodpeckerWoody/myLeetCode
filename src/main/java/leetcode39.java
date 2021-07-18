import java.util.*;

public class leetcode39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        Stack<Integer> temp = new Stack<>();
        combinationSum(candidates, 0, target, temp, res);
        return res;
    }

    public static void combinationSum(int[] candidates, int depth, int target, Stack<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = depth; i < candidates.length; i++) {
            System.out.println("depth =" + depth );
            if (candidates[i] <= target) {
                temp.push(candidates[i]);
                // 这里是i，则允许有重复元素；换成i+1就不允许有重复元素
                combinationSum(candidates, i, target - candidates[i], temp, res);
                temp.pop();
            }
        }
    }
}
