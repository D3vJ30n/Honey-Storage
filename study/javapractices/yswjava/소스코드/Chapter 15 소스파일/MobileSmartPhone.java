package study.javapractices.yswjava.소스코드.Chapter

class MobilePhone {
    protected String number;
    
    public MobilePhone(String num) {
        number = num;
    }
    
    public void answer() {
        System.out.println("Hi~ from " + number);
    }
}

class SmartPhone extends MobilePhone { 
    private String androidVer;
    
    public SmartPhone(String num, String ver) {
        super(num);
        androidVer = ver;
    }
    
    public void playApp() {
        System.out.println("App is running in " + androidVer);
    }
}


class MobileSmartPhone {
    public static void main(String[] args) {
        // ����Ʈ ���� �ϳ� ����
        SmartPhone phone = new SmartPhone("010-555-777", "Nougat");
        
        // ��ȭ�� �޴´�. 
        phone.answer();
        
        // ���� �����ϰ� �����Ѵ�.
        phone.playApp();    
    }
}