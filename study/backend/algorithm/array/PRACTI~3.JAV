// study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3
// 배열 arr의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

// 입출력 예시)
// arr: 1, 3, 5, 7, 9
// 결과: 9, 7, 5, 3, 1

// java.util 패키지에서 Arrays 클래스를 가져옴
// Arrays 클래스는 배열을 다루는 유용한 메서드들을 제공함
import java.util.Arrays;

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards13.src.study.backend.javapractice.solution.lineards142.src.Practice3 {
    public static void main(String[] args) {
        // 뒤집을 배열 초기화
        // 1부터 9까지의 홀수로 구성된 오름차순 배열 생성
        int[] arr = {1, 3, 5, 7, 9};

        // 배열의 앞쪽 절반만 순회 (중간 요소는 자동으로 제자리에 남음)
        // arr.length / 2는 정수 나눗셈이므로, 홀수 길이 배열의 경우 중앙 요소는 처리되지 않음
        for (int i = 0; i < arr.length / 2; i++) {
            // 현재 요소를 임시 변수에 저장
            // 이는 현재 요소의 값이 덮어씌워지기 전에 보존하기 위함
            int tmp = arr[i];
            
            // 현재 요소에 대응되는 뒤쪽 요소를 현재 위치로 이동
            // arr.length - 1 - i는 배열의 뒤에서부터 i번째 위치를 가리킴
            arr[i] = arr[arr.length - 1 - i];
            
            // 임시 저장한 원래 요소를 대응되는 뒤쪽 위치로 이동
            // 이로써 두 요소의 위치가 교환됨
            arr[arr.length - 1 - i] = tmp;
        }

        // 뒤집힌 배열 출력
        // Arrays.toString() 메서드는 배열의 내용을 문자열로 변환하여 반환
        // 이는 배열의 내용을 쉽게 확인할 수 있게 해줌
        System.out.println(Arrays.toString(arr));
    }
}