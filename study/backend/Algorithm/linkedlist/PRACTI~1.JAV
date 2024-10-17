// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1
// 단순 연결 리스트 구현 완성

class study.backend.javapractice.solution.lineards04.src.LinkedList2 extends study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList {

    study.backend.javapractice.solution.lineards04.src.LinkedList2(study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node node) {
        this.head = node;
    }

    // 연결 리스트에 데이터 추가
    // before_data 가 null 인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(data, null);
        } else if (beforeData == null) {
            study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(data, null);
        } else {
            study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur = this.head;
            study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(data, this.head);
                    } else {
                        pre.next = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(data, cur);
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    //  연결 리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur = this.head;
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }
}

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1 {
    public static void main(String[] args) {

//      Test code
        study.backend.javapractice.solution.lineards04.src.LinkedList2 myList = new study.backend.javapractice.solution.lineards04.src.LinkedList2(new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(1, null));
        myList.showData();         // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();         // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();         // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();         // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();         // List is empty!
    }
}
