import java.util.Stack;

public class study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice4 {
  // 두 문자열을 비교하는 메인 메소드
  public static boolean stringCompare(String s1, String s2) {
    // 각 문자열에 대해 backspace 처리를 수행
    String s1After = doBackspace(s1);
    String s2After = doBackspace(s2);
    // 처리된 두 문자열이 동일한지 비교하여 결과 반환
    return s1After.equals(s2After);
  }
  
  // 문자열에서 '#'을 backspace로 처리하는 메소드
  public static String doBackspace(String s) {
    Stack<Character> stack = new Stack<>();
    
    // 문자열의 각 문자를 순회
    for (char c : s.toCharArray()) {
      if (c == '#' && !stack.isEmpty()) {
        // '#'이고 스택이 비어있지 않으면 최근 문자 제거
        stack.pop();
      } else if (c != '#') {
        // '#'이 아니면 스택에 문자 추가
        stack.push(c);
      }
      // '#'이고 스택이 비어있으면 아무 작업도 하지 않음
    }
    
    // 스택의 내용을 문자열로 변환하여 반환
    StringBuilder result = new StringBuilder();
    for (char c : stack) {
      result.append(c);
    }
    return result.toString();
  }
  
  public static void main(String[] args) {
    // 테스트 코드
    
    // 테스트 케이스 1
    String s1 = "tree";
    String s2 = "th#ree";
    System.out.println("Test 1: " + stringCompare(s1, s2));  // 예상 결과: true
    
    // 테스트 케이스 2
    s1 = "ab#a";
    s2 = "aab#";
    System.out.println("Test 2: " + stringCompare(s1, s2));  // 예상 결과: true
    
    // 테스트 케이스 3
    s1 = "wo#w";
    s2 = "ww#o";
    System.out.println("Test 3: " + stringCompare(s1, s2));  // 예상 결과: false
  }
}