import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dfsLearn {
    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        System.out.println(subsets(nums));
        perm1(nums, 0, nums.length -1);
//        System.out.println(perm(nums,0,nums.length));
//        getRes(nums,0,new ArrayList<>());
//        System.out.println(res);
    }

    public static void perm1(int[] nums, int depth, int end) {
        if (depth == end) {
            System.out.println(Arrays.toString(nums));
        }
        for (int i = depth; i < nums.length; i++) {
            swap(nums,i,depth);
            perm1(nums,depth+1,end);
            swap(nums,i,depth);

        }
    }

    public static void getRes(int[] nums, int depth, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = depth; i < nums.length; i++) {
            temp.add(nums[i]);
            getRes(nums, i+1,temp);
            temp.remove(temp.size() -1);
        }
    }















    public static void perm(int[] nums, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(nums, i, start);
            perm(nums, start + 1, end);
            swap(nums, i, start);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        allSort(nums, 0, visited, nums.length);
        return new ArrayList<>();
    }

    public static void allSort(int[] nums, int depth, boolean[] visited, int len) {
        if (depth == len) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                allSort(nums, depth + 1, visited, len);
                visited[i] = false;
            }
        }
    }

}
