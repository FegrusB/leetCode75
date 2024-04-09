package leet.code.Queue;

import java.util.ArrayList;

public class NumberOfRecentCalls {

    public static void main(String[] args) {
         RecentCounter obj = new RecentCounter();

         obj.ping(1);
         obj.ping(100);
         obj.ping(3001);
         int param_1 = obj.ping(3002);
        System.out.println(param_1);
    }

}


class RecentCounter {

    ArrayList<Integer> requests;

    public RecentCounter() {
        this.requests = new ArrayList<>();
    }

    public int ping(int t) {
        this.requests.add(t);
        return countRequests(t);
    }
    private int countRequests(int time){
       int count = 0;
        for( int i : requests){
            if (i >= time - 3000){count++;}
        }
        return count;
    }
}