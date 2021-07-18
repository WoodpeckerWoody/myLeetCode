import scala.Int;

import java.util.*;

public class leetcode967 {
    public static void main(String[] args) {
        int n = 2;
        int k = 0;
        System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> list = new HashSet<>();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Deque<Integer> que = new LinkedList<>(nums);
        while (!que.isEmpty()) {
            int res = que.pollFirst();
            if (String.valueOf(res).length() == n) {
                list.add(res);
                continue;
            }
            // 如果当前位置-k大于等于0，加入
            if (res % 10 - k >= 0) {
                que.add(10 * res + res % 10 - k);
            }
            // 如果当前位置+k小于等于9，加入
            if ( res % 10 + k <= 9) {
                que.add(10 * res + res % 10 + k);
            }
        }

        int[] ans = new int[list.size()];
        List<Integer> list1 = new ArrayList<>(list);
        for (int i = 0; i < list1.size(); i++) {
            ans[i] = list1.get(i);
        }
        return ans;
    }
}
