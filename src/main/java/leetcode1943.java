import java.util.*;
import java.util.stream.Collectors;

// 差分数组，前缀和，还需要继续研究
public class leetcode1943 {
    public static void main(String[] args) {
        int[][] segments = {{4, 16, 12}, {9, 10, 15}, {18, 19, 13}, {3, 13, 20}, {12, 16, 3}, {2, 10, 10}, {3, 11, 4}, {13, 16, 6}};
        System.out.println(splitPainting(segments));
    }


    public static List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> res = new ArrayList<>();
        List<int[]> sortedSegments = Arrays.stream(segments)
                .sorted(Comparator.comparingInt(o -> o[0]))
                .collect(Collectors.toList());

        Map<Long, Long> map = new HashMap<>();
        for (int[] sortedSegment : sortedSegments) {
            map.put((long) sortedSegment[0], map.getOrDefault((long) sortedSegment[0], 0L) + (long) sortedSegment[2]);
            map.put((long) sortedSegment[1], map.getOrDefault((long) sortedSegment[1], 0L) - (long) sortedSegment[2]);
        }
        LinkedHashMap<Long, Long> collect = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldVal, newVal) -> oldVal,
                LinkedHashMap::new
        ));
        long sum = 0;
        long start = 0;
        for (Map.Entry<Long, Long> entry : collect.entrySet()) {
            Long pos = entry.getKey();
            Long value = entry.getValue();
            if (sum != 0) {
                res.add(Arrays.asList(start, pos, sum));
            }
            start = pos;
            sum = sum + value;
        }
        return res;
    }
}
