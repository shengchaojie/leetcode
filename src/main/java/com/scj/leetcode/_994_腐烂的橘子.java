package com.scj.leetcode;

import sun.tools.jconsole.inspector.XTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 广度优先题目 不仅仅是二叉树有这个 这个是个思想 要识别出来这种场景
 * https://leetcode-cn.com/problems/rotting-oranges/
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _994_腐烂的橘子 {

    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        int xTotal = grid[0].length;
        int yTotal = grid.length;
        //第一层数组是y 第二层数组是x
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Position(j, i));
                }
            }
        }

        int time = 0;

        while (!queue.isEmpty()) {

            List<Position> positions = new ArrayList<>();
            while (!queue.isEmpty()) {
                positions.add(queue.poll());
            }

            boolean infect =false;
            for (Position position : positions) {
                int x = position.x;
                int y = position.y;
                if (x <= xTotal - 1 && x > 0 && grid[y][x - 1] ==1) {
                    infect =true;
                    grid[y][x - 1] = 2;
                    queue.add(new Position(x - 1, y));
                }
                if (x >= 0 && x < xTotal - 1 && grid[y][x+1] ==1) {
                    infect =true;
                    grid[y][x+1] = 2;
                    queue.add(new Position(x + 1, y));
                }
                if (y <= yTotal - 1 && y > 0 && grid[y - 1] [x]==1) {
                    infect =true;
                    grid[y - 1] [x] = 2;
                    queue.add(new Position(x, y - 1));
                }
                if (y < yTotal - 1 && y >= 0 && grid[y + 1][x] ==1) {
                    infect =true;
                    grid[y + 1][x] = 2;
                    queue.add(new Position(x, y + 1));
                }
            }

            //只有感染其他节点才需要++
            if(infect) {
                time++;
            }
        }

        //判断是否还有未感染的
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    static class Position {

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    public static void main(String[] args) {
        //int[][] grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = new int[][]{{1,2}};
        _994_腐烂的橘子 _this = new _994_腐烂的橘子();
        System.out.println(_this.orangesRotting(grid));
    }

}
