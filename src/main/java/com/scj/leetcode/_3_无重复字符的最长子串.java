package com.scj.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * ���������㷨
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author shengchaojie
 * @date 2020-02-28
 **/
public class _3_���ظ��ַ�����Ӵ� {

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

    // TODO: 2020-02-28 ������hashmap�Ż�

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdabcde"));
    }
}
