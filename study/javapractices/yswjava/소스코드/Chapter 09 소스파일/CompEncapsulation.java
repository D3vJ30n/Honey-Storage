package study.javapractices.yswjava.소스코드.Chapter

class SinivelCap {    // �๰ óġ�� ĸ��
    void take() {
        System.out.println("�๰�� ��~ ���ϴ�.");
    }
}

class SneezeCap {    // ��ä�� óġ�� ĸ��
    void take() {
        System.out.println("��ä�Ⱑ �ܽ��ϴ�.");
    }
}

class SnuffleCap {    // �ڸ��� óġ�� ĸ��
    void take() {
        System.out.println("�ڰ� �� �ո��ϴ�.");
    }
}

class SinusCap {
    SinivelCap siCap = new SinivelCap();
    SneezeCap szCap = new SneezeCap();
    SnuffleCap sfCap = new SnuffleCap();

    void take() {
        siCap.take();
        szCap.take();
        sfCap.take();
    }
}

class ColdPatient {
    void takeSinus(SinusCap cap) {
        cap.take();
    }
}

class CompEncapsulation {
    public static void main(String[] args) {
        ColdPatient suf = new ColdPatient();
        suf.takeSinus(new SinusCap());
    }
}