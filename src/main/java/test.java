import java.util.*;

public class test {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int n = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = n;
                n++;
            }
        }
//        int m = matrix.length;
//        int x = matrix[0].length;
//        System.out.println(m);
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(matrix[i][j]);
//            }
//        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(list.size() -1);
        System.out.println(list);
        System.out.println((int)Math.pow(9,10));

    }

    class Solution {
        public String decodeString(String s) {

            Stack<String> stack= new Stack<>();
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i)==']') {
                    String string="";
                    while(!stack.peek().equals("[")) {
                        string=stack.pop()+string;
                    }
                    stack.pop();

                    String countString="";
                    while((!stack.isEmpty())&&(stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9')) {
                        countString=stack.pop()+countString;
                    }
                    int count=Integer.parseInt(countString);

                    String retString="";
                    for(int j=0;j<count;j++) {
                        retString=retString+string;
                    }
                    stack.push(retString);
                }
                else {
                    String str=""+s.charAt(i);
                    stack.push(str);
                }
            }

            String aaa="";
            while(!stack.isEmpty()) {
                aaa=stack.pop()+aaa;
            }
            return aaa;
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            if (up>down) break;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right<left) break;
            for (int i = right; i >=left; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            if (down<up) break;
            for (int i = down; i >=up; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left>right) break;
        }
        return res;
    }

    // 不知道为什么等于map.size==cap时就是最后一个LinkedHashMap
//    Map<Integer, Integer> map = new LinkedHashMap<>();
//
//        map.put(1,1);
//        map.put(2,2);
//        map.put(3,3);
//        map.put(4,4);
//        System.out.println(map);
//    int capacity = 4;
//        if (map.size() == capacity) {
//        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        System.out.println(iterator);
//        iterator.next();
//        iterator.remove();
//    }
//        System.out.println(map);

    class WordDictionary {

        List<String> wordDictionary = new ArrayList<>();
        /** Initialize your data structure here. */
        public WordDictionary() {
            WordDictionary wordDictionary;
        }

        public void addWord(String word) {
            wordDictionary.add(word);
        }

        public boolean search(String word) {
            for (String str : wordDictionary) {
                if (str.matches(word)) {
                    return true;
                }
            }

           return false;
        }
    }

}
