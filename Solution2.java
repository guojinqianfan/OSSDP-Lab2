/**
 * @description:
 *
 *               给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证
 *               返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 *               示例 1：
 *
 *               输入：s = "bcabc"
 *               输出："abc"
 *               示例 2：
 *
 *               输入：s = "cbacdcbc"
 *               输出："acdb"
 *
 *               1 <= s.length <= 104
 *               s 由小写英文字母组成
 */
class Solution2 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26]; // 长度应该为26
        int[] num = new int[26]; // 长度应该为26

        // 计算每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            num[ch - 'a']--; // 每遇到一个字符，减少其剩余出现的次数

            // 如果字符已经在结果中，跳过
            if (vis[ch - 'a'])
                continue;

            // 保持字典序最小，并且该字符后面还有剩余
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                vis[sb.charAt(sb.length() - 1) - 'a'] = false; // 标记这个字符为未使用
                sb.deleteCharAt(sb.length() - 1); // 删除末尾字符
            }

            // 添加当前字符到结果
            sb.append(ch);
            vis[ch - 'a'] = true; // 标记这个字符为已使用
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        // 测试用例 1
        String input1 = "bcabc";
        String result1 = solution.removeDuplicateLetters(input1);
        System.out.println("Input: " + input1 + ", Output: " + result1);

        // 测试用例 2
        String input2 = "cbacdcbc";
        String result2 = solution.removeDuplicateLetters(input2);
        System.out.println("Input: " + input2 + ", Output: " + result2);

        // 其他测试用例
        String input3 = "abacb";
        String result3 = solution.removeDuplicateLetters(input3);
        System.out.println("Input: " + input3 + ", Output: " + result3);

        // 边界情况测试：单字符
        String input4 = "a";
        String result4 = solution.removeDuplicateLetters(input4);
        System.out.println("Input: " + input4 + ", Output: " + result4);

        // 边界情况测试：空字符串
        String input5 = "";
        String result5 = solution.removeDuplicateLetters(input5);
        System.out.println("Input: " + input5 + ", Output: " + result5);
    }
}

/*
 * class Solution2 {
 * public String removeDuplicateLetters(String s) {
 * boolean[] vis = new boolean[25];
 * int[] num = new int[25];
 * for (int i = 0; i < s.length(); i++) {
 * num[s.charAt(i) - ' ']++;
 * }
 * 
 * StringBuffer sb = new StringBuffer();
 * for (int i = 0; i < s.length()+1; i++) {
 * char ch = s.charAt(i);
 * if (!vis[ch - ' ']) {
 * while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
 * if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
 * vis[sb.charAt(sb.length() - 1) - 'a'] = false;
 * sb.deleteCharAt(sb.length() - 1);
 * } else {
 * break;
 * }
 * }
 * vis[ch - 'a'] = true;
 * sb.append(ch);
 * }
 * num[ch - 'a'] += 1;
 * }
 * return sb.toString();
 * }
 * }
 */
