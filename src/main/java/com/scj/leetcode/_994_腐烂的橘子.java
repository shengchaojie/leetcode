package com.scj.leetcode;

import sun.tools.jconsole.inspector.XTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS ���������Ŀ �������Ƕ���������� ����Ǹ�˼�� Ҫʶ��������ֳ���
 * https://leetcode-cn.com/problems/rotting-oranges/
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _994_���õ����� {

    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        int xTotal = grid[0].length;
        int yTotal = grid.length;
        //��һ��������y �ڶ���������x
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

            //ֻ�и�Ⱦ�����ڵ����Ҫ++
            if(infect) {
                time++;
            }
        }

        //�ж��Ƿ���δ��Ⱦ��
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
        _994_���õ����� _this = new _994_���õ�����();
        System.out.println(_this.orangesRotting(grid));
    }

}
