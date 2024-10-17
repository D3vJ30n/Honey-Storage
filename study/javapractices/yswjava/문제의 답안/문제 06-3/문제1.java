package study.javapractices.yswjava.문제의

class ReculsivePowerOfTwo {
    public static void main(String[] args) {
        System.out.println("2�� 5�� : " + powerOfTwo(5));
        System.out.println("2�� 7�� : " + powerOfTwo(7));
    }
    
    public static int powerOfTwo(int n) {
        if(n == 0)
            return 1;
        
        return 2 * powerOfTwo(n - 1);
    }
}
