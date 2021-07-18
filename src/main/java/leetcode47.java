import java.util.*;

public class leetcode47 {
    public static void main(String[] args) {
        int[] nums = {1};
        Arrays.sort(nums);
        System.out.println(permuteUnique(nums));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(nums, 0, nums.length, res);
        Set<List<Integer>> set = new HashSet<>(res);
        return new ArrayList<>(set);

    }

    public static void permuteUnique(int[] nums, int depth, int len, List<List<Integer>> res) {
        if (depth == len) {
            res.add(trans(nums));
            return;
        }
        for (int i = depth; i < nums.length; i++) {

            swap(nums, i, depth);
            permuteUnique(nums, depth + 1, len, res);
            swap(nums, i, depth);
        }

    }

    public static List<Integer> trans(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
