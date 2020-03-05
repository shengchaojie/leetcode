package com.scj.leetcode;

import java.util.Stack;

/**
 * 1. ʹ��switch
 * 2. stackʹ��integer���� ������ÿһ��������ʱ����ת��
 * �и��ⷨ ������ģ��ջ ���Ĳ���
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _150_�沨�����ʽ��ֵ {

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
        _150_�沨�����ʽ��ֵ _this = new _150_�沨�����ʽ��ֵ();
        System.out.println(_this.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
