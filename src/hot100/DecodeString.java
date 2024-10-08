package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class DecodeString {

    public String decodeString(String s) {
        Deque<String> strQueue = new ArrayDeque<>();
        Deque<Integer> countQueue = new ArrayDeque<>();
        String curStr = "";
        int repCount = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                repCount = repCount * 10 + (ch - '0');
            } else if (ch == '[') {
                strQueue.push(curStr);
                countQueue.push(repCount);
                curStr = "";
                repCount = 0;
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder(strQueue.pop());
                int count = countQueue.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(curStr);
                }
                curStr = sb.toString();
            } else {
                curStr += ch;
            }
        }
        return curStr;
    }
}
