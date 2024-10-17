package study.javapractices;

import java.util.ArrayList;

public class Practice08 {
    public static String solution(String input, String cmd) {
        // StringBuffer를 사용하는 이유
        // 1. 문자열을 자주 수정할 때 String보다 빠르고 효율적
        // 2. 문자를 쉽게 추가하거나 삭제할 수 있음
        StringBuffer sb = new StringBuffer(input);
        
        // ArrayList를 사용하는 이유
        // 1. 명령어들을 쉽게 저장하고 접근할 수 있음
        // 2. 크기가 동적으로 변할 수 있어서 편리
        ArrayList<String> cmdArr = new ArrayList<>();
        
        // 명령어 문자열을 공백으로 나누어 ArrayList에 저장
        // 이렇게 하면 각 명령어를 쉽게 처리할 수 있음
        for (String s: cmd.split(" ")) {
            cmdArr.add(s);
        }
        
        // 커서의 초기 위치를 문자열의 맨 끝으로 설정
        // 텍스트 에디터처럼 시작할 때 커서가 맨 끝에 있도록 해야 함
        int curSor = sb.length();
        
        // 명령어 배열의 현재 위치를 나타내는 변수
        // 이 변수를 사용해 명령어를 하나씩 처리
        int cmdIdx = 0;
        
        // 모든 명령어를 처리할 때까지 반복
        while (cmdIdx != cmdArr.size()) {
            // 현재 처리할 명령어를 가져옴
            String cur = cmdArr.get(cmdIdx);
            
            if (cur.equals("L")) {
                // L 명령어: 커서를 왼쪽으로 한 칸 옮김
                // Math.max를 사용해 커서가 0보다 작아지지 않도록 해야 함
                curSor = Math.max(0, curSor - 1);
            } else if (cur.equals("D")) {
                // D 명령어: 커서를 오른쪽으로 한 칸 옮김
                // Math.min을 사용해 커서가 문자열 길이를 넘지 않도록 함
                curSor = Math.min(sb.length(), curSor + 1);
            } else if (cur.equals("B")) {
                // B 명령어: 커서 왼쪽의 문자를 삭제
                // 커서가 맨 앞이면 삭제할 게 없으니 다음 명령어로 넘어감
                if (curSor == 0) {
                    cmdIdx++;
                    continue;
                }
                // 커서 왼쪽의 문자를 삭제하고 커서 위치를 조정
                sb.delete(curSor - 1, curSor);
                curSor = Math.max(0, curSor - 1);
            } else if (cur.equals("P")) {
                // P 명령어: 다음 명령어로 주어진 문자를 커서 왼쪽에 추가
                // 다음 명령어(추가할 문자)를 가져옴
                String s = cmdArr.get(++cmdIdx);
                // 커서 위치에 문자를 삽입
                sb.insert(curSor, s);
                // 커서를 오른쪽으로 한 칸 옮김
                curSor += 1;
            }
            
            // 다음 명령어로 넘어감
            cmdIdx++;
        }
        
        // 모든 작업이 끝난 후의 문자열을 반환
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // 테스트 코드: 여러 가지 경우를 테스트
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}