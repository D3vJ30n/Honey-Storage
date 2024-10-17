package study.javapractices.yswjava.소스코드.Chapter

import java.util.Optional;

class StringOptional2 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of(new String("Toy1"));
        Optional<String> os2 = Optional.ofNullable(new String("Toy2"));

        // ���ٽ� ����
        os1.ifPresent(s -> System.out.println(s));

        // �޼ҵ� ���� ����
        os2.ifPresent(System.out::println);
    }
}