import java.util.*;
import java.util.stream.Collectors;

public class leetcode17 {
    public static void main(String[] args) {
        String digits = "";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() <= 0) return res;
        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(0, digits.toCharArray(), new ArrayList<>(), map, res);
        return res;
    }

    public static void dfs(int start, char[] digitChars, List<Character> temp, Map<Character, String> map, List<String> res) {
        if (start == digitChars.length) {
            res.add(Arrays.stream(temp.toArray()).map(String::valueOf).collect(Collectors.joining("")));
            return;
        }
        String str = map.get(digitChars[start]);
        for (int i = 0; i < str.length(); i++) {
            temp.add(str.charAt(i));
            dfs(start + 1, digitChars, temp, map, res);
            temp.remove(temp.size() - 1);
        }
    }
}
