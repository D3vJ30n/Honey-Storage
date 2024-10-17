// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3
// 원형 연결 리스트 (Circular Linked List) 구현

// study.backend.javapractice.solution.lineards04.src.NodeBi 클래스는 별도로 정의되어 있다고 가정합니다.
// NodeBi는 양방향 노드로, data, next, prev를 가집니다.

class study.backend.javapractice.solution.lineards04.src.CircularLinkedList {
    study.backend.javapractice.solution.lineards04.src.NodeBi head; // 리스트의 첫 번째 노드를 가리키는 포인터
    study.backend.javapractice.solution.lineards04.src.NodeBi tail; // 리스트의 마지막 노드를 가리키는 포인터

    // 생성자: 첫 노드로 리스트 초기화
    study.backend.javapractice.solution.lineards04.src.CircularLinkedList(study.backend.javapractice.solution.lineards04.src.NodeBi node) {
        this.head = node; // 첫 번째 노드를 head로 설정
        this.tail = node; // 첫 번째 노드를 tail로도 설정 (리스트에 노드가 하나뿐이므로)
        node.next = this.head; // 다음 노드를 자기 자신으로 설정 (원형 구조)
        node.prev = this.head; // 이전 노드도 자기 자신으로 설정 (원형 구조)
    }

    // 리스트가 비어있는지 확인하는 메소드
    public boolean isEmpty() {
        if (this.head == null) { // head가 null이면 리스트가 비어있음
            return true;
        }
        return false;
    }

    // 연결 리스트에 데이터 추가
    // before_data가 null인 경우, 가장 뒤에 추가
    // before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            // 리스트가 비어있는 경우
            study.backend.javapractice.solution.lineards04.src.NodeBi newNodeBi = new study.backend.javapractice.solution.lineards04.src.NodeBi(data, null, null); // 새 노드 생성
            this.head = newNodeBi; // 새 노드를 head로 설정
            this.tail = newNodeBi; // 새 노드를 tail로도 설정
            newNodeBi.next = newNodeBi; // 다음 노드를 자기 자신으로 설정 (원형)
            newNodeBi.prev = newNodeBi; // 이전 노드를 자기 자신으로 설정 (원형)
        } else if (beforeData == null) {
            // 가장 뒤에 추가하는 경우
            study.backend.javapractice.solution.lineards04.src.NodeBi newNodeBi = new study.backend.javapractice.solution.lineards04.src.NodeBi(data, this.head, this.tail); // 새 노드 생성
            this.tail.next = newNodeBi; // 기존 tail의 next를 새 노드로 설정
            this.head.prev = newNodeBi; // head의 prev를 새 노드로 설정
            this.tail = newNodeBi; // 새 노드를 새로운 tail로 설정
        } else {
            // 특정 노드 앞에 추가하는 경우
            study.backend.javapractice.solution.lineards04.src.NodeBi cur = this.head;
            study.backend.javapractice.solution.lineards04.src.NodeBi pre = cur;
            do {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        // 첫 번째 노드 앞에 추가하는 경우
                        study.backend.javapractice.solution.lineards04.src.NodeBi newNodeBi = new study.backend.javapractice.solution.lineards04.src.NodeBi(data, this.head, this.tail);
                        this.tail.next = newNodeBi; // 기존 tail의 next를 새 노드로 설정
                        this.head.prev = newNodeBi; // 기존 head의 prev를 새 노드로 설정
                        this.head = newNodeBi; // 새 노드를 새로운 head로 설정
                    } else {
                        // 중간에 추가하는 경우
                        study.backend.javapractice.solution.lineards04.src.NodeBi newNodeBi = new study.backend.javapractice.solution.lineards04.src.NodeBi(data, cur, pre);
                        pre.next = newNodeBi; // 이전 노드의 next를 새 노드로 설정
                        cur.prev = newNodeBi; // 현재 노드의 prev를 새 노드로 설정
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while (cur != this.head); // 원형 리스트를 한 바퀴 돌 때까지 반복
        }
    }

    // 연결 리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        study.backend.javapractice.solution.lineards04.src.NodeBi cur = this.head;
        study.backend.javapractice.solution.lineards04.src.NodeBi pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    // 리스트에 노드가 하나만 있는 경우
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    // 첫 번째 노드를 삭제하는 경우
                    cur.next.prev = this.head.prev; // 두 번째 노드의 prev를 마지막 노드로 설정
                    this.head = cur.next; // 두 번째 노드를 새로운 head로 설정
                    this.tail.next = this.head; // 마지막 노드의 next를 새로운 head로 설정
                } else if (cur == this.tail) {
                    // 마지막 노드를 삭제하는 경우
                    pre.next = this.tail.next; // 이전 노드의 next를 첫 번째 노드로 설정
                    this.tail = pre; // 이전 노드를 새로운 tail로 설정
                    this.head.prev = this.tail; // 첫 번째 노드의 prev를 새로운 tail로 설정
                } else {
                    // 중간 노드를 삭제하는 경우
                    pre.next = cur.next; // 이전 노드의 next를 현재 노드의 다음 노드로 설정
                    cur.next.prev = pre; // 다음 노드의 prev를 이전 노드로 설정
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    // 리스트의 모든 데이터를 출력하는 메소드
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        study.backend.javapractice.solution.lineards04.src.NodeBi cur = this.head;
        while (cur.next != this.head) {
            System.out.print(cur.data + " "); // 현재 노드의 데이터 출력
            cur = cur.next; // 다음 노드로 이동
        }
        System.out.println(cur.data); // 마지막 노드 출력
    }
}

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3 {
    public static void main(String[] args) {
        // 테스트 코드
        study.backend.javapractice.solution.lineards04.src.CircularLinkedList myList = new study.backend.javapractice.solution.lineards04.src.CircularLinkedList(new study.backend.javapractice.solution.lineards04.src.NodeBi(1, null, null));
        myList.addData(2, null); // 2를 리스트 끝에 추가
        myList.addData(3, null); // 3을 리스트 끝에 추가
        myList.addData(4, null); // 4를 리스트 끝에 추가
        myList.addData(5, null); // 5를 리스트 끝에 추가
        myList.showData();  // 1 2 3 4 5 출력

        myList.addData(100, 1); // 100을 1 앞에 추가
        myList.addData(200, 2); // 200을 2 앞에 추가
        myList.addData(300, 3); // 300을 3 앞에 추가
        myList.addData(400, 4); // 400을 4 앞에 추가
        myList.addData(500, 5); // 500을 5 앞에 추가
        myList.showData();  // 100 1 200 2 300 3 400 4 500 5 출력

        myList.removeData(300); // 300 삭제
        myList.removeData(100); // 100 삭제
        myList.removeData(500); // 500 삭제
        myList.removeData(200); // 200 삭제
        myList.removeData(400); // 400 삭제
        myList.showData();      // 1 2 3 4 5 출력

        myList.removeData(3); // 3 삭제
        myList.removeData(1); // 1 삭제
        myList.removeData(5); // 5 삭제
        myList.removeData(2); // 2 삭제
        myList.removeData(4); // 4 삭제
        myList.showData();    // "List is empty!" 출력
    }
}