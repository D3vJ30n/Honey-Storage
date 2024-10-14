// Practice6
// 배열 arr에서 중복 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5
// 결과: 1, 5, 3, 2, 4

public class Practice6 {
    public static void main(String[] args) {
        // 원본 배열 초기화
        // 중복된 요소를 포함한 정수 배열 생성
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        
        // 중복이 제거된 결과를 저장할 새 배열 생성 (최대 크기는 원본 배열의 크기)
        // 최악의 경우(모든 요소가 고유할 때) 원본 배열과 같은 크기가 필요
        int[] arrResult = new int[arr.length];
        
        // 새 배열에 저장된 고유한 요소의 개수를 추적하는 변수
        // 이 변수는 결과 배열의 실제 크기와 다음에 삽입할 위치를 나타냄
        int cnt = 0;

        // 원본 배열의 모든 요소를 순회
        for (int i = 0; i < arr.length; i++) {
            // 현재 요소의 중복 여부를 나타내는 플래그
            // 각 요소마다 false로 초기화되어 검사 시작
            boolean dupFlag = false;
            
            // 결과 배열의 현재까지 저장된 요소들과 비교
            // cnt는 현재까지 저장된 고유 요소의 개수이므로, 여기까지만 비교
            for (int j = 0; j < cnt; j++) {
                // 중복된 요소를 발견하면 플래그를 true로 설정
                if (arr[i] == arrResult[j]) {
                    dupFlag = true;
                    // 중복을 발견하면 더 이상의 비교는 불필요하므로 내부 루프 종료 가능
                    break;
                }
            }

            // 중복되지 않은 요소라면 결과 배열에 추가
            if (dupFlag == false) {
                // cnt 위치에 새 요소 추가 후 cnt 증가
                // 후위 증가 연산자(++)를 사용하여 간결하게 표현
                arrResult[cnt++] = arr[i];
            }
        }

        // 중복이 제거된 배열의 요소들을 출력
        // cnt가 결과 배열의 실제 크기이므로, 여기까지만 출력
        for (int i = 0; i < cnt; i++) {
            // 각 요소를 공백으로 구분하여 출력
            System.out.print(arrResult[i] + " ");
        }
        // 줄바꿈
        // 모든 요소 출력 후 새 줄로 이동
        System.out.println();
    }
}