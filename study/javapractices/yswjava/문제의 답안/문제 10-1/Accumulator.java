package study.javapractices.yswjava.문제의

class Accumulator {
    static int sum = 0;

    static void add(int n) {
        sum += n;
    }
    static void showResult() {
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            Accumulator.add(i);     // ���޵Ǵ� ���� ��� ����
        
        Accumulator.showResult();    // ���� ���� ����� ���
    }
}

