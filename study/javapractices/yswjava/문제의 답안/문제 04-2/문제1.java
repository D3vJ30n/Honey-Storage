package study.javapractices.yswjava.문제의

class TwosComp {
    public static void main(String[] args) {
        int num=7;
        num = ~num;
        num += 1;
        System.out.println(num);
    }
}
