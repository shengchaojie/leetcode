package com.scj.leetcode;

import java.util.Objects;

/**
 * @author shengchaojie
 * @date 2020-05-19
 **/
public class _680_验证回文字符串Ⅱ {

    public boolean validPalindrome(String s) {
        return validPalindrome(s,false);
    }

    public boolean validPalindrome(String s ,boolean skip) {
        int start = 0, end = s.length() - 1;
        while(start<end){
            if(!Objects.equals(s.charAt(start),s.charAt(end))){
                if(!skip){
                    //注意substring最后一位不包括
                    return validPalindrome(s.substring(start,end),true) || validPalindrome(s.substring(start+1,end+1),true);
                }else{
                    return false;
                }
            }

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        _680_验证回文字符串Ⅱ _this = new _680_验证回文字符串Ⅱ();
        System.out.println(_this.validPalindrome("ebcbbececabbacecbbcbe"));
//        System.out.println(_this.validPalindrome("aba"));
//        System.out.println(_this.validPalindrome("abac"));
//        System.out.println(_this.validPalindrome("abca"));
//        System.out.println(_this.validPalindrome("abcaf"));
//        System.out.println(_this.validPalindrome("deeee"));
//        System.out.println(_this.validPalindrome("eeeef"));
    }

}
