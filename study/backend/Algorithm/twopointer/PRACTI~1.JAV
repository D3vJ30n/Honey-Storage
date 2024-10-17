// Practice
// a, b, c, d 로 이루어진 알파벳 문자열에 대해서
// 다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 반환하는 프로그램을 작성하세요.
// 양쪽의 문자를 비교한 후 같으면 삭제하는데, 연속해서 같은 문자가 등장하면 함께 삭제한다.
// 최종적으로 남은 문자열을 반환하세요.

// 입출력 예시
// 입력 s: "ab"
// 출력: "ab"

// 입력 s: "aaabbaa"
// 출력: (없음)

public class study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1 {
    // 이 알고리즘의 시간 복잡도는 O(n)입니다. 여기서 n은 문자열의 길이입니다.
    // 각 문자를 최대 한 번씩만 확인하기 때문입니다.
    public static String solution(String s) {
        // null 체크는 NullPointerException을 방지하기 위해 중요합니다.
        if (s == null || s.length() == 0) {
            return null;
        }
        
        int p1 = 0;
        int p2 = s.length() - 1;
        
        // 이 알고리즘은 투 포인터 기법을 사용합니다.
        // 양 끝에서 시작해 중앙으로 이동하며 문자열을 정리합니다.
        while (p1 < p2 && s.charAt(p1) == s.charAt(p2)) {
            char c = s.charAt(p2);
            
            // 연속된 같은 문자를 한 번에 제거하는 것이 이 알고리즘의 핵심입니다.
            // 이렇게 하면 모든 경우를 효율적으로 처리할 수 있습니다.
            while (p1 <= p2 && s.charAt(p1) == c) {
                p1++;
            }
            
            while (p1 <= p2 && s.charAt(p2) == c) {
                p2--;
            }
        }
        
        // substring 메소드는 새로운 문자열 객체를 생성합니다.
        // 큰 문자열에서 자주 호출하면 메모리 사용량이 증가할 수 있으니 주의해야 합니다.
        return s.substring(p1, p2 + 1);
    }
    
    public static void main(String[] args) {
        // 테스트 케이스들은 다양한 상황을 고려하여 선택되었습니다.
        // "ab": 변화 없는 경우
        // "aaabbaa": 모든 문자가 제거되는 경우
        // "aabcddba": 중간 문자만 남는 경우
        System.out.println(solution("ab"));      // "ab" 출력 예상
        System.out.println(solution("aaabbaa")); // 빈 문자열 출력 예상
        System.out.println(solution("aabcddba"));// "cdd" 출력 예상
    }
}