import java.util.Arrays;

/**
 * @description:
 *
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 *
 */
class Solution4 {
    public int maximumGap(int[] nums) {
        int n = nums.length; // 获取数组长度
        if (n < 2) return 0; // 如果元素少于2个，返回0

        int maxVal = Arrays.stream(nums).max().getAsInt(); // 数组中的最大值
        int minVal = Arrays.stream(nums).min().getAsInt(); // 数组中的最小值

        if (maxVal == minVal) return 0; // 如果最大值和最小值相等，返回0

        // 计算桶的大小
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1; // 计算桶的数量
        int[] minBucket = new int[bucketCount]; // 存储每个桶的最小值
        int[] maxBucket = new int[bucketCount]; // 存储每个桶的最大值
        Arrays.fill(minBucket, Integer.MAX_VALUE); // 初始化为最大值
        Arrays.fill(maxBucket, Integer.MIN_VALUE); // 初始化为最小值

        // 将数组元素放入相应的桶中
        for (int num : nums) {
            int bucketIndex = (num - minVal) / bucketSize; // 计算桶索引
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], num); // 更新桶的最小值
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], num); // 更新桶的最大值
        }

        int maxGap = 0; // 初始化最大差值
        int previousMax = minVal; // 记录前一个桶的最大值

        // 计算相邻桶之间的最大差值
        for (int i = 0; i < bucketCount; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue; // 跳过空桶
            maxGap = Math.max(maxGap, minBucket[i] - previousMax); // 更新最大差值
            previousMax = maxBucket[i]; // 更新前一个桶的最大值
        }

        return maxGap; // 返回最大差值
    }
}