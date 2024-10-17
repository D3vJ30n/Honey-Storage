package study.javapractices;

public class Practice3 {
    /**
     * 문자열 내의 특정 부분을 다른 문자열로 치환하는 메소드
     * @param str 원본 문자열 배열
     * @param find 찾을 문자열 배열
     * @param to 변경할 문자열 배열
     * @return 치환이 완료된 문자열
     */
    public static String solution(char[] str, char[] find, char[] to) {
        // 찾은 패턴의 시작 인덱스를 저장할 변수
        int idx = 0;
        
        // 최종 변경된 데이터를 담을 문자열 변수
        String replaceStr = "";
        
        // 원본 문자열의 복사본을 생성 (작업용 버퍼)
        // clone()을 사용하여 깊은 복사 수행
        char[] replaceBucket = str.clone();

        // do-while 문을 사용하여 모든 패턴을 찾아 치환
        do {
					// 현재 문자열에서 찾고자 하는 패턴의 위치를 탐색
						
					    /* 첫 번째 반복
             * 1. findIndex 호출 -> idx = 0 (첫 번째 'P' 발견)
             * 2. replaceStr 구성 과정:
             *    - idx(0) 이전까지 문자 추가: replaceStr = ""
             *    - to 문자 추가: replaceStr = "W"
             *    - 나머지 문자 추가: replaceStr = "WOP"
             * 3. replaceBucket = ['W', 'O', 'P']
             * 4. replaceStr = "" (초기화)
             */
            
            /* 두 번째 반복
             * 1. findIndex 호출 -> idx = 2 (마지막 'P' 발견)
             * 2. replaceStr 구성 과정:
             *    - idx(2) 이전까지 문자 추가: replaceStr = "WO"
             *    - to 문자 추가: replaceStr = "WOW"
             *    - 나머지 문자 없음
             * 3. replaceBucket = ['W', 'O', 'W']
             * 4. replaceStr = "" (초기화)
             */
            
            /* 세 번째 반복
             * 1. findIndex 호출 -> idx = -1 ('P'를 더 이상 찾지 못함)
             * 2. while 문 종료
             */
						
            idx = findIndex(replaceBucket, find);
            
            // 패턴을 찾은 경우 (idx가 -1이 아닌 경우)
            if (idx != -1) {
                // 1단계: 패턴 이전까지의 문자들을 결과 문자열에 추가
                for (int i = 0; i < idx; i++) {
                    replaceStr += replaceBucket[i];
                }
                
                // 2단계: 찾은 패턴 대신 새로운 문자열(to)을 추가
                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }
                
                // 3단계: 패턴 이후의 나머지 문자들을 추가
                for (int i = idx + find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }
                
                // 다음 반복을 위해 작업용 버퍼 업데이트
                replaceBucket = replaceStr.toCharArray();
                // 다음 치환을 위해 결과 문자열 초기화
                replaceStr = "";
            }
        } while(idx != -1); // 더 이상 패턴을 찾지 못할 때까지 반복

        // 최종 결과를 문자열로 변환하여 반환
        replaceStr = new String(replaceBucket);
        return replaceStr;
    }

    /**
     * 문자열 배열에서 특정 패턴의 시작 위치를 찾는 메소드
     * @param str 검색할 문자열 배열
     * @param find 찾을 패턴 배열
     * @return 패턴이 시작되는 인덱스 (-1: 패턴을 찾지 못함)
     */
    public static int findIndex(char[] str, char[] find) {
        // 패턴의 시작 위치를 저장할 변수 (-1로 초기화)
        int idx = -1;
        // 패턴 일치 여부를 저장할 플래그
        boolean isMatch = false;

        // 문자열 전체를 순회하면서 패턴 검색
        for (int i = 0; i < str.length; i++) {
            // 두 가지 조건 체크:
            // 1. 현재 문자가 패턴의 첫 글자와 일치하는지
            // 2. 남은 문자열의 길이가 패턴의 길이보다 크거나 같은지
            if (str[i] == find[0] && str.length - i >= find.length) {
                isMatch = true;
                // 패턴의 나머지 문자들과 비교
                for (int j = 1; j < find.length; j++) {
                    // 하나라도 일치하지 않으면 false로 설정하고 중단
                    if (str[i + j] != find[j]) {
                        isMatch = false;
                        break;
                    }
                }
            }
            
            // 패턴을 찾은 경우, 현재 위치를 저장하고 검색 종료
            if (isMatch) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }

    public static void main(String[] args) {
        // 테스트 코드
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // Java 기본 제공 replace 메소드로 치환
        System.out.println(str.replace(find, to));

        // 직접 구현한 치환 메소드로 테스트
        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        // 추가 테스트 케이스: "POP"에서 "P"를 "W"로 치환
        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}