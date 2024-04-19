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
        System.out.println(minCost(new int[][]{{1,1,3},{3,2,2},{1,1,4}}));
    }

    public int minCost(int[][] grid) {

        int endX = grid.length - 1;
        int endY = grid[0].length - 1;

        int[][] cordDiffs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        PriorityQueue<coord> queue = new PriorityQueue<>();
        boolean[][] visitedBoard = new boolean[grid.length][grid[0].length];

        queue.add(new coord(0, 0, 0, new ArrayList<>()));

        while (true) {
            coord current = queue.poll();

            assert current != null;
            if (current.getX() == endX && current.getY() == endY) {
                return current.cost;
            }

            for (int[] difs : cordDiffs) {
                int nextX = current.getX() + difs[0];
                int nextY = current.getY() + difs[1];

                if ((nextX < 0 || nextX > endX) || (nextY < 0 || nextY > endY)) {
                    continue;
                }
                if (current.checkHistory(new int[]{nextX, nextY})) {
                    continue;
                }

                int addedCost = switch (grid[current.getY()][current.getX()]) {
                    case 1: {
                        if (difs[1] == 1 && difs[0] == 0) {
                            yield 0;
                        } else {
                            yield 1;
                        }
                    }
                    case 2: {
                        if (difs[1] == -1 && difs[0] == 0) {
                            yield 0;
                        } else {
                            yield 1;
                        }
                    }
                    case 3: {
                        if (difs[1] == 0 && difs[0] == 1) {
                            yield 0;
                        } else {
                            yield 1;
                        }
                    }
                    case 4: {
                        if (difs[1] == 0 && difs[0] == -1) {
                            yield 0;
                        } else {
                            yield 1;
                        }
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + grid[current.getX()][current.getY()]);
                };

                queue.add(new coord(nextX, nextY, current.getCost() + addedCost, current.getHistory()));
            }
        }
    }


    class coord implements Comparable<coord> {
        private final int x;
        private final int y;
        private final int cost;

        private ArrayList<int[]> history;

        public coord(int xIn, int yIn, int costIn, ArrayList<int[]> historyIn) {
            this.x = xIn;
            this.y = yIn;
            this.cost = costIn;
            this.history = historyIn;
            this.history.add(new int[]{this.x, this.y});
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

        public ArrayList<int[]> getHistory() {
            return this.history;
        }

        public boolean checkHistory(int[] check) {
            boolean out = false;
            for (int[] contents : this.history) {
                if (Arrays.equals(check, contents)) {
                    out = true;
                    break;
                }}
            return out;
        }

        @Override
        public int compareTo(coord o) {
            return Integer.compare(this.cost, o.getCost());
        }
    }

}
