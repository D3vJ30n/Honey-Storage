package study.javapractices.yswjava.소스코드.Chapter

class Box<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

class Toy {
    @Override 
    public String toString() { 
        return "I am a Toy";
    }
}

class BoxHandler {
    public static void outBox(Box<Toy> box) {
        Toy t = box.get();    // �ڽ����� ������
        System.out.println(t);
    }

    public static void inBox(Box<Toy> box, Toy n) {
        box.set(n);    // �ڽ��� �ֱ�
    } 
}


class BoundedWildcardBase {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        BoxHandler.inBox(box, new Toy());
        BoxHandler.outBox(box); 
    }
}