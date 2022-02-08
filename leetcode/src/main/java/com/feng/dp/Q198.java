package com.feng.dp;

import java.util.Arrays;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class Q198 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1, 3};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
        System.out.println(max(nums, nums.length - 1));
    }

    public static int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static int rob2(int[] nums) {
        int[] total = new int[nums.length + 1];
        total[0] = 0;
        total[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int max = Math.max(total[i - 1], total[i - 2] + nums[i - 1]);
            total[i] = max;
        }
        return total[nums.length];
    }

    public static int max(int[] nums, int index) {
        if (index == 0) {
            return nums[0];
        }
        if (index < 0) {
            return 0;
        }
        return Math.max(max(nums, index - 1), max(nums, index - 2) + nums[index]);
    }
}
