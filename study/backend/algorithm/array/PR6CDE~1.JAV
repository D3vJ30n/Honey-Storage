// study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice5
// 배열 arr의 값을 오름차순으로 출력하는 프로그램

// 입출력 예시)
// arr: 5, 3, 1, 4, 6, 1
// 결과: 1, 1, 3, 4, 5, 6

public class study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice5 {
    public static void main(String[] args) {
        // 정렬할 배열 선언 및 초기화
        // 이 배열은 정렬되지 않은 상태의 정수들을 포함하고 있음
        int[] arr = {5, 3, 1, 4, 6, 1}; // 정렬 후 예상 결과: 1, 1, 3, 4, 5, 6
        
        // 방문 여부를 체크할 배열 선언 (0: 미방문, 1: 방문)
        // arr 배열과 같은 길이로 생성되며, 각 요소의 방문 상태를 추적함
        int[] visited = new int[arr.length];
        
        // 방문한 요소의 개수를 카운트
        // 이 변수로 모든 요소를 방문했는지 확인함
        int visitCnt = 0;
        
        // 현재까지 찾은 최소값을 저장 (초기값: 정수의 최대값)
        // Integer.MAX_VALUE를 사용하여 어떤 배열 요소보다 큰 값으로 초기화
        int minVal = Integer.MAX_VALUE;
        
        // 현재까지 찾은 최소값의 인덱스를 저장
        // -1로 초기화하여 아직 최소값을 찾지 않았음을 표시
        int minIdx = -1;

        // 모든 요소를 방문할 때까지 반복
        // visitCnt가 배열 길이와 같아지면 모든 요소를 방문한 것
        while (visitCnt < arr.length) {
            // 배열의 모든 요소를 순회하며 최소값 찾기
            for (int i = 0; i < arr.length; i++) {
                // 현재 요소가 지금까지의 최소값보다 작고 아직 방문하지 않았다면
                // visited[i] == 0은 해당 요소를 아직 방문하지 않았음을 의미
                if (arr[i] < minVal && visited[i] == 0) {
                    // 최소값과 그 인덱스 갱신
                    minVal = arr[i];
                    minIdx = i;
                }
            }

            // 유효한 최소값을 찾았다면 (minIdx가 -1이 아님)
            if (minIdx != -1) {
                // 찾은 최소값 출력
                // 공백을 추가하여 값들을 구분함
                System.out.print(minVal + " ");
                
                // 해당 요소를 방문했다고 표시
                // visited 배열의 해당 인덱스를 1로 설정
                visited[minIdx] = 1;
                
                // 방문한 요소 개수 증가
                visitCnt++;
            }
            
            // 다음 반복을 위해 최소값과 인덱스 초기화
            // 다음 최소값을 찾기 위해 다시 큰 값으로 설정
            minVal = Integer.MAX_VALUE;
            minIdx = -1;
        }
        
        // 줄바꿈
        // 모든 요소 출력 후 새 줄로 이동
        System.out.println();
    }
}