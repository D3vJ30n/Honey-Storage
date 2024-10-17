// 선형 자료구조 - 스택

import java.util.Stack;  // Java의 Stack 클래스를 사용하기 위한 import

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();  // 새로운 Stack 객체 생성

        // 스택에 요소 추가 (push 연산)
        stack.push(1);  // 1을 스택에 추가
        stack.push(2);  // 2를 스택에 추가
        stack.push(3);  // 3을 스택에 추가
        stack.push(4);  // 4를 스택에 추가
        stack.push(5);  // 5를 스택에 추가
        System.out.println(stack);  // 스택의 현재 상태 출력: [1, 2, 3, 4, 5]

        System.out.println(stack.pop());  // 스택의 top 요소 제거 및 반환 (5)
        System.out.println(stack);  // pop 연산 후 스택 상태: [1, 2, 3, 4]

        System.out.println(stack.pop());  // 다시 top 요소 제거 및 반환 (4)
        System.out.println(stack);  // pop 연산 후 스택 상태: [1, 2, 3]

        System.out.println(stack.peek());  // top 요소 확인 (제거하지 않음) (3)
        System.out.println(stack);  // peek 연산 후 스택 상태 (변화 없음): [1, 2, 3]

        System.out.println(stack.contains(1));  // 스택에 1이 포함되어 있는지 확인 (true)
        System.out.println(stack.size());  // 스택의 현재 크기 출력 (3)
        System.out.println(stack.empty());  // 스택이 비어있는지 확인 (false)

        stack.clear();  // 스택의 모든 요소 제거
        System.out.println(stack);  // clear 연산 후 스택 상태: []
        System.out.println(stack.pop());  // 빈 스택에서 pop 시도 (EmptyStackException 발생)
    }
}