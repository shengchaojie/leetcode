package com.scj.leetcode;

import java.util.Stack;

/**
 * 1. 使用switch
 * 2. stack使用integer类型 而不是每一部操作的时候再转换
 * 有个解法 用数组模拟栈 吊的不行
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _150_逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer secnod,first;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                     secnod = stack.pop();
                     first = stack.pop();
                    stack.push(first + secnod );
                    break;
                case "-":
                    secnod = stack.pop();
                    first = stack.pop();
                    stack.push(first - secnod );
                    break;
                case "*":
                    secnod = stack.pop();
                    first = stack.pop();
                    stack.push(first * secnod );
                    break;
                case "/":
                    secnod = stack.pop();
                    first = stack.pop();
                    stack.push(first / secnod );
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        _150_逆波兰表达式求值 _this = new _150_逆波兰表达式求值();
        System.out.println(_this.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
