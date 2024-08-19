import java.util.*;

public class DS1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // 순열의 길이 N 입력 받기
    int N = scanner.nextInt();
    
    // 순열 A 입력 받기
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = scanner.nextInt();
    }
    
    // 순열 청소 가능 여부 판단 및 결과 출력
    System.out.println(canCleanPermutation(A) ? "YES" : "NO");
  }
  
  public static boolean canCleanPermutation(int[] A) {
    // 4개의 스택 생성
    Stack<Integer>[] stacks = new Stack[4];
    for (int i = 0; i < 4; i++) {
      stacks[i] = new Stack<>();
    }
    
    // 다음에 꺼내야 할 숫자 (오름차순 정렬을 위한 기준)
    int next = 1;
    
    // 순열의 원소를 순서대로 처리
    for (int num : A) {
      boolean inserted = false;
      
      // 현재 숫자를 삽입할 수 있는 적절한 스택 찾기
      for (Stack<Integer> stack : stacks) {
        // 스택이 비어있거나, 스택의 top보다 현재 숫자가 작은 경우 삽입 가능
        if (stack.isEmpty() || num < stack.peek()) {
          stack.push(num);
          inserted = true;
          break;
        }
      }
      
      // 삽입할 수 있는 스택이 없으면 정렬 불가능
      if (!inserted) {
        return false;
      }
      
      // 현재 꺼낼 수 있는 숫자들 모두 꺼내기
      while (true) {
        boolean popped = false;
        for (Stack<Integer> stack : stacks) {
          // 스택의 top이 현재 꺼내야 할 숫자와 일치하면 꺼내기
          if (!stack.isEmpty() && stack.peek() == next) {
            stack.pop();
            next++;
            popped = true;
            break;
          }
        }
        // 더 이상 꺼낼 수 있는 숫자가 없으면 반복 종료
        if (!popped) break;
      }
    }
    
    // 모든 숫자를 꺼냈는지 확인 (next가 A.length보다 크면 모든 숫자를 꺼낸 것)
    return next > A.length;
  }
}