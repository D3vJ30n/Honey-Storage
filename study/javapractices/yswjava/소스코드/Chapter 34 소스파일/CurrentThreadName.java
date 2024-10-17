package study.javapractices.yswjava.소스코드.Chapter

class CurrentThreadName {
    public static void main(String[] args) {
        Thread ct = Thread.currentThread();
        String name = ct.getName();
        System.out.println(name);
    }
}