// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 (simple ver.) 기본 구조 구현

// 노드
// Node 클래스: 연결 리스트의 각 요소를 나타냄
class Node {
    int data;    // 노드에 저장될 정수형 데이터
    Node next;   // 다음 노드를 가리키는 참조. null이면 마지막 노드를 의미함

    // 기본 생성자: 아무 초기화 없이 노드 객체를 생성
    Node() {}

    // 매개변수가 있는 생성자: 데이터와 다음 노드 참조를 받아 노드 초기화
    Node(int data, Node next) {
        this.data = data;   // 입력받은 데이터를 노드의 data 필드에 저장
        this.next = next;   // 입력받은 다음 노드 참조를 next 필드에 저장
    }
}

// LinkedList 클래스: 연결 리스트 자체를 구현
class LinkedList {
    Node head;   // 리스트의 첫 번째 노드를 가리키는 참조. null이면 빈 리스트를 의미함

    // 기본 생성자: 빈 리스트 생성
    LinkedList() {}

    // 매개변수가 있는 생성자: 첫 번째 노드를 받아 리스트 초기화
    LinkedList(Node node) {
        this.head = node;   // 입력받은 노드를 리스트의 head로 설정
    }

    // 연결 리스트가 비어있는지 확인하는 메소드
    public boolean isEmpty() {
        if (this.head == null) {    // head가 null이면
            return true;            // 리스트가 비어있으므로 true 반환
        }
        return false;               // 그렇지 않으면 false 반환
    }

    // 연결 리스트의 맨 뒤에 새 데이터를 추가하는 메소드
    public void addData(int data) {
        if (this.head == null) {    // 리스트가 비어있으면
            this.head = new Node(data, null);   // 새 노드를 생성하여 head로 설정
        } else {
            Node cur = this.head;   // 현재 노드를 가리키는 포인터 초기화
            while (cur.next != null) {  // 마지막 노드를 찾을 때까지 반복
                cur = cur.next;     // 다음 노드로 이동
            }
            cur.next = new Node(data, null);    // 마지막 노드의 다음으로 새 노드 추가
        }
    }

    // 연결 리스트의 맨 뒤 데이터를 삭제하는 메소드
    public void removeData() {
        if (this.isEmpty()) {   // 리스트가 비어있으면
            System.out.println("List is empty");
            return;     // 메소드 종료
        }

        Node cur = this.head;   // 현재 노드를 가리키는 포인터
        Node prev = cur;        // 이전 노드를 가리키는 포인터

        while (cur.next != null) {  // 마지막 노드를 찾을 때까지 반복
            prev = cur;     // 이전 노드 업데이트
            cur = cur.next; // 다음 노드로 이동
        }

        if (cur == this.head) {     // 노드가 하나뿐이면
            this.head = null;       // head를 null로 설정하여 리스트를 비움
        } else {
            prev.next = null;       // 마지막에서 두 번째 노드의 next를 null로 설정
        }
    }

    // 연결 리스트에서 특정 데이터를 찾는 메소드
    public void findData(int data) {
        if (this.isEmpty()) {   // 리스트가 비어있으면
            System.out.println("List is empty");
            return;     // 메소드 종료
        }

        Node cur = this.head;   // 현재 노드를 가리키는 포인터 초기화
        while (cur != null) {   // 리스트의 끝까지 반복
            if (cur.data == data) { // 현재 노드의 데이터가 찾는 데이터와 일치하면
                System.out.println("Data exist!");
                return;     // 메소드 종료
            }
            cur = cur.next; // 다음 노드로 이동
        }
        System.out.println("Data not found!");   // 데이터를 찾지 못한 경우
    }

    // 연결 리스트의 모든 데이터를 출력하는 메소드
    public void showData() {
        if (this.isEmpty()) {   // 리스트가 비어있으면
            System.out.println("List is empty!");
            return;     // 메소드 종료
        }

        Node cur = this.head;   // 현재 노드를 가리키는 포인터 초기화
        while (cur != null) {   // 리스트의 끝까지 반복
            System.out.print(cur.data + " ");    // 현재 노드의 데이터 출력
            cur = cur.next;     // 다음 노드로 이동
        }
        System.out.println();   // 줄바꿈
    }
}

// 메인 클래스: 연결 리스트를 테스트하는 코드 포함
public class peacticecodingtest.Main {
    public static void main(String[] args) {
        // 테스트 코드
        LinkedList myList = new LinkedList(new Node(1, null));   // 1을 포함한 새 리스트 생성
        myList.showData();      // 출력: 1

        myList.addData(2);  // 2 추가
        myList.addData(3);  // 3 추가
        myList.addData(4);  // 4 추가
        myList.addData(5);  // 5 추가
        myList.showData();      // 출력: 1 2 3 4 5

        myList.findData(3);     // 3을 찾음, 출력: Data exist!
        myList.findData(100);   // 100을 찾음, 출력: Data not found!

        myList.removeData();    // 마지막 노드(5) 제거
        myList.removeData();    // 마지막 노드(4) 제거
        myList.removeData();    // 마지막 노드(3) 제거
        myList.showData();      // 출력: 1 2

        myList.removeData();    // 마지막 노드(2) 제거
        myList.removeData();    // 마지막 노드(1) 제거
        myList.removeData();    // 빈 리스트에서 제거 시도, 출력: List is empty
    }
}