package com.scj.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author shengchaojie
 * @date 2020-02-29
 **/
public class _20_有效的括号 {

    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(check(stack.peek(),s.charAt(i))){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean check(char a , char b){
        if('('==a){
            return ')' ==b;
        }
        if('{'==a){
            return '}'==b;
        }
        if('['==a){
            return ']'==b;
        }
        return false;
    }

    public static void main(String[] args) {
        _20_有效的括号 _this = new _20_有效的括号();
        System.out.println(_this.isValid("[(])"));
    }

}
