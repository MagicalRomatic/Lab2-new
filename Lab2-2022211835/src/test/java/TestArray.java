import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestArray {
    private final Solution4 solution = new Solution4();

    @Test
    public void testMaximumGap() {
        // 测试用例1
        int[] nums1 = {3, 6, 9, 1};
        assertEquals(3, solution.maximumGap(nums1));

        // 测试用例2
        int[] nums2 = {10};
        assertEquals(0, solution.maximumGap(nums2));

        // 测试用例3
        int[] nums3 = {1, 1000000};
        assertEquals(999999, solution.maximumGap(nums3));

        // 测试用例4
        int[] nums4 = {1, 2, 3, 4, 5};
        assertEquals(1, solution.maximumGap(nums4));

        // 测试用例5
        int[] nums5 = {1, 3, 5, 7, 9};
        assertEquals(2, solution.maximumGap(nums5));

        // 测试用例6
        int[] nums6 = {1, 1, 1, 1};
        assertEquals(0, solution.maximumGap(nums6));

        // 测试用例7
        int[] nums7 = {3, 5, 1, 8, 10};
        assertEquals(3, solution.maximumGap(nums7));
    }
}


