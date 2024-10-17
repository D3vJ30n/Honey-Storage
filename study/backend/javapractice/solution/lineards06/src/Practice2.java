package study.backend.javapractice.solution.lineards06.src;// Practice2
// 배열을 이용한 기본 스택 직접 구현

class MyStack2 {
    int[] arr;  // 스택의 데이터를 저장할 정수 배열 선언
    int top = -1;  // 스택의 top 위치를 나타내는 인덱스. -1은 빈 스택을 의미

    // 생성자: 지정된 크기의 배열을 생성
    MyStack2(int size) {
        arr = new int[size];  // 매개변수 size 크기의 새 정수 배열 생성
    }

    // 스택이 비어있는지 확인하는 메소드
    public boolean isEmpty() {
        if (this.top == -1) {  // top이 -1이면 스택이 비어있음
            return true;
        } else {
            return false;
        }
    }

    // 스택이 가득 찼는지 확인하는 메소드
    public boolean isFull() {
        if (this.top == this.arr.length - 1) {  // top이 배열의 마지막 인덱스와 같으면 스택이 가득 참
            return true;
        } else {
            return false;
        }
    }

    // 스택에 데이터를 추가하는 메소드
    public void push(int data) {
        if (this.isFull()) {  // 스택이 가득 찼는지 확인
            System.out.println("Stack is full!");
            return;
        }

        this.top += 1;  // top 인덱스를 1 증가
        this.arr[this.top] = data;  // 새 데이터를 증가된 top 위치에 저장
    }

    // 스택에서 데이터를 제거하고 반환하는 메소드
    public Integer pop() {
        if (this.isEmpty()) {  // 스택이 비어있는지 확인
            System.out.println("Stack is empty!");
            return null;
        }

        int data = this.arr[this.top];  // top 위치의 데이터를 임시 변수에 저장
        this.top -= 1;  // top 인덱스를 1 감소

        return data;  // 저장해둔 데이터 반환
    }

    // 스택의 top 데이터를 반환하는 메소드 (제거하지 않음)
    public Integer peek() {
        if (this.isEmpty()) {  // 스택이 비어있는지 확인
            System.out.println("Stack is empty!");
            return null;
        }

        return this.arr[this.top];  // top 위치의 데이터를 반환
    }

    // 스택의 모든 데이터를 출력하는 메소드
    public void printStack() {
        for (int i = 0; i <= this.top; i++) {  // 0부터 top까지 순회
            System.out.print(this.arr[i] + " ");  // 각 요소를 공백으로 구분하여 출력
        }
        System.out.println();  // 줄바꿈
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyStack2 myStack = new MyStack2(5);  // 크기가 5인 MyStack2 객체 생성
        myStack.isEmpty();  // 스택이 비어있는지 확인 (결과 출력되지 않음)
        myStack.push(1);  // 스택에 1 추가
        myStack.push(2);  // 스택에 2 추가
        myStack.push(3);  // 스택에 3 추가
        myStack.push(4);  // 스택에 4 추가
        myStack.push(5);  // 스택에 5 추가
        myStack.push(6);  // 스택이 가득 찼으므로 "Stack is full!" 출력
        myStack.printStack();  // 스택의 모든 요소 출력: 1 2 3 4 5

        System.out.println(myStack.peek());  // top 요소 출력 (5)
        myStack.printStack();  // 스택의 모든 요소 출력: 1 2 3 4 5 (peek 후 변화 없음)

        System.out.println(myStack.pop());  // top 요소 제거 및 출력 (5)
        System.out.println(myStack.pop());  // 새로운 top 요소 제거 및 출력 (4)
        myStack.printStack();  // 남은 요소 출력: 1 2 3

        System.out.println(myStack.pop());  // 3 출력 및 제거
        System.out.println(myStack.pop());  // 2 출력 및 제거
        System.out.println(myStack.pop());  // 1 출력 및 제거
        myStack.printStack();  // 빈 스택이므로 아무것도 출력되지 않음
    }
}