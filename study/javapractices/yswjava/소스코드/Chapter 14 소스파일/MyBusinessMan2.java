package study.javapractices.yswjava.소스코드.Chapter

class Man {
    String name;

    public Man(String name) {
        this.name = name;
    }

    public void tellYourName() { 
        System.out.println("My name is " + name); 
    }
}

class BusinessMan extends Man {
    String company;
    String position;
    
    public BusinessMan(String name, String company, String position) {
        // ���� Ŭ������ ������ ȣ��
        super(name);

        this.company = company;
        this.position = position;
    }

    public void tellYourInfo() {
        System.out.println("My company is " + company);
        System.out.println("My position is " + position);
        tellYourName();
    }
}


class MyBusinessMan2 {
    public static void main(String[] args) {
        BusinessMan man
                    = new BusinessMan("YOON", "Hybrid ELD", "Staff Eng.");
        
	man.tellYourInfo();
		
    }
}