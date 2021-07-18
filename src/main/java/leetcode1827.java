import java.util.Arrays;

public class leetcode1827 {
    public static void main(String[] args) {
        int[] nums = {8};
        System.out.println(minOperations(nums));

    }

    public static int minOperations(int[] nums) {
        int res = 0;
        if (nums.length <= 1) return res;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i - 1]) {
                nums[i]++;
                res++;
            }
        }
        return res;
    }

}
