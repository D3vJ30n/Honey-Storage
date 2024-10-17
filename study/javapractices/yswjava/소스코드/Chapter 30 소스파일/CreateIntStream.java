package study.javapractices.yswjava.소스코드.Chapter

import java.util.Arrays;
import java.util.stream.IntStream;

class CreateIntStream {
    public static void showIntStream(IntStream is) {
        is.forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }

    public static void main(String[] args) {
        // ���ڷ� �����ϴ� ���� ��Ʈ������
        IntStream is3 = IntStream.of(7, 5, 3); 
        showIntStream(is3);

        // ���� 5 ���� 8 �������� ��Ʈ������
        IntStream is4 = IntStream.range(5, 8); 
        showIntStream(is4);

        // ���� 5 ���� 8 ���� ��Ʈ������
        IntStream is5 = IntStream.rangeClosed(5, 8); 
        showIntStream(is5);
     }
}