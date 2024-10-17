package study.javapractices;

public class Practice09 {
    public static String solution(int[] keyLog) {
        // 키보드 입력 값에 대한 상수 정의
        // 각 상수는 특정 키의 ASCII 코드 또는 가상 키 코드를 나타냄
        // 이렇게 상수로 정의하면 코드의 가독성과 유지보수성이 향상됨
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        // 문자열 조작을 위한 StringBuffer 객체 생성
        // StringBuffer는 가변적인 문자열을 다룰 때 String보다 효율적
        // 특히 문자열 수정이 빈번한 경우 메모리 사용과 성능 면에서 유리함
        StringBuffer sb = new StringBuffer();

        // 대소문자 변환을 위한 ASCII 코드 차이 값
        // 'a'와 'A'의 ASCII 코드 차이를 이용해 대소문자 변환에 사용
        int step = (int)('a' - 'A');

        // 현재 커서 위치, 현재 처리 중인 명령어 인덱스
        // curSor: 텍스트 에디터에서 현재 입력/수정이 일어날 위치
        // cmdIdx: keyLog 배열에서 현재 처리 중인 키 입력의 인덱스
        int curSor = 0;
        int cmdIdx = 0;

        // 특수 키의 상태를 나타내는 변수들
        // 각 변수는 해당 키의 on/off 상태를 boolean으로 표현
        boolean isShift = false;
        boolean isCapsLock = false;
        boolean isInsert = false;

        // 모든 키 입력을 처리할 때까지 반복
        while (cmdIdx != keyLog.length) {
            int cur = keyLog[cmdIdx];
            
            if (cur == BACK_SPACE) {
                // 백스페이스 키 처리
                // 커서가 맨 앞이 아닐 때만 문자 삭제
                if (curSor == 0) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor - 1, curSor);
                curSor = Math.max(0, curSor - 1);
            } else if (cur == SHIFT) {
                // Shift 키 상태 변경
                // Shift는 다음 문자 입력에만 영향을 주므로 true로 설정
                isShift = true;
            } else if (cur == CAPS_LOCK) {
                // Caps Lock 키 상태 토글
                // Caps Lock은 켜고 끄는 토글 방식이므로 현재 상태를 반전
                isCapsLock = !isCapsLock;
            } else if (cur == SPACE_BAR) {
                // 스페이스바 입력 처리
                // 공백 문자를 현재 커서 위치에 삽입
                inputData(sb, ' ', curSor, isInsert);
                curSor += 1;
            } else if (cur == KEY_LEFT) {
                // 왼쪽 화살표 키 처리
                // 커서를 왼쪽으로 이동, 단 0 미만으로 내려가지 않도록 함
                curSor = Math.max(0, curSor - 1);
            } else if (cur == KEY_RIGHT) {
                // 오른쪽 화살표 키 처리
                // 커서를 오른쪽으로 이동, 단 문자열 길이를 초과하지 않도록 함
                curSor = Math.min(sb.length(), curSor + 1);
            } else if (cur == INSERT) {
                // Insert 키 상태 토글
                // Insert 모드를 켜고 끄는 토글 방식
                isInsert = !isInsert;
            } else if (cur == DELETE) {
                // Delete 키 처리
                // 커서가 맨 끝이 아닐 때만 문자 삭제
                if (curSor == sb.length()) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor, curSor + 1);
            } else if (cur >= 97 && cur <= 122) {
                // 알파벳 입력 처리 (ASCII 코드 97-122는 소문자 a-z)
                int data = cur;
                // Caps Lock과 Shift 상태에 따른 대소문자 결정
                if (isCapsLock && isShift) {
                    // Caps Lock on, Shift 누름 → 소문자
                    data = cur;
                } else if (isCapsLock || isShift) {
                    // Caps Lock on 또는 Shift 누름 → 대문자
                    data -= step;
                }
                inputData(sb, (char)data, curSor, isInsert);
                isShift = false;  // Shift 상태 초기화
                curSor += 1;
            } else if (cur >= 48 && cur <= 57) {
                // 숫자 및 특수문자 입력 처리 (ASCII 코드 48-57는 숫자 0-9)
                if (isShift) {
                    // Shift가 눌린 경우 해당 숫자 키의 특수문자 입력
                    char[] specialKey = {')', '!', '@', '#', '$', '%', '^', '&', '*', '('};
                    inputData(sb, specialKey[cur - '0'], curSor, isInsert);
                } else {
                    // 일반 숫자 입력
                    inputData(sb, (char)cur, curSor, isInsert);
                }
                isShift = false;  // Shift 상태 초기화
                curSor += 1;
            }
            
            cmdIdx++;  // 다음 키 입력으로 이동
        }

        // 최종 결과 문자열 반환
        return sb.toString();
    }

    // 문자 입력 처리 메서드
    public static void inputData(StringBuffer sb, char data, int curSor, boolean isInsert) {
        // Insert 모드에 따라 문자 삽입 또는 교체
        if (isInsert == false) {
            // Insert 모드가 아닐 경우, 현재 커서 위치에 문자 삽입
            sb.insert(curSor, data);
        } else {
            // Insert 모드일 경우, 현재 커서 위치의 문자를 새 문자로 교체
            // 만약 커서가 문자열 끝이라면 append 동작
            if (curSor == sb.length()) {
                sb.append(data);
            } else {
                sb.setCharAt(curSor, data);
            }
        }
    }
    
    public static void main(String[] args) {
        // 테스트 코드
        // 다양한 시나리오를 테스트하여 프로그램의 정확성 검증
        int[] keyLog = {16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104};
        System.out.println(solution(keyLog));  // "Hello" 출력 예상

        keyLog = new int[]{20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97};
        System.out.println(solution(keyLog));  // "Hi Java" 출력 예상

        keyLog = new int[]{49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53};
        System.out.println(solution(keyLog));  // "2345" 출력 예상

        keyLog = new int[]{20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51};
        System.out.println(solution(keyLog));  // "ABCDE!@#" 출력 예상
    }
}