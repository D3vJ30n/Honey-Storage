import java.util.*;

public class Main {
    public static int minOperations(int n, int m, int[] positions) {
        // ArrayList로 양방향 순환 큐 구현
        // 문제에서 요구하는 1부터 N까지의 원소를 가진 초기 큐 생성
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // i는 1부터 시작: 문제에서 큐의 원소가 1부터 n까지라고 명시
            // <= n 사용: n을 포함해야 하므로
            queue.add(i);
        }

        // 2번, 3번 연산의 총 횟수
        // 0으로 초기화: 연산 횟수를 누적할 것이므로 0부터 시작
        int totalOperations = 0;

        // positions 배열의 각 원소에 대해 처리
        // 문제: "지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다"
        for (int pos : positions) {
            // 현재 뽑아내려는 원소의 위치 찾기
            int index = queue.indexOf(pos);

            // 왼쪽으로 이동하는 것이 더 가까운 경우 (2번 연산)
            // queue.size() / 2: 큐의 중간 지점을 기준으로 왼쪽/오른쪽 이동 결정
            if (index <= queue.size() / 2) {
                totalOperations += index;
                // 실제로 큐를 회전시켜 다음 연산을 위한 상태 유지
                // 0부터 index 미만까지: index만큼 왼쪽으로 회전
                for (int i = 0; i < index; i++) {
                    queue.add(queue.remove(0));
                    // 0: 항상 첫 번째 원소를 제거하고 끝에 추가
                    // 문제의 2번 연산: "왼쪽으로 한 칸 이동시킨다"
                }
            } else { // 오른쪽으로 이동하는 것이 더 가까운 경우 (3번 연산)
                // queue.size() - index: 오른쪽으로 이동하는 횟수 계산
                totalOperations += queue.size() - index;
                // 실제로 큐를 회전시켜 다음 연산을 위한 상태 유지
                for (int i = 0; i < queue.size() - index; i++) {
                    queue.add(0, queue.remove(queue.size() - 1));
                    // 0: 첫 번째 위치에 추가, size() - 1: 마지막 원소의 인덱스
                    // 문제의 3번 연산: "오른쪽으로 한 칸 이동시킨다"
                }
            }

            // 1번 연산: 첫 번째 원소 뽑아내기
            // 이 연산의 횟수는 카운트하지 않음 (문제 요구사항)
            // 0: 항상 첫 번째 원소를 제거
            queue.remove(0);
            // 문제의 1번 연산: "첫 번째 원소를 뽑아낸다"
        }

        // 2번, 3번 연산의 최소 횟수 반환
        return totalOperations;
    }

    public static void main(String[] args) {
        // Scanner 객체를 생성하여 표준 입력을 받을 준비
        Scanner scanner = new Scanner(System.in);

        // 문제에서 주어진 입력 형식대로 데이터 읽기
        int n = scanner.nextInt(); // 큐의 크기 N
        int m = scanner.nextInt(); // 뽑아내려고 하는 수의 개수 M

        // m: 뽑아내려는 원소의 개수만큼 배열 크기 설정
        int[] positions = new int[m];
        // 0부터 m 미만까지: m개의 원소를 입력받기 위함
        for (int i = 0; i < m; i++) {
            positions[i] = scanner.nextInt();
        }

        // 2번, 3번 연산의 최소 횟수 계산 및 출력
        int result = minOperations(n, m, positions);
        System.out.println(result);

        scanner.close();
    }
}