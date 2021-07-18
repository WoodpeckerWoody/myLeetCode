import java.util.ArrayList;
import java.util.List;

public class leetcode77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 4;
        System.out.println(combine(n,k));
    }
    private static List<List<Integer>> res  = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        if (n<k || n<=0 || k<=0) return new ArrayList<>();
        combine(n,k,new ArrayList<>(),1);
        return res;
    }
    public static void combine(int n, int k, List<Integer> temp, int depth) {
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = depth; i <= n; i++) {
            temp.add(i);
            combine(n, k, temp,i+1);
            temp.remove(temp.size() - 1);
        }
    }

}
