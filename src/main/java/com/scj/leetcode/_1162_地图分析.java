package com.scj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shengchaojie
 * @date 2020-03-29
 **/
public class _1162_地图分析 {

    public static void main(String[] args) {
        _1162_地图分析 _this = new _1162_地图分析();
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(_this.maxDistance(grid));
    }

    public int maxDistance(int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int xTotal = grid[0].length;
        int yTotal = grid.length;

        Queue<Position> queue = new LinkedList<>();
        for (int x = 0; x < xTotal; x++) {
            for (int y = 0; y < yTotal; y++) {
                if (grid[x][y] == 1) {
                    queue.add(new Position(x, y));
                }
            }
        }

        if (queue.isEmpty() || queue.size() == xTotal * yTotal) {
            return -1;
        }

        int level = -1;
        while (!queue.isEmpty()) {
            level ++;
            int size = queue.size();
            while (--size>=0) {
                Position position = queue.poll();
                if(position !=null){
                    for (int i = 0; i < 4; i++) {
                        int x = position.x + dx[i];
                        int y = position.y + dy[i];
                        if (x < 0 || y < 0 || x >= xTotal || y >= yTotal || grid[x][y] != 0) {
                            continue;
                        }
                        grid[x][y] = 2;
                        queue.add(new Position(x,y));
                    }
                }
            }
        }
        return level;

    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
