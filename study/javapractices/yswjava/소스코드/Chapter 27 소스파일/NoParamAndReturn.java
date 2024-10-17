package study.javapractices.yswjava.소스코드.Chapter

import java.util.Random;

interface Generator {
    int rand();    // �Ű����� ���� �޼ҵ�
}

class NoParamAndReturn {
    public static void main(String[] args) {
        Generator gen = () -> {
            Random rand = new Random();
            return rand.nextInt(50);
        };

        System.out.println(gen.rand());
    }
}