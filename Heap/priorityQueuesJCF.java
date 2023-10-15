package Heap;

import java.util.PriorityQueue;

public class priorityQueuesJCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(7);
        pq.add(1);

        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
    }
}
