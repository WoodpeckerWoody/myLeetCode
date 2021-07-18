import java.util.Arrays;

public class leetcode455 {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
//        int[] g = {1,2,3};
//        int[] s = {1,1};

        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        if (s.length == 0 || s[s.length - 1] < g[0]) return 0;
        int cookieNum = 0;
        for (int i = 0; i < g.length && cookieNum < s.length; i++) {
//            System.out.println("cookieNum1 = "+cookieNum);
            while (cookieNum < s.length && s[cookieNum] < g[i]) {
                cookieNum++;
            }
//            System.out.println("cookieNum2 = "+cookieNum);

            if (cookieNum < s.length && s[cookieNum] >= g[i]) {
//                System.out.println("g ="+g[i]);
//                System.out.println("s ="+s[cookieNum]);
                cookieNum++;

                res++;
            }
        }
        return res;
    }
}
