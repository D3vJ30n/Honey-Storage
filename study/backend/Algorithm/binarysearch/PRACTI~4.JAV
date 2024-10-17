// study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice4
// 정수형 배열 weights 와 정수 days 가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days 는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시
// weights: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// days: 5
// 출력: 15

// weights: 3, 2, 2, 4, 1, 4
// days: 3
// 출력: 6


public class study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice4 {
    public static int solution(int[] weights, int days) {
        int left = 0;
        int right = 0;
        
        // left: 배열 내 가장 무거운 무게 (최소 적재량)
        // right: 모든 무게의 총합 (최대 적재량)
        for (int w : weights) {
            left = Math.max(left, w);  // 가장 무거운 무게 찾기
            right += w;  // 총 무게 합산
        }
        
        // 이진 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2;  // 중간값 (현재 검사할 적재량)
            int cnt = 1;  // 필요한 일 수
            int cur = 0;  // 현재 적재된 무게
            
            // 무게 배열을 순회하며 현재 적재량(mid)으로 운송 가능한지 확인
            for (int w : weights) {
                if (cur + w > mid) {  // 현재 적재량을 초과하면
                    cnt++;  // 새로운 날짜 추가
                    cur = 0;  // 적재량 초기화
                }
                cur += w;  // 현재 무게 추가
            }
            
            // 필요한 일 수가 주어진 일 수보다 많으면 적재량을 늘려야 함
            if (cnt > days) {
                left = mid + 1;
            } 
            // 필요한 일 수가 주어진 일 수 이하면 적재량을 줄여볼 수 있음
            else {
                right = mid - 1;
            }
        }
        
        // 최종적으로 가능한 최소 적재량 반환
        return left;
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15 출력
        
        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6 출력
    }
}