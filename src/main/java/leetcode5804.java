import java.util.HashSet;
import java.util.Set;

public class leetcode5804 {
    public static void main(String[] args) {
        System.out.println(solution("abcabd"));
    }

    public static boolean solution(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res[ch - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int re : res) {
            if (re != 0) {
                set.add(re);
            }
        }
        return set.size() == 1;
    }
}
