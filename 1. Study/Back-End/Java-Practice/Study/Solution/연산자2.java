// Java 프로그래밍 - 비트 연산자
// 이 클래스는 비트 단위의 논리 연산자와 시프트 연산자의 동작을 설명합니다.
// 비트 연산은 하드웨어 제어, 암호화, 플래그 처리 등에서 중요하게 사용됩니다.
public class Basic_03_2 {
    public static void main(String[] args) {
        // 1. 비트 논리 연산자
        // 비트 단위로 논리 연산을 수행하는 연산자들입니다.
        System.out.println("== 비트 논리 연산자 ==");

        // 1-1. AND 연산자 (&)
        // 두 비트가 모두 1일 때만 1을 반환합니다.
        // 특정 비트를 마스킹하거나 특정 비트가 설정되었는지 확인할 때 사용합니다.
        int num1 = 5;  // 2진수: 0101
        int num2 = 3;  // 2진수: 0011
        int result = 0;
        
        result = num1 & num2;  // 0101 & 0011 = 0001 (1)
        System.out.println(result);
        // printf를 사용하여 2진수 형태로 출력
        // %04d는 4자리로 출력하고 빈자리는 0으로 채움
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));

        // 1-2. OR 연산자 (|)
        // 두 비트 중 하나라도 1이면 1을 반환합니다.
        // 여러 개의 플래그를 하나로 합치거나 특정 비트를 설정할 때 사용합니다.
        num1 = 5;      // 0101
        num2 = 3;      // 0011
        result = num1 | num2;  // 0101 | 0011 = 0111 (7)
        System.out.println(result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));

        // 1-3. XOR 연산자 (^)
        // 두 비트가 다를 때 1을 반환합니다.
        // 간단한 암호화나 두 값을 스왑할 때 사용할 수 있습니다.
        num1 = 5;      // 0101
        num2 = 3;      // 0011
        result = num1 ^ num2;  // 0101 ^ 0011 = 0110 (6)
        System.out.println(result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));

        // 1-4. 반전 연산자 (~)
        // 모든 비트를 반전시킵니다. 0은 1로, 1은 0으로 변환합니다.
        // 비트 마스크의 보수를 만들 때 사용합니다.
        num1 = 5;      // 0101
        result = ~num1;  // ~0101 = 1111...1010 (-6)
        System.out.println(result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%s\n", (Integer.toBinaryString(result)));

        // 2. 비트 이동 연산자
        // 비트를 왼쪽이나 오른쪽으로 이동시키는 연산자들입니다.
        System.out.println("== 비트 이동 연산자 ==");

        // 2-1. << 연산자 (Left shift)
        // 비트를 왼쪽으로 이동시키고, 오른쪽은 0으로 채웁니다.
        // 2를 곱하는 효과가 있어 빠른 곱셈 연산에 사용될 수 있습니다.
        int numA = 3;   // 0011
        result = numA << 1;  // 0011 << 1 = 0110 (6)
        System.out.println(result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));

        // 2-2. >> 연산자 (Arithmetic right shift)
        // 비트를 오른쪽으로 이동시키고, 왼쪽은 부호 비트로 채웁니다.
        // 2로 나누는 효과가 있어 빠른 나눗셈 연산에 사용될 수 있습니다.
        numA = 3;      // 0011
        result = numA >> 1;  // 0011 >> 1 = 0001 (1)
        System.out.println(result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));

        // 2-3. >>> 연산자 (Logical right shift)
        // >> 연산자와 유사하지만, 왼쪽을 무조건 0으로 채웁니다.
        // 부호 없는 정수의 비트 이동에 사용됩니다.
        
        // 음수에 대한 >> 연산 (산술 시프트)
        numA = -5;
        result = numA >> 1;
        System.out.println(result);
        System.out.printf("%s\n", (Integer.toBinaryString(numA)));
        System.out.printf("%s\n", (Integer.toBinaryString(result)));

        // 음수에 대한 >>> 연산 (논리 시프트)
        numA = -5;
        result = numA >>> 1;
        System.out.println(result);
        System.out.printf("%s\n", (Integer.toBinaryString(numA)));
        System.out.printf("%s\n", (Integer.toBinaryString(result)));
    }
}