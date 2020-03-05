package com.scj.leetcode;

import java.util.*;

/**
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _224_基本计算器 {

    static class Solution {
        public int calculate(String s) {
            return evalRPN(normalizeRPN(s));
        }

        public int evalRPN(List<String> tokens) {
            Stack<Integer> stack = new Stack<>();
            Integer second,first;
            for (String token:tokens) {
                switch (token) {
                    case "+":
                        second = stack.pop();
                        first = stack.pop();
                        stack.push(first + second );
                        break;
                    case "-":
                        second = stack.pop();
                        first = stack.pop();
                        stack.push(first - second );
                        break;
                    case "*":
                        second = stack.pop();
                        first = stack.pop();
                        stack.push(first * second );
                        break;
                    case "/":
                        second = stack.pop();
                        first = stack.pop();
                        stack.push(first / second );
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                        break;
                }
            }
            return stack.pop();
        }

        static Set<Character> operatorSet = new HashSet<>();

        static {
            operatorSet.add('+');
            operatorSet.add('-');
            operatorSet.add('(');
            operatorSet.add(')');
        }

        public List<String> normalizeRPN(String s) {
            //先处理s 把各元素分割开来
            s =s.trim();
            List<String> tokens = new ArrayList<>();
            String temp = "";
            for(int i =0;i< s.length();i++){
                char c = s.charAt(i);
                if(' '==c){

                    continue;
                }else if(!operatorSet.contains(c)){
                    temp += c;
                }else if(operatorSet.contains(c)){
                    if(temp.length()>0) {
                        tokens.add(temp);
                    }
                    tokens.add(c+"");
                    temp="";
                }
            }
            if(temp!="") {
                tokens.add(temp);
            }


            Stack<String> operator = new Stack<>();
            List<String> result = new ArrayList<>();
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        while(!operator.isEmpty() && (operator.peek().equals("-")||operator.peek().equals("+"))){
                            result.add(operator.pop());
                        }
                        operator.push(token);

                        break;
                    case "-":
                        while(!operator.isEmpty() && (operator.peek().equals("-")||operator.peek().equals("+"))){
                            result.add(operator.pop());
                        }
                        operator.push(token);
                        break;
                    case "(":
                        operator.push(token);
                        break;
                    case ")":
                        while((!operator.peek().equals("("))){
                            result.add(operator.pop());
                        }
                        operator.pop();
                        break;
                    default:
                        result.add(token);
                        break;
                }
            }
            while (!operator.isEmpty()){

                result.add(operator.pop());
            }
            return result;
        }
    }



    public static void main(String[] args) {
        Solution _this = new Solution();

        //System.out.println(_this.calculate(" 2-1 + 2 "));
        System.out.println(_this.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(_this.calculate("11+2-3"));
        System.out.println(_this.calculate("12 + 2 - 3"));
    }

}
