package study.javapractices.yswjava.문제의

class NumberRange {
    public static void main(String[] args) {
        int n = 24;
        
        switch(n / 10) {
        case 0:
            System.out.println("0�̻� 10�̸��� ��");
            break;
        case 1:
            System.out.println("10�̻� 20�̸��� ��");
            break;
        case 2:
            System.out.println("20�̻� 30�̸��� ��");
            break;
        default:
            System.out.println("���� Ȥ�� 30 �̻��� ��");
        }
    }
}
