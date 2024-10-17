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

class ColdPatient {
    void takeSinivelCap(SinivelCap cap) {
        cap.take();
    }

    void takeSneezeCap(SneezeCap cap) { 
        cap.take();
    }

    void takeSnuffleCap(SnuffleCap cap) {
        cap.take();
    }
}

class BadEncapsulation {
    public static void main(String[] args) {
        ColdPatient suf = new ColdPatient();

        // �๰ ĸ�� ���� �� ����
        suf.takeSinivelCap(new SinivelCap());
        
        // ��ä�� ĸ�� ���� �� ����
        suf.takeSneezeCap(new SneezeCap());
        
        // �ڸ��� ĸ�� ���� �� ����
        suf.takeSnuffleCap(new SnuffleCap());
    }
}