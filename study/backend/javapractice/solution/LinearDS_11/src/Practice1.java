import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

public class Practice1 {
    public static void reorderData(int[] arr) {
        // ArrayDeque를 사용: 양끝에서 요소를 추가/제거할 수 있어 효율적
        // Deque 인터페이스를 구현하여 더 일반적인 코드 작성 가능
        // Deque<Integer> 사용: 
        // - Deque 인터페이스를 사용하여 더 유연한 코드를 작성할 수 있습니다.
        // - ArrayDeque는 양끝에서의 추가/제거 연산이 O(1) 시간 복잡도를 가져 효율적입니다.
        Deque<Integer> deque = new ArrayDeque<>();

        // ArrayList 사용: 동적 크기 조절이 가능하여 결과 저장에 적합
        // ArrayList<Integer> 사용:
        // - 동적으로 크기가 조절되는 ArrayList를 사용하여 결과를 저장합니다.
        // - 최종 크기를 미리 알 수 없기 때문에 ArrayList가 적합합니다.
        ArrayList<Integer> result = new ArrayList<>();

        // IntStream 사용: 함수형 프로그래밍 스타일로 배열의 모든 요소를 처리
        // arr 배열의 모든 요소를 deque의 끝에 추가
        // IntStream.of(arr).forEach() 사용:
        // - 함수형 프로그래밍 스타일을 사용하여 코드를 간결하게 만듭니다.
        // - 명시적인 for 루프보다 더 읽기 쉽고 의도를 명확히 전달합니다.
        IntStream.of(arr).forEach(x -> deque.addLast(x));

        // 현재 deque의 상태를 출력하여 초기 상태 확인
        System.out.println(deque);

        // deque가 비어있지 않은 동안 계속 처리
        // while 루프 사용:
        // - deque의 모든 요소를 처리할 때까지 반복합니다.
        // - 첫 번째와 마지막 요소를 번갈아 가며 제거하는 로직을 구현합니다.
        while (!deque.isEmpty()) {
            // deque의 첫 번째 요소를 제거하고 결과 리스트에 추가
            // 이는 D_0, D_1, ... 순서로 처리하기 위함
            // deque.removeFirst() 사용:
            // - deque의 앞쪽에서 요소를 제거하고 결과에 추가합니다.
            // - 이는 D_0, D_1, ... 순서로 처리하기 위함입니다.
            result.add(deque.removeFirst());

            // deque에 요소가 남아있다면
            if (!deque.isEmpty()) {
                // deque의 마지막 요소를 제거하고 결과 리스트에 추가
                // 이는 D_n, D_n-1, ... 순서로 처리하기 위함
                // deque.removeLast() 사용:
                // - deque의 뒤쪽에서 요소를 제거하고 결과에 추가합니다.
                // - 이는 D_n, D_n-1, ... 순서로 처리하기 위함입니다.
                // - if 문을 사용하여 deque가 비어있지 않은 경우에만 실행합니다.
                result.add(deque.removeLast());
            }
        }

        // 정렬 전후 비교를 위해 원본 데이터 출력
        System.out.println("== 정렬 전 ==");
        printData(arr);

        // 재정렬된 데이터 출력
        System.out.println("== 정렬 후 ==");
        // ArrayList를 int 배열로 변환
        // stream()을 사용하여 ArrayList를 스트림으로 변환
        // mapToInt()를 사용하여 Integer를 int로 변환
        // toArray()를 사용하여 최종적으로 int 배열로 변환
        // result.stream().mapToInt().toArray() 사용:
        // - ArrayList를 int 배열로 변환하여 printData 메소드에 전달합니다.
        // - stream()과 mapToInt()를 사용하여 Integer를 int로 변환하고, 최종적으로 배열로 만듭니다.
        printData(result.stream().mapToInt(x -> (int)x).toArray());
    }

    // 배열을 화살표로 연결된 형태로 출력하는 메소드
    // printData() 메소드:
    // - 배열을 시각적으로 이해하기 쉽게 출력하는 유틸리티 메소드입니다.
    // - 화살표를 사용하여 연결 리스트와 유사한 형태로 출력합니다.
    public static void printData(int[] arr) {
        // 마지막 요소를 제외한 모든 요소에 대해 반복
        for (int i = 0; i < arr.length - 1; i++) {
            // 요소와 화살표를 출력
            System.out.print(arr[i] + " -> ");
        }
        // 마지막 요소는 화살표 없이 출력하고 줄바꿈
        System.out.println(arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        // 테스트 코드
        // 5개 요소를 가진 배열로 테스트
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);   // 예상 출력: 1 -> 5 -> 2 -> 4 -> 3

        // 7개 요소를 가진 배열로 추가 테스트
        // 홀수 개수의 요소에 대해서도 알고리즘이 정상 작동하는지 확인
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);  // 예상 출력: 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4
    }
}