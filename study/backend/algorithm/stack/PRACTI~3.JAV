// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3
// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3 {
  public static double calculate(String string) {
    // 계산에 사용할 스택 생성
    Stack<Double> stack = new Stack<Double>();

    // 입력 문자열을 공백을 기준으로 분리하여 순회
    for (String str : string.split(" ")) {
      if (str.equals("+")) {
        // 덧셈 연산: 스택에서 두 개의 숫자를 꺼내어 더한 후 결과를 다시 스택에 넣음
        stack.push(stack.pop() + stack.pop());
      } else if (str.equals("-")) {
        // 뺄셈 연산: 스택에서 두 개의 숫자를 꺼내어 뺀 후 결과를 다시 스택에 넣음
        // 주의: 먼저 꺼낸 숫자를 두 번째 꺼낸 숫자에서 빼야 함
        stack.push(-stack.pop() + stack.pop());
      } else if (str.equals("*")) {
        // 곱셈 연산: 스택에서 두 개의 숫자를 꺼내어 곱한 후 결과를 다시 스택에 넣음
        stack.push(stack.pop() * stack.pop());
      } else if (str.equals("/")) {
        // 나눗셈 연산: 스택에서 두 개의 숫자를 꺼내어 나눈 후 결과를 다시 스택에 넣음
        // 주의: 먼저 꺼낸 숫자로 두 번째 꺼낸 숫자를 나눠야 함
        stack.push(1 / stack.pop() * stack.pop());
      } else {
        // 숫자인 경우: 문자열을 double 타입으로 변환하여 스택에 넣음
        stack.push(Double.parseDouble(str));
      }
    }
    // 최종 결과를 스택에서 꺼내어 반환
    return stack.pop();
  }

  public static void main(String[] args) {
    // Test code
    System.out.println(calculate("2 2 +"));    // 4
    System.out.println(calculate("2 2 -"));    // 0
    System.out.println(calculate("2 2 *"));    // 4
    System.out.println(calculate("2 2 /"));    // 1

    System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
    System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14
  }
}