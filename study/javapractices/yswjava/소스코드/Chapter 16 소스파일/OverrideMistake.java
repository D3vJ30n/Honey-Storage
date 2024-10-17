package study.javapractices.yswjava.소스코드.Chapter

class ParentAdder {
    public int add(int a, int b) {
        return a + b;
    }
}

class ChildAdder extends ParentAdder {
    public double add(double a, double b) {
        System.out.println("������ �����մϴ�.");
        return a + b;
    }
}

class OverrideMistake {
    public static void main(String[] args) {
        ParentAdder adder = new ChildAdder();
        System.out.println(adder.add(3, 4));
    }
}