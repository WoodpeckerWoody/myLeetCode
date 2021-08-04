import org.apache.maven.lifecycle.internal.LifecycleStarter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// 双指针，单调栈都行
public class leetcode581 {
    public static void main(String[] args) {
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int[] nums = {1,5,9,4,10};
//        int[] nums = {2,1};
        int[] nums = {1,2,3,5,4};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length <=1) return 0;

        int left = 0;
        int right = 0;

        int max = nums[0];
        int min = nums[nums.length -1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;

            }
        }
        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                left = i;

            }

        }
        return right==left ? 0: right-left+1;
    }

    public static int findUnsortedSubarray1(int[] nums) {
        //双指针: 需要分别确认左右边界:
        int left= 0, right = 0; //目标区域的左右边界

        int max = left;   //区域内的最大值的角标
        for(int i = 1; i<nums.length; i++){
            if(nums[i] >= nums[max]){
                max = i;
            }else {
                right = i;
                System.out.println("right is " + right);
            }
        }
        int min = right; //区域内的最小值的角标
        for(int i = right-1; i>=0;i--){
            if(nums[i] <= nums[min]){
                min = i;
            }else {
                left = i;
                System.out.println("left is " + left);
            }
        }


        return right==left ? 0: right-left+1;
    }

}
