package com.scj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shengchaojie
 * @date 2020-06-01
 **/
public class _1431_拥有最多糖果的孩子 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int max = Arrays.stream(candies).max().getAsInt();

        Arrays.stream(candies).forEach(a->{
            result.add(a+extraCandies>=max);
        });

        return result;
    }

}
