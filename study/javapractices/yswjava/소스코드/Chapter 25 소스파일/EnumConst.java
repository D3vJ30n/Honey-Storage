package study.javapractices.yswjava.소스코드.Chapter

enum Person {
    MAN, WOMAN;

    @Override
    public String toString() {
        return "I am a dog person";
    }
}

class EnumConst {
    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}
