package stack;

import java.util.Stack;

/**
 * 逆波兰式
 *题目描述
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * 例如：
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author by Sean
 * @date 2020/4/27 22:18
 */
public class EvalueReversePolishNotation {
    /**
     *
     * @return
     */
    public static int run(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.compareTo("+") == 0){
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2 + x1);
            }else if(s.compareTo("-") == 0) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2 - x1);
            }else if(s.compareTo("*") == 0) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2 * x1);
            }else if (s.compareTo("/") == 0){
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2 / x1);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] str = {"2", "1", "+", "3", "*"};
        String[] str2 = {"4", "13", "5", "/", "+"};
        System.out.println(run(str2));
    }
}
