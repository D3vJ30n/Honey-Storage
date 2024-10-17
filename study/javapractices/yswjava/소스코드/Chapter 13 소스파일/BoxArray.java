package study.javapractices.yswjava.소스코드.Chapter

class Box {
    private String conts;
    
    Box(String cont){
        this.conts = cont;
    }
    
    public String toString() {
        return conts;
    }	
}

class BoxArray {
    public static void main(String[] args) {
        Box[] ar = new Box[3];

        // �迭�� �ν��Ͻ� ����        
        ar[0] = new Box("First");
        ar[1] = new Box("Second");
        ar[2] = new Box("Third");

        // ����� �ν��Ͻ��� ����
        System.out.println(ar[0]);
        System.out.println(ar[1]);
        System.out.println(ar[2]);
        
    }
}