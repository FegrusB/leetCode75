package leet.code.PathFinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostOnePath {
    public static void main(String[] args) {
        MinimumCostOnePath program = new MinimumCostOnePath();
        program.start();

    }

    public void start() {
        System.out.println(minCost(new int[][]{{1,3,3,3},{2,2,1,2},{4,3,3,4},{3,2,2,3},{3,2,1,3},{4,1,4,3},{3,3,1,2}}));
    }

    public int minCost(int[][] grid) {

        int endX = grid[0].length - 1;
        int endY = grid.length - 1;

        int[][] cordDiffs = {{0,0},{0,  1}, {0, -1},{1, 0},{-1, 0}};

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        PriorityQueue<coord> queue = new PriorityQueue<>();

        queue.add(new coord(0, 0, 0));

        while (true) {
            coord current = queue.poll();
            assert current != null;
            visited[current.getY()][current.getX()] = true;
            if (current.getX() == endX && current.getY() == endY) {
                return current.cost;
            }

            for (int i = 1;i < 5; i++) {
                int nextY = current.getY() + cordDiffs[i][0];
                int nextX = current.getX() + cordDiffs[i][1];

                if ((nextX < 0 || nextX > endX) || (nextY < 0 || nextY > endY)) {
                    continue;
                }
                if (visited[nextY][nextX]) {

                    continue;

                }

                int addedCost = 1;
                if (grid[current.getY()][current.getX()] == i) {addedCost =0;}
                queue.add(new coord(nextX, nextY, current.getCost() + addedCost));
            }
        }
    }


    class coord implements Comparable<coord> {
        private final int x;
        private final int y;
        private final int cost;

        public coord(int xIn, int yIn, int costIn) {
            this.x = xIn;
            this.y = yIn;
            this.cost = costIn;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(coord o) {
            return Integer.compare(this.cost, o.getCost());
        }
    }

}
