// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1
// 문자열 뒤집기

// 입출력 예시)
// 입력: "Hello"
// 출력: "olleH"

// 입력: 1 3 5 7 9
// 출력: 9 7 5 3 1

import java.util.Stack;

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1 {
  public static String reverseString(String str) {
    // 문자를 저장할 스택 생성
    Stack<String> stack = new Stack<>();
    // 결과 문자열을 저장할 변수
    String result = "";

    // 입력 문자열을 한 문자씩 분리하여 스택에 push
    for (String s : str.split("")) {
      stack.push(s);
    }

    // 스택이 빌 때까지 pop하여 결과 문자열에 추가
    while (!stack.isEmpty()) {
      result = result + stack.pop();
    }

    // 뒤집어진 문자열 반환
    return result;
  }

  public static void main(String[] args) {
    // Test code
    // 첫 번째 테스트 케이스
    String result = reverseString("Hello");
    System.out.println("result = " + result);

    // 두 번째 테스트 케이스
    result = reverseString("1 3 5 7 9");
    System.out.println("result = " + result);
  }
}