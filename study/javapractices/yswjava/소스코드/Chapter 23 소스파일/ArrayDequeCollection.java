package study.javapractices.yswjava.소스코드.Chapter

import java.util.Deque;
import java.util.ArrayDeque;

class ArrayDequeCollection {
    public static void main(String[] args) {
        Deque<String> deq = new ArrayDeque<>(); 

        // ������ �ְ�       
        deq.offerFirst("1.Box");
        deq.offerFirst("2.Toy");
        deq.offerFirst("3.Robot");

        // �տ��� ������
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());  
    }
}