// 선형 자료구조 - 큐

import java.util.study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList;
import java.util.Queue;

public class peacticecodingtest.study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards12.src.Main {
    public static void main(String[] args) {
        Queue queue = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.contains(3));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll());

    }
}
