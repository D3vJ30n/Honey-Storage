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

class AppleBox {
    private Apple ap;

    public void set(Apple a) {
        ap = a;
    }

    public Apple get() {
        return ap;
    }
}


class OrangeBox {
    private Orange or;

    public void set(Orange o) {
        or = o;
    }

    public Orange get() {
        return or;
    }
}


class FruitAndBox {
    public static void main(String[] args) {
        // ���� ��� �ڽ� ����
        AppleBox aBox = new AppleBox();
        OrangeBox oBox = new OrangeBox();

        // ������ �ڽ��� ��´�. 
        aBox.set(new Apple());
        oBox.set(new Orange());

        // �ڽ����� ������ ������.
        Apple ap = aBox.get();
        Orange og = oBox.get();

        System.out.println(ap);
        System.out.println(og);
    }
}