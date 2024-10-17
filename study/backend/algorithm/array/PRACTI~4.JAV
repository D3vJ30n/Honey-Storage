// study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice4
// 배열 arr에서 peak 값 모두 출력
// peak 값: 자신의 좌우 이웃보다 큰 값 (배열의 양 끝은 한쪽만 비교)

// 입출력 예시)
// arr: 3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11
// 결과: 3, 6, 5, 10, 11

public class study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice4 {
    public static void main(String[] args) {
        // peak 값을 찾을 배열 초기화
        // peak: 인접한 요소들보다 큰 값
        int[] arr = {3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};

        // 배열의 모든 요소를 순회
        // 각 요소가 peak인지 확인하기 위해 전체 배열을 검사
        for (int i = 0; i < arr.length; i++) {
            // 배열의 첫 번째 요소 처리 (왼쪽 이웃이 없음)
            // 첫 번째 요소는 오른쪽 이웃과만 비교
            if (i == 0 && arr[i] > arr[i + 1]) {
                System.out.print(arr[i] + " ");
            } 
            // 배열의 마지막 요소 처리 (오른쪽 이웃이 없음)
            // 마지막 요소는 왼쪽 이웃과만 비교
            else if (i == arr.length - 1 && arr[i] > arr[i - 1]){
                System.out.print(arr[i] + " ");
            } 
            // 배열의 중간 요소들 처리
            // 첫 번째와 마지막을 제외한 모든 요소는 양쪽 이웃과 비교
            else {
                // 현재 요소가 양쪽 이웃보다 큰 경우 (peak)
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        // 줄바꿈
        // 모든 peak 출력 후 새 줄로 이동
        System.out.println();
    }
}