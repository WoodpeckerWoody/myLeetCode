import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode1942 {
    // leetcode.218、5806 1801题同样，双堆题目
    public static void main(String[] args) {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend = 1;
        System.out.println(smallestChair(times, targetFriend));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int res = 0;
        // 存储当前无人坐的椅子
        PriorityQueue<Integer> emptyChair = new PriorityQueue<>(10000);
        // 因为每个人到来的时间都不同，可以用时间来代指是谁，这样就不用纠结于人的序号问题了
        int arrive = times[targetFriend][0];
        // 存储[归还时间即离开时间，使用的椅子]，该队列表示现在已借出的椅子
        PriorityQueue<int[]> leaveTimeAndChair = new PriorityQueue<>((Comparator.comparingInt(o -> o[0])));
        emptyChair.add(0);
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));

        for (int[] time : times) {
            int arriveTime = time[0];
            int leaveTime = time[1];
            int seat;
            // 当 有人要借椅子的时候：如果 leaveTimeAndChair 为空，即当前没有椅子被借出，则取出第一个椅子；
            // 如果不为空，则看当前这个人是不是要走了，如果要走了，再把他的椅子拿出来加进空椅子队列
            if (leaveTimeAndChair.isEmpty()) {
                seat = emptyChair.poll();
            } else {
                // 当leaveTimeAndChair不空，且该朋友的离开时间小于目标人的到达时间时，把他的椅子加入空椅子队列
                while (!leaveTimeAndChair.isEmpty() && leaveTimeAndChair.peek()[0] <= arriveTime) {
                    emptyChair.add(leaveTimeAndChair.poll()[1]);
                }
                // 当前使用的椅子为最新的椅子
                seat = emptyChair.poll();
            }
            // 如果当前所有椅子都被占据。则最新的未使用的椅子为最新的使用的椅子序号+1
            if (emptyChair.isEmpty()) emptyChair.add(seat + 1);
            if (arrive == arriveTime) return seat;

            // 借出去之后，要放进已借出的队列
            leaveTimeAndChair.add(new int[]{leaveTime, seat});
        }
        return res;
    }
}
