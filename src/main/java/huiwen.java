public class huiwen {
    public static void main(String[] args) {
        String str = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"
                ;
        System.out.println(longestPalindromeSubseq((str)));
    }

    public static int longestPalindromeSubseq(String s) {
        int res = 0;
        if (s.length() <= 1) return s.length();
        int len = s.length();
        int[][] length = new int[len][len];
            for (int left = len -1; left >= 0; left--) {
                for (int right = left; right <len; right++) {
                    if (left == right) {
                    length[left][right] = 1;
                } else {
                    if (s.charAt(right) == s.charAt(left)) {
                        length[left][right] = length[left+ 1][right- 1] + 2;
                        if (length[left][right] > res) {
                            res = length[left][right];
                        }
                    } else {
                        length[left][right] = Math.max(length[left + 1][right], length[left][right-1]);
                        if (length[left][right] > res) {
                            res = length[left][right] ;
                        }
                    }
                }

            }
        }
        return res;
    }
}
