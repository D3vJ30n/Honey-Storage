// Practice1
// ArrayList 를 이용한 스택 구현

import java.util.ArrayList;  // ArrayList 클래스를 사용하기 위한 import

class MyStack1 {
    ArrayList list;  // 스택의 데이터를 저장할 ArrayList 선언

    MyStack1() {
        this.list = new ArrayList();  // 생성자에서 ArrayList 초기화
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {  // ArrayList의 크기가 0이면 스택이 비어있음
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);  // ArrayList의 끝에 데이터 추가 (스택의 top에 해당)
    }

    public Integer pop() {
        if (this.isEmpty()) {  // 스택이 비어있는지 확인
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int)this.list.get(this.list.size() - 1);  // ArrayList의 마지막 요소 가져오기
        this.list.remove(this.list.size() - 1);  // ArrayList의 마지막 요소 제거
        return data;  // 제거된 데이터 반환
    }

    public Integer peek() {
        if (this.isEmpty()) {  // 스택이 비어있는지 확인
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int)this.list.get(this.list.size() - 1);  // ArrayList의 마지막 요소 가져오기
        return data;  // 마지막 요소 반환 (제거하지 않음)
    }

    public void printStack() {
        System.out.println(this.list);  // ArrayList 전체 출력 (스택의 bottom부터 top까지)
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyStack1 myStack = new MyStack1();  // MyStack1 객체 생성
        myStack.isEmpty();  // 스택이 비어있는지 확인 (결과 출력되지 않음)
        myStack.push(1);  // 스택에 1 추가
        myStack.push(2);  // 스택에 2 추가
        myStack.push(3);  // 스택에 3 추가
        myStack.push(4);  // 스택에 4 추가
        myStack.push(5);  // 스택에 5 추가
        myStack.printStack();               // [1, 2, 3, 4, 5] 출력

        System.out.println(myStack.peek()); // 5 출력 (스택의 top)
        myStack.printStack();               // [1, 2, 3, 4, 5] 출력 (peek 후 변화 없음)

        System.out.println(myStack.pop());  // 5 출력 및 제거
        System.out.println(myStack.pop());  // 4 출력 및 제거
        myStack.printStack();               // [1, 2, 3] 출력

        System.out.println(myStack.pop());  // 3 출력 및 제거
        System.out.println(myStack.pop());  // 2 출력 및 제거
        System.out.println(myStack.pop());  // 1 출력 및 제거
        myStack.printStack();               // [] 출력 (빈 스택)
    }
}