package study.javapractices.yswjava.소스코드.Chapter

class ThreadMultiNoSleepDemo {
    public static void main(String[] args) {
        Runnable task1 = () -> {    // 20 �̸� ¦�� ���
            for(int i = 0; i < 20; i++) {
                if(i % 2 == 0)
                    System.out.print(i + " ");
            }          
        };

        Runnable task2 = () -> {    // 20 �̸� Ȧ�� ���
            for(int i = 0; i < 20; i++) {
                if(i % 2 == 1)
                    System.out.print(i + " ");
            } 
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}