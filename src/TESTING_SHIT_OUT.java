import java.util.PriorityQueue;

public class TESTING_SHIT_OUT {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(4);
        pq.add(3);
        pq.add(2);
        pq.add(1);
        System.out.println("Priority Queue content : " + pq);
        System.out.println("Head of queue : " + pq.peek());
        System.out.print("Popping elements : ");
        while (!pq.isEmpty())
            System.out.print(pq.poll()+ " ");
        System.out.println();

    }
}