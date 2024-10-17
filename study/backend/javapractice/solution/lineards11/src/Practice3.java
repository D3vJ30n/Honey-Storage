package study.backend.javapractice.solution.lineards11.src;

class MyDeque {
    // 데크를 구현할 배열
    // int[] 사용 이유: 기본 데이터 타입으로 메모리 효율성이 좋고, 접근 속도가 빠름
    // 단점: 크기가 고정되어 동적 확장이 어려움
    int[] arr;

    // 데크의 앞쪽을 가리키는 인덱스
    // int 사용 이유: 배열 인덱스는 정수이며, 양수만 사용하므로 int가 적합
    // 초기값 0: 배열의 시작 위치를 가리킴. 실제 첫 번째 요소는 (front + 1) % arr.length에 위치
    int front = 0;

    // 데크의 뒤쪽을 가리키는 인덱스
    // int 사용 이유: front와 동일한 이유
    // 초기값 0: 비어있는 상태를 나타냄. front와 rear가 같으면 비어있는 상태
    int rear = 0;

    // 생성자: 주어진 크기보다 1 큰 배열을 생성
    // 매개변수 int size: 사용자가 원하는 데크의 크기
    // size + 1을 사용하는 이유: 
    // 1. 원형 큐에서 가득 찬 상태와 빈 상태를 구분하기 위해 한 칸을 비워둠
    // 2. 이렇게 하면 실제 저장 가능한 요소 수는 size와 일치하게 됨
    MyDeque(int size) {
        this.arr = new int[size + 1];
    }

    // 데크가 비어있는지 확인
    // boolean 반환 이유: 비어있음/아님의 두 가지 상태만 존재하므로
    // rear == front 조건 사용 이유: 
    // 1. 원형 큐에서 rear와 front가 같으면 비어있는 상태
    // 2. 단, 이는 한 칸을 항상 비워두는 구현 방식이기에 가능
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    // 데크가 가득 찼는지 확인
    // boolean 반환 이유: 가득 참/아님의 두 가지 상태만 존재하므로
    // (rear + 1) % arr.length == front 조건 사용 이유:
    // 1. rear 다음 위치가 front와 같으면 가득 찬 상태
    // 2. 모듈로 연산(%)을 사용하여 배열의 끝에서 처음으로 순환하는 원형 구조 구현
    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    // 데크의 앞쪽에 데이터 추가
    // void 반환 이유: 단순 삽입 연산으로, 별도의 반환값이 필요 없음
    // 매개변수 int data: 삽입할 정수 데이터
    public void addFirst(int data) {
        // 가득 찼는지 먼저 확인
        if (this.isFull()) {
            System.out.println("Deque is full!");
            return;
        }

        // 현재 front 위치에 데이터 저장
        this.arr[front] = data;
        // front를 왼쪽으로 이동 (원형 구조를 고려하여 모듈로 연산 사용)
        // (this.front - 1 + this.arr.length) % this.arr.length 연산 설명:
        // 1. this.front - 1: front를 왼쪽으로 한 칸 이동
        // 2. + this.arr.length: 음수가 되는 것을 방지 (Java의 음수 모듈로 연산 처리 방식 때문)
        // 3. % this.arr.length: 배열 범위 내에서 순환하도록 함
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    // 데크의 뒤쪽에 데이터 추가
    // void 반환 이유: 단순 삽입 연산으로, 별도의 반환값이 필요 없음
    // 매개변수 int data: 삽입할 정수 데이터
    public void addLast(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full!");
            return;
        }

        // rear를 오른쪽으로 이동 후 데이터 저장
        // (this.rear + 1) % this.arr.length 연산 설명:
        // 1. this.rear + 1: rear를 오른쪽으로 한 칸 이동
        // 2. % this.arr.length: 배열 끝에 도달했을 때 처음으로 돌아가도록 함
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    // 데크의 중간에 데이터 추가 (핵심 기능)
    // void 반환 이유: 단순 삽입 연산으로, 별도의 반환값이 필요 없음
    // 매개변수 int data: 삽입할 정수 데이터
    public void addMiddle(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full!");
            return;
        }

        // 현재 데크에 있는 원소 수 계산
        int elements = this.rear - this.front;
        // 원형 구조에서 rear가 front보다 앞에 있는 경우 처리
        // 이 경우, elements가 음수가 되므로 전체 길이를 더해 보정
        if (elements < 0) {
            elements = this.arr.length + elements;
        }

        // 중간 지점 계산
        // (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1 연산 설명:
        // 1. this.rear - elements / 2: rear에서 원소 수의 절반만큼 뒤로 이동
        // 2. + this.arr.length: 음수가 되는 것을 방지
        // 3. % this.arr.length: 배열 범위 내에서 순환하도록 함
        // 4. + 1: 실제 삽입 위치는 계산된 중간 지점의 바로 다음 칸
        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;

        // 중간 지점부터 rear까지의 원소들을 한 칸씩 뒤로 이동
        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;
        for (int i = start; i != end; i = (i - 1 + this.arr.length) % this.arr.length) {
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }

        // 중간 지점에 새 데이터 삽입
        this.arr[mid] = data;
        // rear를 한 칸 뒤로 이동
        this.rear = (this.rear + 1) % this.arr.length;
    }

    // 데크의 앞쪽에서 데이터 제거
    // Integer 반환 이유: 
    // 1. 제거된 데이터를 반환하기 위해
    // 2. null을 반환할 수 있어야 하므로 int(기본형)이 아닌 Integer(참조형) 사용
    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        // front를 오른쪽으로 이동 후 해당 위치의 데이터 반환
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    // 데크의 뒤쪽에서 데이터 제거
    // Integer 반환 이유: removeFirst()와 동일
    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        // 현재 rear 위치의 데이터 저장
        int data = this.arr[this.rear];
        // rear를 왼쪽으로 이동
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    // 데크의 현재 상태 출력
    // void 반환 이유: 단순 출력 연산으로, 별도의 반환값이 필요 없음
    public void printDeque() {
        // front 다음 위치부터 시작 (front는 항상 비어있음)
        int start = (this.front + 1) % this.arr.length;
        // rear 다음 위치까지 출력 (rear까지 포함)
        int end = (this.rear + 1) % this.arr.length;

        // 원형 구조를 고려하여 모든 요소 출력
        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();  // 줄바꿈으로 출력 완료
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // 테스트 코드
        // MyDeque 객체 생성, 크기 5 지정 (실제 내부 배열 크기는 6)
        MyDeque myDeque1 = new MyDeque(5);

        // addLast를 사용하여 1, 2, 3, 4를 차례로 추가
        myDeque1.addLast(1);
        myDeque1.addLast(2);
        myDeque1.addLast(3);
        myDeque1.addLast(4);

        // 현재 데크 상태 출력 (예상: 1 2 3 4)
        myDeque1.printDeque();

        // 데크 중간에 10 추가
        myDeque1.addMiddle(10);

        // 변경된 데크 상태 출력 (예상: 1 2 10 3 4)
        myDeque1.printDeque();

        // 새로운 MyDeque 객체 생성
        MyDeque myDeque2 = new MyDeque(5);

        // addLast를 사용하여 10을 5번 추가 (데크를 가득 채움)
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);

        // removeFirst를 사용하여 앞에서 4개 제거
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();

        // addLast를 사용하여 11, 12, 13 추가
        myDeque2.addLast(11);
        myDeque2.addLast(12);
        myDeque2.addLast(13);

        // 현재 데크 상태 출력 (예상: 10 11 12 13)
        myDeque2.printDeque();

        // 데크 중간에 100 추가
        myDeque2.addMiddle(100);

        // 최종 데크 상태 출력 (예상: 10 11 100 12 13)
        myDeque2.printDeque();
    }
}