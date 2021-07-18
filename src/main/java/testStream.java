import java.util.*;
import java.util.stream.Collectors;

public class testStream {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("111");
//        list.add("111");
//        list.add("22");
//        list.add("22");
//        list.add("333");
//        list.add("333");
//        list.add("333");
//        list.add("333");
//        list.add("44");
//        list.add("4");
//        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::new));
//        String collect1 = collect.entrySet().stream().sorted(Comparator.comparing(entry -> entry.getValue().size(), Comparator.reverseOrder())).limit(3).map(Map.Entry::getKey).collect(Collectors.joining(""));
//        System.out.println(collect1);



        HashMap<String, Integer> wordMap = new HashMap<>() {{
            //value为key的长度
            put("这是苹果园", 5);
            put("这是苹果", 4);
            put("她上街买了一个苹果", 9);
            put("他吃了一个苹果", 7);
            put("苹果", 2);
        }};
        sortMap(wordMap);
        System.out.println(wordMap);







    }
    public static void sortMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));
    }


}
