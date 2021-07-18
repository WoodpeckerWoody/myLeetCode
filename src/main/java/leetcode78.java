import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode78 {
    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Arrays.sort(nums);
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        getRes(nums, 0, new ArrayList<>(), res);

        return res;
    }

    public static void getRes(int[] nums, int depth, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = depth; i < nums.length; i++) {
            temp.add(nums[i]);
            getRes(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
    private static void backtrack(int depth, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = depth; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


}
