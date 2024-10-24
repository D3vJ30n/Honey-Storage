package practicecodingtest.zbct;

public class zbct1_2 {
    public String solution(int n, String s, int t) {
        // 변수 선언
        int cycleLength;
        int currentPosition;

        StringBuilder answer = new StringBuilder();
        //한 사이클 길이 계산
        cycleLength = n + s.length();
        //현재 위치 계산
        currentPosition = t % cycleLength;
        // answer를 n개의 '.' 초기화
        // 결과 문자열 만들기
        for (int i = 0; i < n; i++) {
            answer.append('.');
        }
        //currentPosition을 보고 문자들을 적절히 배치
        for (int i = 0; i < s.length(); i++) {
            if (currentPosition + i < n) {
                answer.setCharAt(currentPosition + i, s.charAt(i));
            } else {
                answer.setCharAt(currentPosition + i - n, s.charAt(i));
            }
        }
        return answer.toString();
    }
}