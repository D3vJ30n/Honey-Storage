// Practice1
// 문자열 뒤집기

// 입출력 예시)
// 입력: "Hello"
// 출력: "OlleH"

// 입력: 1 3 5 7 9
// 출력: 9 7 5 3 1

import java.util.Stack;  // Java의 Stack 클래스를 사용하기 위한 import

public class Practice1 {
    // 문자열을 뒤집는 메소드
    public static String reverseString(String str) {
        Stack stack = new Stack();  // 문자를 저장할 스택 객체 생성
        String result = "";  // 결과 문자열을 저장할 변수 초기화

        // 입력 문자열을 한 문자씩 분리하여 스택에 push
        for(String s: str.split("")) {
            stack.push(s);  // 각 문자를 스택에 추가
        }

        // 스택이 빌 때까지 pop하여 결과 문자열 생성
        while (!stack.isEmpty()) {
            result = result + stack.pop();  // 스택에서 문자를 꺼내 결과 문자열에 추가
        }

        return result;  // 뒤집어진 문자열 반환
    }

    public static void main(String[] args) {
        // Test code
        String result = reverseString("Hello");  // "Hello" 문자열 뒤집기
        System.out.println("result = " + result);  // 결과 출력

        result = reverseString("1 3 5 7 9");  // "1 3 5 7 9" 문자열 뒤집기
        System.out.println("result = " + result);  // 결과 출력
    }
}