// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice2
// 배열 arr에서 target에 해당하는 값의 인덱스를 출력
// 해당 값이 여러 개인 경우 가장 큰 인덱스 출력

// 입출력 예시)
// 배열 arr: 1, 1, 100, 1, 1, 1, 100
// 결과: 6

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice2 {
    public static void main(String[] args) {
        // 검색할 배열 초기화
        // 여러 개의 1과 100이 포함된 정수 배열 생성
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        
        // 찾고자 하는 대상 값 설정
        // 이 경우 100을 찾고자 함
        int target = 100;
        
        // 가장 큰 인덱스를 저장할 변수 초기화
        // -1로 초기화하여 아직 target을 찾지 못했음을 나타냄
        // 배열의 유효한 인덱스는 0 이상이므로 -1은 '찾지 못함'을 의미하는 적절한 초기값
        int idxMax = -1;

        // 배열의 모든 요소를 순회
        // 전통적인 for 루프를 사용하여 배열의 각 요소와 그 인덱스에 접근
        for (int i = 0; i < arr.length; i++) {
            // 현재 요소가 target과 일치하는 경우
            if (arr[i] == target) {
                // 현재 인덱스가 지금까지 찾은 가장 큰 인덱스보다 크다면 갱신
                // 이 조건은 항상 참이 될 것이지만, 코드의 의도를 명확히 하기 위해 유지
                if (i > idxMax) {
                    idxMax = i;
                }
            }
        }

        // target을 찾은 경우 (idxMax가 갱신되었다면)
        // idxMax가 -1이 아니라면 target을 최소한 한 번은 찾았다는 의미
        if (idxMax >= 0) {
            // 가장 큰 인덱스 출력
            // 이는 배열에서 target이 마지막으로 등장한 위치를 나타냄
            System.out.println(idxMax);
        }
    }
}