public class leetcode981 {
    public static void main(String[] args) {
        int x = 3;
        int y = 10;
        System.out.println(brokenCalc(x, y));
    }

/*
    当Y = X时，返回00
    当Y < X时，返回 X-Y
    当Y > X 且 YY为奇数时，我们可以得到当前最优序列中倒数第二个数为Y+1，递归求解到Y+1的最小操作次数。
    当Y > X 且 YY为偶数时, 我们可以得到当前最优序列中倒数第二个数为Y/2，递归求解到Y/2的最小操作次数。
*/

    public static int brokenCalc(int X, int Y) {
        // X>Y 只能用减法，因此是X-Y
        if (X >= Y) {
            return X - Y;
        } else if (Y % 2 == 0) {
            return 1 + brokenCalc(X, Y / 2);
        } else {
            return 1 + brokenCalc(X, Y + 1);
        }
    }
}
