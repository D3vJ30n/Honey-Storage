// Practice2
// Palindrome 연결 리스트
// 추가 자료구조 없이 연결 리스트만으로 풀어보기
// Palindrome: 앞으로 읽어도 뒤로 읽어도 같은 문자열

// 입력 예시)
// 입력 연결 리스트: 1, 3, 5, 3, 1
// 결과: true

// 입력 연결 리스트: 3, 5, 5, 3
// 결과: true

// 입력 연결 리스트: 1, 3, 5, 1
// 결과: false

// checkPalindrome 메소드는 주어진 연결 리스트가 팰린드롬인지 확인합니다. 팰린드롬이란 앞에서 읽으나 뒤에서 읽으나 같은 순서가 되는 구조를 말합니다.
// 알고리즘의 주요 로직

// 먼저 리스트의 길이를 계산하고 right 포인터를 마지막 노드로 설정합니다.
// 리스트의 절반까지만 비교합니다 (cnt / 2).
// left 포인터는 앞에서부터, right 포인터는 뒤에서부터 이동하면서 각 노드의 데이터를 비교합니다.
// right 포인터를 이동시키는 과정이 복잡한데, 이는 단일 연결 리스트에서 뒤로 이동할 수 없기 때문입니다. 
// 따라서 매번 left에서부터 시작해 right의 이전 위치까지 이동합니다.


// 시간 복잡도

// 이 알고리즘의 시간 복잡도는 O(n^2)입니다. 왜냐하면 매번 right 포인터를 이동시킬 때마다 리스트를 훑어야 하기 때문입니다.
// 더 효율적인 방법으로는 리스트의 중간까지 스택에 push하고, 나머지 절반을 pop하면서 비교하는 O(n) 알고리즘이 있습니다.


// main 메소드에서는 세 가지 다른 케이스로 checkPalindrome 메소드를 테스트합니다:

// 첫 번째와 두 번째 케이스는 팰린드롬입니다 (예상 출력: true).
// 세 번째 케이스는 팰린드롬이 아닙니다 (예상 출력: false).



// 이 코드는 팰린드롬 체크를 구현하는 한 가지 방법을 보여주지만, 앞서 언급한 대로 더 효율적인 알고리즘도 존재합니다. 
// 실제 사용 시에는 시간 복잡도를 고려하여 더 효율적인 알고리즘을 선택하는 것이 좋습니다.


public class Practice2 {
    // 주어진 연결 리스트가 팰린드롬인지 확인하는 메소드
    public static boolean checkPalindrome(LinkedList list) {
        Node cur = list.head;  // 현재 노드를 가리키는 포인터
        Node left = list.head; // 왼쪽에서 오른쪽으로 이동할 포인터
        Node right = null;     // 오른쪽 끝을 가리킬 포인터

        // 리스트의 길이를 계산하고 right를 마지막 노드로 설정
        int cnt = 0;
        while (cur != null) {
            cnt++;
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right; // 이전 right 위치를 저장할 변수

        // 리스트의 절반까지만 비교
        for (int i = 0; i < cnt / 2; i++) {
            // left와 right의 데이터가 다르면 팰린드롬이 아님
            if (left.data != right.data) {
                return false;
            }

            left = left.next; // left를 한 칸 오른쪽으로 이동

            // right를 왼쪽으로 이동시키는 과정
            right = left;
            while (right.next != prevRight) {
                right = right.next;
            }
            prevRight = right; // 새로운 right 위치 저장
        }

        // 모든 비교가 끝나면 팰린드롬임
        return true;
    }

    public static void main(String[] args) {
        // 테스트 코드
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(5);
        linkedList.addData(3);
        linkedList.addData(1);
        System.out.println(checkPalindrome(linkedList)); // 예상 출력: true

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(3);
        linkedList2.addData(5);
        linkedList2.addData(5);
        linkedList2.addData(3);
        System.out.println(checkPalindrome(linkedList2)); // 예상 출력: true

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addData(1);
        linkedList3.addData(3);
        linkedList3.addData(5);
        linkedList3.addData(1);
        System.out.println(checkPalindrome(linkedList3)); // 예상 출력: false
    }
}