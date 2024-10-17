package study.javapractices.yswjava.소스코드.Chapter

import java.util.Queue;
import java.util.LinkedList;

class LinkedListQueue {
    public static void main(String[] args) {
        Queue<String> que = new LinkedList<>(); 

        // ������ ����       
        que.offer("Box");
        que.offer("Toy");
        que.offer("Robot");

        // ������ ������ ������ Ȯ��
        System.out.println("next: " + que.peek());

        // ù ��°, �� ��° �ν��Ͻ� ������
        System.out.println(que.poll());
        System.out.println(que.poll());

        // ������ ������ ������ Ȯ��
        System.out.println("next: " + que.peek());

        // ������ �ν��Ͻ� ������
        System.out.println(que.poll());
    }
}