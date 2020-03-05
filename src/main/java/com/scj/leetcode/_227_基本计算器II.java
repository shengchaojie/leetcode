package com.scj.leetcode;

import java.util.*;

/**
 * 使用双栈
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 *
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _227_基本计算器II {

    static Set<Character> operatorSet = new HashSet<>();

    static {
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('*');
        operatorSet.add('/');
    }

    public int calculate(String s) {
        s = s.trim();
        List<String> tokens = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (' ' == c) {

                continue;
            } else if (!operatorSet.contains(c)) {
                temp += c;
            } else if (operatorSet.contains(c)) {
                if (temp.length() > 0) {
                    tokens.add(temp);
                }
                tokens.add(c + "");
                temp = "";
            }
        }
        if (temp != "") {
            tokens.add(temp);
        }


        Stack<String> operator = new Stack<>();
        Stack<Integer> number = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                    while (!operator.isEmpty()) {
                        number.push(calculate(operator.pop(), number.pop(), number.pop()));
                    }
                    operator.push(token);
                    break;
                case "*":
                case "/":
                    while (!operator.isEmpty() && (operator.peek().equals("*") || operator.peek().equals("/"))) {
                        number.push(calculate(operator.pop(), number.pop(), number.pop()));
                    }
                    operator.push(token);
                    break;
                default:
                    number.push(Integer.parseInt(token));
                    break;
            }
        }
        while(!operator.isEmpty()){
            number.push(calculate(operator.pop(), number.pop(), number.pop()));
        }
        return number.pop();
    }

    private Integer calculate(String token, Integer second, Integer first) {
        switch (token) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        _227_基本计算器II _this = new _227_基本计算器II();
        System.out.println(_this.calculate("1*2-3*4"));
    }


}
