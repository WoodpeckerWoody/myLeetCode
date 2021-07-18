//import org.apache.commons.collections.map.LinkedMap;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class LRUCache {
//
//    private int capacity;
//    private Map<Integer, Integer> map = new LinkedHashMap<>();
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public static int get(int key) {
//        int val = map.computeIfAbsent(key, -1);
//        map.remove(val);
//        map.put(key,val);
//        return val;
//    }
//
//    public static void put(int key, int value) {
//        if (map.containsKey(key)) {
//            map.remove(key);
//        } else if (map.size() == capacity) {
//            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//            iterator.next();
//            iterator.remove();
//        }
//
//        map.put(key,value);
//    }
//
//}
