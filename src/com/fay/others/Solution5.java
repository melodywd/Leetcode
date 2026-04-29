package com.fay.others;

public class Solution5 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            // 快慢指针
            slow = nums[slow]; // 等价于 slow = slow.next
            fast = nums[nums[fast]]; // 等价于 fast = fast.next.next
            // 快慢指针移动到同一个节点
            if (slow == fast) break;
        }
        // 再用一个指针，从起点出发
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        // 入环口即重复元素
        return slow;
    }
}
