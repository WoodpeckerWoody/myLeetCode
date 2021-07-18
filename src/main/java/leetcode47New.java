import java.util.*;

public class leetcode47New {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    // https://leetcode-cn.com/problems/permutations-ii/solution/shou-hua-tu-jie-li-yong-yue-shu-tiao-jian-chong-fe/

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(nums, 0, new ArrayList<>(), res, visited);
        return res;
    }

    public static void permuteUnique(int[] nums, int depth, List<Integer> temp, List<List<Integer>> res, boolean[] visited) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;                 // 使用一个 used 数组记录使用过的数字，使用过了就不再使用
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                //当前的选项nums[i]，与同一层的前一个选项nums[i-1]相同，且nums[i-1]存在，且没有被使用过，则忽略选项nums[i]
                // 原因：当前nums[i]以及后续的场景，和nums[i-1]是一致的，因此按顺序执行的话，nums[i-1]绝对就会把我们想要的结果算出来，因此nums[i]没必要再做。
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            permuteUnique(nums, depth + 1, temp, res, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
