import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 测试类：SolutionTest
 *
 * 测试用例设计原则：
 * 1. 等价类划分：
 *    有效输入：数组元素数量大于或等于2的情况。
 *    无效输入：数组元素数量小于2的情况（返回0）。
 * 2. 边界值分析：
 *    数组长度为2。
 *    数组元素为最小值和最大值。
 * 3. 状态转换：
 *    验证相邻元素的最大差值计算是否正确。
 * 4. 性能测试：
 *    测试大规模输入（如100,000个元素）。
 * 5. 异常处理：
 *    测试空数组或不合法输入的处理。
 */
public class L2022211835_4_Test {

    private final Solution4 solution = new Solution4();

    /**
     * 测试目的：验证正常情况下相邻元素的最大差值。
     * 测试用例：{3, 6, 9, 1}
     */
    @Test
    public void testMaximumGap_NormalCase() {
        int[] nums = {3, 6, 9, 1};
        assertEquals(3, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证只有一个元素的情况。
     * 测试用例：{10}
     */
    @Test
    public void testMaximumGap_SingleElement() {
        int[] nums = {10};
        assertEquals(0, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证包含最小值和最大值的情况。
     * 测试用例：{1, 1000000}
     */
    @Test
    public void testMaximumGap_MinMaxValues() {
        int[] nums = {1, 1000000};
        assertEquals(999999, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证所有元素相同的情况。
     * 测试用例：{1, 1, 1, 1}
     */
    @Test
    public void testMaximumGap_AllSame() {
        int[] nums = {1, 1, 1, 1};
        assertEquals(0, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证相邻元素差值为1的情况。
     * 测试用例：{1, 2, 3, 4, 5}
     */
    @Test
    public void testMaximumGap_Sequential() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(1, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证相邻元素差值为2的情况。
     * 测试用例：{1, 3, 5, 7, 9}
     */
    @Test
    public void testMaximumGap_EqualIntervals() {
        int[] nums = {1, 3, 5, 7, 9};
        assertEquals(2, solution.maximumGap(nums));
    }

    /**
     * 测试目的：验证多个不同元素的情况。
     * 测试用例：{3, 5, 1, 8, 10}
     */
    @Test
    public void testMaximumGap_DiverseElements() {
        int[] nums = {3, 5, 1, 8, 10};
        assertEquals(3, solution.maximumGap(nums));
    }
}
