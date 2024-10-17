package study.backend.javapractice.solution.lineards11.src;

class MyDeque2 {
    // 데크를 구현할 배열
    // int[] 사용 이유: 기본 데이터 타입으로 메모리 효율성이 좋고, 접근 속도가 빠름
    // 단점: 크기가 고정되어 있지만, increaseSize 메소드로 이를 해결함
    int[] arr;

    // 데크의 앞쪽을 가리키는 인덱스
    // 초기값 0: 배열의 시작 위치를 가리킴. 실제 첫 번째 요소는 (front + 1) % arr.length에 위치
    // int 사용 이유: 배열 인덱스는 정수이며, 양수만 사용하므로 int가 적합
    int front = 0;

    // 데크의 뒤쪽을 가리키는 인덱스
    // 초기값 0: 비어있는 상태를 나타냄. front와 rear가 같으면 비어있는 상태
    // int 사용 이유: front와 동일한 이유
    int rear = 0;

    // 생성자: 주어진 크기보다 1 큰 배열을 생성
    // 매개변수 int size: 사용자가 원하는 데크의 초기 크기
    // size + 1을 사용하는 이유: 
    // 1. 원형 큐에서 가득 찬 상태와 빈 상태를 구분하기 위해 한 칸을 비워둠
    // 2. 이렇게 하면 실제 저장 가능한 요소 수는 size와 일치하게 됨
    MyDeque2(int size) {
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

    // 데크의 크기를 2배로 증가시키는 메소드
    // 시간 복잡도: O(n), 여기서 n은 현재 데크에 저장된 요소의 수
    // 공간 복잡도: O(2n), 기존 배열의 2배 크기의 새 배열을 생성하므로
    public void increaseSize() {
        System.out.println("MyDeque2.increaseSize");
        // 현재 배열을 복제하여 임시 배열 생성
        // clone() 사용 이유: 새 배열에 데이터를 복사하기 전 원본 데이터를 보존하기 위해
        int[] arrTmp = this.arr.clone();
        // 새로운 배열을 현재 크기의 2배로 생성
        // 2배로 증가시키는 이유: 점진적으로 크기를 키워 잦은 재할당을 방지하기 위해
        this.arr = new int[this.arr.length * 2];

        // 원래 데크의 시작과 끝 인덱스 계산
        // 원형 구조에서 실제 데이터의 시작과 끝을 찾기 위해 필요
        int start = (this.front + 1) % arrTmp.length;
        int end = (this.rear + 1) % arrTmp.length;

        // 새 배열에 데이터 복사
        // 복사 과정에서 데이터를 재정렬하여 배열의 앞쪽부터 차례대로 저장
        int idx = 1;  // 새 배열의 인덱스 (0은 비워둠)
        for (int i = start; i != end; i = (i + 1) % arrTmp.length) {
            this.arr[idx++] = arrTmp[i];
        }

        // front와 rear 인덱스 재설정
        // 새 배열에서 데이터가 0번 인덱스 다음부터 시작하므로 front는 0으로 설정
        this.front = 0;
        this.rear = idx - 1;
    }

    // 데크의 앞쪽에 데이터 추가
    // 시간 복잡도: 대부분의 경우 O(1), 크기 증가 시 O(n)
    // 매개변수 int data: 추가할 정수 데이터
    public void addFirst(int data) {
        if (this.isFull()) {
            // 가득 찼을 경우 크기 증가
            // 크기를 늘리고 나면 반드시 빈 공간이 생기므로, 다시 isFull() 체크는 불필요
            this.increaseSize();
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
    // 시간 복잡도: 대부분의 경우 O(1), 크기 증가 시 O(n)
    // 매개변수 int data: 추가할 정수 데이터
    public void addLast(int data) {
        if (this.isFull()) {
            // 가득 찼을 경우 크기 증가
            this.increaseSize();
        }

        // rear를 오른쪽으로 이동 후 데이터 저장
        // (this.rear + 1) % this.arr.length 연산 설명:
        // 1. this.rear + 1: rear를 오른쪽으로 한 칸 이동
        // 2. % this.arr.length: 배열 끝에 도달했을 때 처음으로 돌아가도록 함
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    // 데크의 앞쪽에서 데이터 제거
    // 시간 복잡도: O(1)
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
    // 시간 복잡도: O(1)
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
    // 시간 복잡도: O(n), 여기서 n은 현재 데크에 저장된 요소의 수
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

public class Practice4 {
    public static void main(String[] args) {
        // 테스트 코드
        // MyDeque2 객체 생성, 크기 5 지정 (실제 내부 배열 크기는 6)
        MyDeque2 myDeque = new MyDeque2(5);

        // 데크에 1부터 5까지 추가
        // 이 과정에서 크기 증가는 일어나지 않음 (초기 크기로 충분)
        myDeque.addLast(1);
        myDeque.addLast(2);
        myDeque.addLast(3);
        myDeque.addLast(4);
        myDeque.addLast(5);
        myDeque.printDeque();  // 예상 출력: 1 2 3 4 5

        // 데크가 가득 찬 상태에서 추가 데이터 삽입 (자동으로 크기 증가)
        // 6을 추가할 때 처음으로 크기 증가가 발생
        myDeque.addLast(6);
        myDeque.addLast(7);
        myDeque.addLast(8);
        myDeque.addLast(9);
        myDeque.addLast(10);
        myDeque.printDeque();  // 예상 출력: 1 2 3 4 5 6 7 8 9 10

        // 뒤에서 두 개 제거 후 앞에 새로운 데이터 추가
        // 이 과정에서 크기 증가는 일어나지 않음 (이미 증가된 크기로 충분)
        myDeque.removeLast();
        myDeque.removeLast();
        myDeque.addFirst(100);
        myDeque.addFirst(200);
        myDeque.printDeque();  // 예상 출력: 200 100 1 2 3 4 5 6 7 8

        // 앞에 추가 데이터 삽입 (필요시 자동으로 크기 증가)
        // 이 과정에서 다시 한 번 크기 증가가 발생할 수 있음
        myDeque.addFirst(300);
        myDeque.addFirst(400);
        myDeque.addFirst(500);
        myDeque.printDeque();  // 예상 출력: 500 400 300 200 100 1 2 3 4 5 6 7 8
    }
}