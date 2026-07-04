package com.fay.others;

public class Solution4 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 第一步：从右向左找到第一个小于右侧相邻数字的数 nums[i]
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        // 如果找到了，进入第二步；否则跳过第二步，反转整个数组
        if (i >= 0) {
            // 第二步：从右向左找到 nums[i] 右边最小的大于 nums[i] 的数 nums[j]
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;
            // 交换
            swap(nums, i, j);
        }
        // 第三步：反转 [i+1, n-1]（如果上面跳过第二步，此时 i = -1）
        reverse(nums, i + 1, n - 1);
    }
    // 交换
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 翻转
    public void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
