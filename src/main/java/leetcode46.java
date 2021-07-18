import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();


        dfs(nums, 0, nums.length, temp, res);

        return res;
    }

    public static void dfs(int[] nums, int start, int length, List<Integer> temp, List<List<Integer>> res) {
        if (start == length) {
            List<Integer> list = new ArrayList<>();

            for (int num : nums) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < length; i++) {
            swap(nums, i, start);
            dfs(nums, start + 1, length, temp, res);
            swap(nums, i, start);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
