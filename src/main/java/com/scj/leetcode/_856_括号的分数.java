package com.scj.leetcode;

import java.util.Stack;

/**
 * 高效的做法 是根据层数来判断
 * (1+2)*2 = 1*2 + 2*2
 * https://leetcode-cn.com/problems/score-of-parentheses/
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _856_括号的分数 {

    //5ms
    public int scoreOfParentheses(String S) {
        Stack<Object> stack = new Stack<>();
        Integer sum;
        S = S.replace("()","1");
        for(String s :S.split("")){
            switch (s){
                case "(":
                    stack.push(s);
                    break;
                case ")":
                    sum = (Integer)stack.pop() <<1;
                    stack.pop();
                    if(!stack.isEmpty()&&!stack.peek().equals("(")&&!stack.peek().equals(")")){
                        sum = (Integer)stack.pop() + sum;
                        stack.push(sum);
                    }else{
                        stack.push(sum);
                    }
                    break;
                default:
                    if(!stack.isEmpty()&&!stack.peek().equals("(")&&!stack.peek().equals(")")){
                        sum = (Integer) stack.pop() + Integer.parseInt(s);
                        stack.push(sum);
                    }else{
                        stack.push(Integer.parseInt(s));
                    }
                    break;
            }
        }
       return (Integer) stack.pop();
    }

    //比上面那个快了1ms
    public int scoreOfParentheses2(String S) {
        Stack<Object> stack = new Stack<>();
        Integer sum;
        for(String s :S.split("")){
            switch (s){
                case "(":
                    stack.push(s);
                    break;
                case ")":
                    if(stack.peek().equals("(")){
                        stack.pop();
                        sum =1;
                    }else{
                        sum = (Integer)stack.pop() <<1;
                        stack.pop();
                    }
                    if(!stack.isEmpty()&&!stack.peek().equals("(")&&!stack.peek().equals(")")){
                        sum = (Integer)stack.pop() + sum;
                    }
                    stack.push(sum);
                    break;
                default:
                    if(!stack.isEmpty()&&!stack.peek().equals("(")&&!stack.peek().equals(")")){
                        sum = (Integer) stack.pop() + Integer.parseInt(s);
                    }else{
                        sum=Integer.parseInt(s);
                    }
                    stack.push(sum);
                    break;
            }
        }
        return (Integer) stack.pop();
    }

    public static void main(String[] args) {
        _856_括号的分数 _this = new _856_括号的分数();
        System.out.println(_this.scoreOfParentheses2("(()(()))"));
    }

}
