import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leetcode496 {
    public static void main(String[] args) {
//        int[] num1 = {2, 4}; [1,3,5,2,4]
//[6,5,4,3,2,1,7]
//        int[] num2 = {1, 2, 3, 4};
        int[] num1 = {1,3,5,2,4};
        int[] num2 = {6,5,4,3,2,1,7};

        System.out.println(Arrays.toString(nextGreaterElement1(num1, num2)));
    }

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] num = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            num[i] = map.getOrDefault(nums1[i], -1);
        }
        return num;
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {

            nums[i] = nextGreaterElement(nums1[i], Arrays.copyOfRange(nums2, map.get(nums1[i]), nums2.length));
        }
        return nums;
    }

    public static int nextGreaterElement(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (k < nums[i]) return nums[i];
        }
        return -1;
    }

}
