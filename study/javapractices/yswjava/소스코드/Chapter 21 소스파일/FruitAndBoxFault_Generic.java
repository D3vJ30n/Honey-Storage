package study.javapractices.yswjava.소스코드.Chapter

class Apple {
    public String toString() {
        return "I am an apple.";
    }    
}

class Orange {
    public String toString() {
        return "I am an orange.";
    }
}

class Box<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }
    public T get() {
        return ob;
    }
}

class FruitAndBoxFault_Generic {
    public static void main(String[] args) {
        Box<Apple> aBox = new Box<Apple>();
        Box<Orange> oBox = new Box<Orange>();

        // ������ �ڽ��� ���� ���ϱ�? 
        aBox.set("Apple");
        oBox.set("Orange");

        // �ڽ����� ������ ����� ���� �� ������?
        Apple ap = aBox.get();
        Orange og = oBox.get();

        System.out.println(ap);
        System.out.println(og);
    }
}