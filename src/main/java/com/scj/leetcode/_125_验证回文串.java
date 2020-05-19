package com.scj.leetcode;

/**
 * @author shengchaojie
 * @date 2020-05-19
 **/
public class _125_验证回文串 {

    /**
     * ascii码
     * 0-9 对应 48-57
     * a-z 对应 97-122
     * A-Z 对应 65-90
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s==null || s.equals("")) return true;
        s = s.toLowerCase().trim();
        int start = 0 ,end = s.length()-1;
        while (start<end){
            if(!isValid(s.charAt(start))){
                start++;
                continue;
            }
            if(!isValid(s.charAt(end))){
                end--;
                continue;
            }
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    private boolean isValid(char ch){
        return (ch >=48 && ch<=57) || (ch >=97 && ch<=122) || (ch >=65 && ch<=90);
    }

    public static void main(String[] args) {
        _125_验证回文串 _this = new _125_验证回文串();
        System.out.println(_this.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
