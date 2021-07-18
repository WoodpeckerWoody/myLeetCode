import java.util.ArrayList;
import java.util.List;


/*
解题思路
        用 DFSDFS 的回溯法求解从树的根节点 [][] 开始按照深度逐个遍历

        回溯法算实际上就是一个决策树（因为在每个节点上都要做决策）的遍历过程：

        路径：也就是已经做出的选择。
        选择列表：也就是当前可以做的选择。
        结束条件：也就是到达决策树底层(选择列表为空的时候)，无法再做出选择的条件。
        当为 <组合，子集> 问题，即 [a, b][a,b] 和 [b, a][b,a] 等价的时候，用 startstart 变量来标识当前选择列表的起始位置（为了保证在选择组合的时候，同一条路径下已经选择的元素不会再重复选择，排除已经选过的元素）；当为 <排列> 问题，即 [a, b][a,b] 与 [b, a][b,a] 不等价的时候，用 visited[]visited[] 数组。

        特殊情况：若字符串 ss 的长度大于 1212 或者小于 44 时，不满足 IPIP 地址的条件，此时直接返回空结果集 resres。


        if (n > 12 || n < 4) return res;
        定义一个长度为 44 的队列（最多只能存放 44 个元素），因为一个有效的 IPIP 地址为 44 段。

        剪枝
        当在进行递归操作时，每次从起点 startstart 开始向后遍历 33 个字符：

        若当前遍历的字符下标比字符串 ss 的长度大了，则说明该位置并没有字符（已经超出了字符串 ss 的长度），此时直接退出循环；

        if (i >= n) break;
        若当前剩余未分割的段数 * 3∗3（一段最多为 33 个字符，即为当前 IPIP 地址中最多还能存放的字符数量） << 当前字符串 ss 中剩余的字符数量，若将从此时起点 startstart 到当前位置 ii 的子字符串作为 IPIP 地址中的一段的话，最后一定会有剩余的字符，所以此时不进行任何操作，直接跳过当前位置字符，进行下一个字符的遍历；

        if (residue * 3 < n - i) continue;
        若上述两个判断均通过了，说明从此次递归中起点 startstart 位置到当前位置 ii 所构成的子字符串可能能够作为 IPIP 地址中的一段（还需要检查当前 [start, i][start,i] 位置上的子字符串所构成的整数所在的范围）；
        调用 isIpSegment()isIpSegment() 方法：

        若当前子字符串的长度大于 11 并且是以 " 00 " 开头的，此时得到的 IPIP 段一定是不符合要求的（每个整数位于 00 到 255255 之间组成，且不能含有前导 00）直接返回 falsefalse；
        若当前子字符串没有前导 00，则将当前 [start, i][start,i] 位置上的子字符串转换成整数 resres，然后判断 resres 的范围必须在 [0, 255][0,255] 之间；

private boolean isIpSegment(String s, int left, int right) {

        if (right - left + 1 > 1 && s.charAt(left) == '0') return false;

        int res = 0;
        for (int i=left;i<=right;i++) res = res * 10 + s.charAt(i) - '0';

        return res >= 0 && res <= 255;
        }
        若上述 isIpSegment()isIpSegment() 方法返回 truetrue，说明当前 [start, i][start,i] 位置上的子字符串能够成为 IPIP 地址中的一段。
        先将利用 substring()substring() 方法将子字符串截取出来（截取子字符串的范围有讲究），然后添加到队列 pathpath 中，作为 IPIP 地址中的一段。
        然后继续调用 backtrack()backtrack() 方法进行递归操作（下次递归的起点为上述子字符串结尾 ii 的下一个位置，即 start == i + 1start==i+1 防止重复遍历字符，每次都是没有遍历过的字符）。

        if (isIpSegment(s, start, i)) {

        String currentIpSegment = s.substring(start, i + 1);

        path.addLast(currentIpSegment);
        backtrack(s, i + 1, residue - 1, path);
        path.removeLast();
        }
        当在 "做选择" 时，就是从 "选择列表" 中拿出一个 "选择"，并将它放入到 "路径" 中。

        结束条件：若当前遍历的起点 startstart 与字符串 ss 的长度相同并且 IPIP 地址剩余未分割的段数 residueresidue 为 00，此时将队列 pathpath 中已经分割好的 44 段 IPIP 通过 String.join()String.join() 方法形成一个字符串并用 " .. " 分割，将该字符串加入到结果集 resres 中。


        if (start == n && residue == 0) {

        res.add(String.join(".", path));
        return ;
        }
        然后回溯到上一层并将 pathpath 中最近添加进去的一段删除（回溯到上一层后，继续遍历选择列表，选择下一个分支）（"撤销选择"：就是从 "路径" 中拿出一个选择，将它恢复到 "选择列表" 中）即可。

        注意：publicpublic StringString substringsubstring(int(int beginIndexbeginIndex,, intint endIndex)endIndex)
        这个方法截取的字符串从 beginIndexbeginIndex 开始，到字符串索引的 endIndex - 1endIndex−1 结束，即截取的字符串不包括 endIndexendIndex 这个索引对应的字符。*/

public class leetcode93 {
    public static void main(String[] args) {
        String s = "101023";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        List<String> temp = new ArrayList<>();
        restoreIpAddresses(s, 0, s.length(), 4, res, temp);
        return res;
    }

    public static void restoreIpAddresses(String str, int start, int length, int remain, List<String> res, List<String> temp) {
        if (start == length) {
            if (remain == 0)
                res.add(String.join(".", temp));
            return;
        }
        for (int i = start; i < start + 3; i++) {
            if (i >= length) break;
            if (length - i > remain * 3) continue;
            if (isValid(str, start, i)) {
                String curIp = str.substring(start, i + 1);
                temp.add(curIp);
                restoreIpAddresses(str, i + 1, length, remain - 1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isValid(String ip, int left, int end) {
        int len = end - left + 1;
        if (len > 1 && ip.charAt(left) == '0') {
            return false;
        }
        String cur = ip.substring(left, end + 1);
        return Integer.parseInt(cur) >= 0 && Integer.parseInt(cur) <= 255;
    }
}

