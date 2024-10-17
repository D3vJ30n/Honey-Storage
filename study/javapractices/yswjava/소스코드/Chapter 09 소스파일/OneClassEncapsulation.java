package study.javapractices.yswjava.소스코드.Chapter

class SinusCap {
    void sniTake() {
        System.out.println("�๰�� ��~ ���ϴ�.");
    }
 
    void sneTake() {
        System.out.println("��ä�Ⱑ �ܽ��ϴ�.");
    }

    void snuTake() {
        System.out.println("�ڰ� �� �ո��ϴ�.");
    }

    void take() {
        sniTake();
        sneTake();
        snuTake();
    }
}


class ColdPatient {
    void takeSinus(SinusCap cap) {
        cap.take();
    }
}

class OneClassEncapsulation {
    public static void main(String[] args) {
        ColdPatient suf = new ColdPatient();

        suf.takeSinus(new SinusCap());
    }
}