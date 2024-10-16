import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Solution2Test {

    @Test
    void testRemoveDuplicateLetters() {
        Solution2 solution = new Solution2();

        // 示例 1：测试输入 "bcabc"
        String input1 = "bcabc";
        String expected1 = "abc";
        String result1 = solution.removeDuplicateLetters(input1);
        assertEquals(expected1, result1, "Test case 1 failed");

        // 示例 2：测试输入 "cbacdcbc"
        String input2 = "cbacdcbc";
        String expected2 = "acdb";
        String result2 = solution.removeDuplicateLetters(input2);
        assertEquals(expected2, result2, "Test case 2 failed");

        // 边界条件测试：只有一个字符
        String input3 = "a";
        String expected3 = "a";
        String result3 = solution.removeDuplicateLetters(input3);
        assertEquals(expected3, result3, "Test case 3 failed");

        // 边界条件测试：所有字符相同
        String input4 = "aaaaa";
        String expected4 = "a";
        String result4 = solution.removeDuplicateLetters(input4);
        assertEquals(expected4, result4, "Test case 4 failed");

        // 边界条件测试：空字符串
        String input5 = "";
        String expected5 = "";
        String result5 = solution.removeDuplicateLetters(input5);
        assertEquals(expected5, result5, "Test case 5 failed");

        // 边界条件测试：无重复字母
        String input6 = "abcdefg";
        String expected6 = "abcdefg";
        String result6 = solution.removeDuplicateLetters(input6);
        assertEquals(expected6, result6, "Test case 6 failed");
    }
}
