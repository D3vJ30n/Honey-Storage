// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3
// 연결 리스트 부분 뒤집기
// 주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드들을 뒤집으시오.

// 입력 예시)
// 입력 연결 리스트: 1, 2, 3, 4, 5
// 시작 위치: 2
// 끝 위치: 4
// (처음 위치는 1부터라고 가정)
// 결과 연결 리스트: 1, 4, 3, 2, 5


public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3 {
    public static study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList reverseList(study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList list, int left, int right) {
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur1 = null;
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node pre1 = null;

        cur1 = list.head;
        for (int i = 0; i < left - 1; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node cur2 = cur1;
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node pre2 = pre1;
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.Node after = null;
        for (int i = left; i <= right; i++) {
            after = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = after;
        }

        pre1.next = pre2;
        cur1.next = cur2;

        return list;
    }
    
    public static void main(String[] args) {
        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList linkedList = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(5);
        linkedList.showData();

        linkedList = reverseList(linkedList, 2, 4);
        linkedList.showData();


        study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList linkedList2 = new study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards12.src.LinkedList();
        linkedList2.addData(1);
        linkedList2.addData(2);
        linkedList2.addData(3);
        linkedList2.addData(4);
        linkedList2.addData(5);
        linkedList2.addData(6);
        linkedList2.addData(7);
        linkedList2.showData();

        linkedList2 = reverseList(linkedList2, 3, 5);
        linkedList2.showData();

    }
}
