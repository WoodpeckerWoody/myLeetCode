import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode3 {
    public static void main(String[] args) {
//        "abcabcbb"; "bbbbb"
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        Map<Character, Integer> words = new HashMap<>();
        words.put(s.charAt(0), 0);
        int length = s.length();
        for (int i = 1; i < length; i++) {
            char ch = s.charAt(i);
            // 该字符上次出现的位置，dp[i-1]之间那个最小的值；
            // dp[i]表示以第i个字符为结尾时，最长不重复字串的长度
            dp[i] = Math.min(i - words.getOrDefault(ch, -1), dp[i - 1] + 1);

            words.put(ch, i);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
