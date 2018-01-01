package hiringchallenges;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by bugkiller on 8/5/2017.
 */
public class Experiment {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(5);
        pq.offer(4);
        pq.offer(3);
        pq.offer(2);
        pq.offer(1);
        pq.offer(0);
        System.out.println(pq);
    }
}
