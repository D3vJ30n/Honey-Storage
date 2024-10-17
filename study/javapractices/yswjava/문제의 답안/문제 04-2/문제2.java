package study.javapractices.yswjava.문제의

class BitSearch {
    public static void main(String[] args) {
        int num = 15678;
        System.out.println((num>>2) & 1);
        System.out.println( (num>>4) & 1);
    }
}

/*
    �� �ڵ��� �⺻ ������ �̷���. 
    Ȯ���ϰ��� �ϴ� ��Ʈ�� ������ ������ ������. 
    �׸��� �̾ & ������ ���� 1���� 0���� Ȯ���Ѵ�. 
*/
