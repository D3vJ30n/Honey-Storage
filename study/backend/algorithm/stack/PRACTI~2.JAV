// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice2
// 괄호 짝 검사

// 입출력 예시)
// 입력: "("
// 출력: Fail

// 입력: ")"
// 출력: Fail

// 입력: "()"
// 출력: Pass

import java.util.Stack;

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice2 {
  public static void checkParenthesis(String str) {
    // 괄호를 저장할 스택 생성
    Stack<String> stack = new Stack<>();
    // 괄호 짝이 맞는지 확인하는 플래그
    boolean checkFlag = true;

    // 입력 문자열을 한 문자씩 순회
    for (String s : str.split("")) {
      if (s.equals("(")) {
        // 여는 괄호는 스택에 push
        stack.push(s);
      } else {
        // 닫는 괄호를 만났을 때
        if (stack.isEmpty()) {
          // 스택이 비어있으면 짝이 맞지 않음
          checkFlag = false;
          break;
        } else {
          // 스택에서 여는 괄호를 pop
          stack.pop();
        }
      }
    }

    // 모든 괄호의 짝이 맞고 스택이 비어있으면 PASS
    if (checkFlag && stack.isEmpty()) {
      System.out.println("PASS!");
    } else {
      System.out.println("FAIL!");
    }
  }

  public static void main(String[] args) {
    // Test code
    checkParenthesis("(");       // FAIL!
    checkParenthesis(")");       // FAIL!
    checkParenthesis("()");      // PASS!
    checkParenthesis("()()()");  // PASS!
    checkParenthesis("(())()");  // PASS!
    checkParenthesis("(((()))"); // FAIL!
  }
}