// 선형 자료구조 - 데크

import java.util.ArrayDeque;
import java.util.Deque;

public class peacticecodingtest.study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards12.src.Main {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        
        // Front 부분 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);

        // Rear 부분 입력
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);

        // Front 부분 출력
        System.out.println(deque.removeFirst());
        System.out.println(deque);

        // Rear 부분 출력
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.pollLast());
        System.out.println(deque.removeLast());

    }
}
