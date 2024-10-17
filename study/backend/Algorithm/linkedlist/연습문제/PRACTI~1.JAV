// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1
// 단방향 연결 리스트에서 중복 데이터를 찾아 삭제하세요.

// 입출력 예시)
// 입력 연결 리스트: 1, 3, 3, 1, 4, 2, 4, 2
// 결과 연결 리스트: 1, 3, 4, 2


class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node {
    int data;
    study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node next;

    study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node() {}
    study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(int data, study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node next) {
        this.data = data;
        this.next = next;
    }
}

class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList {
    study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node head;

    study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList() {}
    study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList(study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node node) {
        this.head = node;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(int data) {
        if (this.head == null) {
            this.head = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(data, null);
        } else {
            study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node(data, null);
        }
    }

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

    public boolean findData(int data) {
        if (this.isEmpty()) {
//            System.out.println("List is empty");
            return false;
        }

        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
//                System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
//        System.out.println("Data not found!");
        return false;
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}


public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1 {
    public static study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList removeDup(study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList listBefore) {
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList listAfter = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList();

        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur = listBefore.head;
        while (cur != null) {
            if (listAfter.findData(cur.data) == false) {
                listAfter.addData(cur.data);
            }

            cur = cur.next;
        }

        return listAfter;
    }

    public static void main(String[] args) {
        // Test code
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList linkedList = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.showData();  // 1 3 3 1 4 2 4 2

        linkedList = removeDup(linkedList);
        linkedList.showData();  // 1 3 4 2

    }
}
