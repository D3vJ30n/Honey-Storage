package study.javapractices.yswjava.문제의

class Exceed1000 {
    public static void main(String[] args) {
        int sum = 0;
        int num = 1; 
    
        while(true) {
            if(num % 2 != 0)
                sum += num;

            if(sum > 1000) {
                System.out.println(num + " ���� �� 1000�� �Ѵ´�.");
                System.out.println("�ʰ��� ��: " + sum);
                break;
            }
            
            num++;
        }
    }
}
