
// import java.util.Comparator;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    String name;
    int rank;

    Student(String n, int r) {
        name = n;
        rank = r;
    }

    @Override
    public int compareTo(Student s2) {
        return this.rank - s2.rank;
    }
}

public class PQ {
    public static void main(String[] args) {
        // Comparator<Student> comparator = Comparator.comparing(o -> o.rank);
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A", 3));
        pq.add(new Student("B", 14));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 55));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }
}
