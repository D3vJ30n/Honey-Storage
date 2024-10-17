package study.javapractices;

// Java 프로그래밍 - 변수와 자료형_2
public class 변수와자료형2 {
    public static void main(String[] args) {
        // 1. 자료형 - 숫자
        System.out.println("== 숫자 ==");
        
        // 1-1. 정수
        // int: 32비트 정수형 변수 선언 및 초기화
        int intNum = 10;
        System.out.println("intNum = " + intNum);
        
        // Integer.MIN_VALUE와 MAX_VALUE: int 형의 최소값과 최대값 출력
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        
        // int 형의 최대값을 초과하는 경우 (오버플로우 발생)
        int intNum2 = Integer.MAX_VALUE;
        int intNum3 = Integer.MAX_VALUE + 1;
        System.out.println("intNum3 = " + intNum3);  // 결과는 최소값이 됨
        
        // long: 64비트 정수형으로 캐스팅하여 오버플로우 방지
        long longNum = (long) Integer.MAX_VALUE + 1;
        System.out.println("longNum = " + longNum);

        // 1-2. 실수
        // float: 32비트 부동소수점 숫자 (끝에 f를 붙여야 함)
        float floatNum = 1.123f;
        System.out.println(Float.MAX_VALUE);
        
        // double: 64비트 부동소수점 숫자
        double doubleNum = 3.4028;
        System.out.println(Double.MAX_VALUE);

        // 1-3. 2진수 / 8진수 / 16진수
        // 2진수: 0b 접두사 사용
        int numBase2 = 0b1100;
        // 8진수: 0 접두사 사용
        int numBase8 = 014;
        // 16진수: 0x 접두사 사용
        int numBase16 = 0xC;
        
        // 각 진수로 저장된 값을 10진수로 출력
        System.out.println(numBase2);
        System.out.println(numBase8);
        System.out.println(numBase16);
        
        // 10진수를 각 진수의 문자열로 변환하여 출력
        System.out.println("0b" + Integer.toBinaryString(numBase2));
        System.out.println("0" + Integer.toOctalString(numBase8));
        System.out.println("0x" + Integer.toHexString(numBase16));

        // 2. 자료형 - 부울
        System.out.println("== 부울 ==");
        // boolean: true 또는 false 값만 가질 수 있는 논리형
        boolean isPass = true;
        boolean isOk = false;
        
        System.out.println(isPass);
        System.out.println(isOk);

        // 3. 자료형 - 문자
        System.out.println("== 문자 ==");
        // char: 단일 문자를 저장하는 16비트 유니코드 문자
        char keyFirst = 'a';
        char keyLast = 'z';
        
        System.out.println(keyFirst);
        // 문자의 ASCII 코드 값 출력
        System.out.println((int) keyFirst);
        System.out.println((int) keyLast);
    }
}