package 面试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ms0807new {
    public static void main(String[] args) {
        String S = "qwe";
        System.out.println(Arrays.toString(permutation(S)));
    }

    public static List<String> res = new ArrayList<>();

    public static String[] permutation(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        permutation(chars, new ArrayList<>(), 0,visited);
        String[] strs = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            strs[i] = res.get(i);
        }
        return strs;
    }

    public static void permutation(char[] chars, List<Character> temp, int depth,boolean[] visited) {
        if (depth == chars.length) {
            res.add(trans(temp));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            temp.add(chars[i]);
            visited[i] = true;
            permutation(chars, temp, depth + 1, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    public static String trans(List<Character> temp) {
        StringBuilder sb = new StringBuilder();
        for (Character character : temp) {
            sb.append(character);
        }
        return sb.toString();
    }

}
