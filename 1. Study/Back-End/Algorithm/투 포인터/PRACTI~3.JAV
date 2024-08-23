// Practice
// 문자열 s 를 거꾸로 출력하는 프로그램을 작성하세요.
// 단, 각 단어의 알파벳 순서는 그대로 출력합니다.
// 문장에 공백이 여러개일 시, 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거하세요.

// 입출력 예시
// 문자열 s: "the sky is blue"
// 출력: "blue is sky the"

// 문자열 s: "  hello      java    "
// 출력: "java hello"


public class Practice3 {
    // 전체 알고리즘의 시간 복잡도는 O(n)입니다. 여기서 n은 문자열의 길이입니다.
    public static String solution(String s) {
        if (s == null) {
            return null;
        }
        
        if (s.length() < 2) {
            return s;
        }
        
        // 단계 1: 불필요한 공백 제거
        s = removeSpaces(s);
        
        char[] cArr = s.toCharArray();
        // 단계 2: 전체 문자열 뒤집기
        reverseString(cArr, 0, s.length() - 1);
        
        // 단계 3: 각 단어 다시 뒤집기
        reverseWords(cArr, s.length());
        
        return new String(cArr);
    }
    
    // 불필요한 공백을 제거하고 단어 사이에 공백 하나만 남기는 메소드
    // 시간 복잡도: O(n), 공간 복잡도: O(n)
    public static String removeSpaces(String s) {
        int p1 = 0;  // 결과 문자열을 만들기 위한 포인터
        int p2 = 0;  // 원본 문자열을 순회하기 위한 포인터
        
        char[] cArr = s.toCharArray();
        int length = s.length();
        
        while (p2 < length) {
            // 단어 앞쪽의 모든 공백 건너뛰기
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }
            
            // 공백이 아닌 문자들(단어)을 앞쪽으로 이동
            while (p2 < length && cArr[p2] != ' ') {
                cArr[p1++] = cArr[p2++];
            }
            
            // 단어 뒤쪽의 모든 공백 건너뛰기
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }
            
            // 다음 단어가 있다면 단어 사이에 공백 하나 추가
            if (p2 < length) {
                cArr[p1++] = ' ';
            }
        }
        
        // 불필요한 공백이 제거된 새로운 문자열 반환
        return new String(cArr).substring(0, p1);
    }
    
    // 주어진 범위의 문자들을 뒤집는 메소드 (in-place 알고리즘)
    // 시간 복잡도: O(n), 공간 복잡도: O(1)
    public static void reverseString(char[] cArr, int i, int j) {
        while (i < j) {
            char tmp = cArr[i];
            cArr[i++] = cArr[j];
            cArr[j--] = tmp;
        }
    }
    
    // 각 단어를 뒤집는 메소드
    // 시간 복잡도: O(n), 공간 복잡도: O(1)
    public static void reverseWords(char[] cArr, int length) {
        int p1 = 0;  // 단어의 시작 포인터
        int p2 = 0;  // 단어의 끝 포인터
        
        while (p1 < length) {
            // p1을 다음 단어의 시작 위치로 이동
            while (p1 < p2 || p1 < length && cArr[p1] == ' ') {
                p1++;
            }
            
            // p2를 다음 단어의 끝 위치로 이동
            while (p2 < p1 || p2 < length && cArr[p2] != ' ')  {
                p2++;
            }
            
            // 현재 단어를 뒤집기
            reverseString(cArr, p1, p2 - 1);
        }
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution("the sky is blue"));  // "blue is sky the" 출력 예상
        System.out.println(solution("  hello      java    "));  // "java hello" 출력 예상
    }
}