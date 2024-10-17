package study.javapractices;

// Java 프로그래밍 - 변수와 자료형_3
public class 변수와자료형3 {
    public static void main(String[] args) {
        // 1. 자료형 - 문자열
        System.out.println("== 문자열 ==");
        // String 객체 생성 및 초기화
        String s1 = "Hello World!";
        String s2 = "01234";
        System.out.println("s1 = " + s1);  // s1 문자열 출력
        System.out.println("s2 = " + s2);  // s2 문자열 출력

        // 1-1. equals 메소드: 문자열 내용 비교
        String s3 = "hi";
        String s4 = "hi";
        System.out.println(s3.equals(s4));  // true: 내용이 같으므로
        System.out.println(s3 == s4);  // true: 같은 문자열 리터럴을 참조하므로 (String pool 사용)
        String s5 = new String("hi");  // 새로운 String 객체 생성
        System.out.println(s3.equals(s5));  // true: 내용이 같으므로
        System.out.println(s3 == s5);  // false: 다른 객체를 참조하므로

        // 1-2. indexOf 메소드: 특정 문자나 문자열의 위치 찾기
        String s6 = "Hello! World!";
        System.out.println(s6.indexOf("!"));  // 5: 첫 번째 '!'의 인덱스
        // 두 번째 '!'의 인덱스 찾기: 첫 번째 '!' 이후부터 검색
        System.out.println(s6.indexOf("!", s6.indexOf("!") + 1));  // 12

        // 1-3. replace 메소드: 문자열 대체
        String s7 = s6.replace("Hello", "Bye");  // "Hello"를 "Bye"로 대체
        System.out.println("s7 = " + s7);  // "Bye! World!" 출력

        // 1-4. substring 메소드: 부분 문자열 추출
        System.out.println(s7.substring(0, 3));  // "Bye" 출력: 0부터 3 전까지
        System.out.println(s7.substring(0, s7.indexOf("!") + 1));  // "Bye!" 출력

        // 1-5. toUpperCase 메소드: 대문자로 변환
        System.out.println(s7.toUpperCase());  // "BYE! WORLD!" 출력

        // 2. 자료형 - StringBuffer
        // StringBuffer: 문자열을 동적으로 조작할 수 있는 클래스
        System.out.println("== StringBuffer ==");
        StringBuffer sb1 = new StringBuffer();
        sb1.append("01234");  // 문자열 추가
        System.out.println("sb1 = " + sb1);
        sb1.append("56789");  // 추가 문자열 덧붙이기
        System.out.println("sb1 = " + sb1);

        // String과 StringBuffer의 차이점 시연
        String a = "01234";
        String b = "56789";
        String bak = a;
        System.out.println(a == bak);  // true: 같은 객체 참조
        a += b;  // 새로운 String 객체 생성
        System.out.println(a == bak);  // false: 다른 객체 참조

        // StringBuffer의 다양한 메소드 사용
        StringBuffer sb2 = new StringBuffer("name is");
        sb2.insert(0, "My ");  // 시작 부분에 삽입
        sb2.insert(sb2.length(), " JAVA");  // 끝 부분에 삽입
        System.out.println("sb2 = " + sb2);
        System.out.println(sb2.substring(0, 2));  // 부분 문자열 추출

        // 3. 자료형 - 배열
        System.out.println("== 배열 ==");
        // 정수형 배열 선언 및 초기화
        int[] myArray1 = {1, 2, 3, 4, 5};
        // 배열의 각 요소 출력
        System.out.println(myArray1[0]);  // 1
        System.out.println(myArray1[1]);  // 2
        System.out.println(myArray1[2]);  // 3
        System.out.println(myArray1[3]);  // 4
        System.out.println(myArray1[4]);  // 5

        // 문자형 배열 선언 및 초기화
        char[] myArray2 = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(myArray2[2]);  // 'c' 출력

        // 문자열 배열 선언 및 초기화
        String[] myArray3 = new String[3];  // 크기 3의 문자열 배열 생성
        myArray3[0] = "Hello";
        myArray3[1] = " ";
        myArray3[2] = "World!";
        // 배열의 요소들을 연결하여 출력
        System.out.println(myArray3[0] + myArray3[1] + myArray3[2]);  // "Hello World!" 출력
    }
}