import java.util.*;

public class leetcode90 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsWithDup(nums, 0, temp, res);
        Set<List<Integer>> set = new HashSet<>(res);
        List<List<Integer>> res1 = new ArrayList<>(set);
        return res1;
    }

    public static void subsetsWithDup(int[] nums, int depth, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = depth; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsWithDup(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }

    }
}
