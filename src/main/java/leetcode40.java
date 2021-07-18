import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {
    public static void main(String[] args) {
        int[] candidates = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target = 27;
        System.out.println(combinationSum2(candidates, target));

    }

    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        combinationSum2(candidates,target,0,temp,visited);
        return res;

    }

    public static void combinationSum2(int[] candidates, int target, int depth, List<Integer> temp,boolean[] visited) {


        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = depth; i < candidates.length; i++) {
            // 这个大剪枝需要注意，非常提升效率
            if (target - candidates[i] < 0) {
                break;
            }
            if (visited[i]) continue;
            if (i>0 && (!visited[i-1]) && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            visited[i]= true;
            combinationSum2(candidates,target - candidates[i],i+1,temp,visited);
            visited[i]= false;
            temp.remove(temp.size()-1);
        }
    }
}
