import java.util.ArrayList;
import java.util.List;
// 和78很像，好好看看
public class leetcode784 {
    public static void main(String[] args) {
        String s = "3z4";
        System.out.println(letterCasePermutation(s));


    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        if (s.length() <= 0) return res;
        for (int i = 0; i < s.length(); i++) {
            strList.add(String.valueOf(s.charAt(i)));
        }
        dfs(0, strList, res);

        return res;
    }

    public static void dfs(int start, List<String> strList, List<String> res) {
        res.add(String.join("", strList));
        for (int i = start; i < strList.size(); i++) {
            String code = strList.get(i);
            if (!code.matches("[0-9]+")) {
                trans(strList, i);
                dfs(i + 1, strList, res);
                trans(strList, i);
            }
        }
    }

    public static void trans(List<String> strList, int index) {
        String code = strList.get(index);
        if (code.toLowerCase().equals(code)) {
            strList.set(index, code.toUpperCase());
        } else {
            strList.set(index, code.toLowerCase());
        }
    }
}
