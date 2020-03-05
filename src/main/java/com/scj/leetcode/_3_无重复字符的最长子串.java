package com.scj.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口算法
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _3_无重复字符的最长子串 {

    public static  int lengthOfLongestSubstring(String s) {
        int first = 0 ;
        int second = 0;
        int max = 0;
        Set<Character> unique = new HashSet<>();
        while(second < s.length()){
            if(!unique.contains(s.charAt(second))){
                unique.add(s.charAt(second++));
                max = Math.max(second-first,max);
            }else{
                unique.remove(s.charAt(first++));
            }

        }
        return max;
    }

    // TODO: 2020-02-28 可以用hashmap优化

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdabcde"));
    }
}
