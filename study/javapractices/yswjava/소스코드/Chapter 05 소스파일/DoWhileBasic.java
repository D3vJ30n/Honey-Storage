package study.javapractices.yswjava.소스코드.Chapter

class DoWhileBasic {
    public static void main(String[] args) {
        int num = 0;

        do {
            System.out.println("I like Java " + num);
            num++;
        } while(num < 5);
    }
}