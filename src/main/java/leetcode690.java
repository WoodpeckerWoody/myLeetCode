import scala.runtime.TraitSetter;

import java.util.*;

public class leetcode690 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 2;
        e1.subordinates = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        System.out.println(getImportance(employees,1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        int res = 0;
        Map<Integer,Employee> map = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        for (Employee employee : employees) {
            map.put(employee.id,employee);
        }
        queue.add(id);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            res = res + map.get(now).importance;
            queue.addAll(map.get(now).subordinates);
        }
        return res;
    }



}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}