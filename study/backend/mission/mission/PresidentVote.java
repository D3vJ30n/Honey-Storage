package study.backend.mission.mission;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PresidentVote {
    public static void main(String[] args) {
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        // System.in은 표준 입력 스트림
        Scanner scanner = new Scanner(System.in);

        // 무작위 숫자 생성을 위한 Random 객체 생성
        // 이 객체를 사용하여 투표 시뮬레이션에서 무작위 투표를 생성
        Random random = new Random();

        // 사용자로부터 전체 투표수 입력 받기
        System.out.print("투표수: ");
        int totalVotes = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼 비우기 (정수 입력 후 남은 개행문자 제거)

        // 사용자로부터 후보자 수 입력 받기
        System.out.print("인원: ");
        int candidateCount = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼 비우기
        
        /*  
        scanner.nextInt()
        
        이 메서드는 사용자가 입력한 정수값만을 읽는다.
        그러나 사용자가 숫자를 입력하고 Enter 키를 누를 때,
        숫자 다음에 오는 개행 문자('\n')는 입력 버퍼에 남아있게 된다.
        
        
        scanner.nextLine()
        
        이 메서드는 입력 버퍼에 남아있는 개행 문자('\n')를 제거하기 위해 사용된다.
        만약 이 라인을 생략하면,
        다음에 nextLine()을 호출했을 때 입력 버퍼에 남아있는 개행 문자를 읽어버려 의도치 않게 빈 문자열을 반환할 수 있다.
         */

        // 후보자 이름을 저장할 ArrayList 생성
        // ArrayList는 동적 크기 조정이 가능한 배열 기반 리스트 구조
        List<String> candidates = new ArrayList<>();

        // 사용자로부터 각 후보자의 이름을 입력받아 리스트에 추가
        for (int i = 0; i < candidateCount; i++) {
            System.out.print((i + 1) + "번째 후보자 이름을 입력해 주세요: ");
            candidates.add(scanner.nextLine()); // nexLine 입력의 유연성을 높이고, 다양한 형식의 이름을 처리할 수 있게 함. 입력 버퍼를 깔끔하게 비워줌. 연속된 입력을 받을 때 중요.
        }

        // 각 후보자별 득표수를 저장할 배열 생성
        // 배열의 각 인덱스는 후보자의 번호와 대응
        int[] votes = new int[candidateCount]; // 배열의 크기를 candidateCount로 설정하여 각 후보자에 대한 득표수를 개별적으로 추적

        // 투표 시뮬레이션 시작
        for (int i = 0; i < totalVotes; i++) { // totalVotes 전체 투표 수,배열 인덱스는 0부터 시작하므로, 인덱스 0은 첫 번째 후보자, 1은 두 번째 후보자... 와 같이 대응
            // 0부터 (후보자 수 - 1) 사이의 무작위 숫자 생성하여 해당 후보에게 투표
            int vote = random.nextInt(candidateCount); // 무작위로 한 후보에게 투표
            votes[vote]++; // vote는 무작위로 선택된 후보의 인덱스, votes 배열에서 해당 인덱스의 값을 1 증가시켜 득표수를 갱신

            // 현재까지의 투표 진행률 계산 및 출력
            // (i + 1)을 사용하는 이유는 i가 0부터 시작하기 때문, 현재까지 처리된 투표 수
            double progressPercentage = (double) (i + 1) / totalVotes * 100; // totalVotes로 나누어 진행 비율 계산, 100을 곱해 백분율로 변환
            System.out.printf("\n[투표진행률]: %.2f%%, %d표 중 %d표 개표\n", // %.2f%%는 소수점 둘째 자리까지의 백분율을 표시, %d표 중 %d표 개표는 전체 투표 수와 현재까지 개표된 표 수를 보여줍
                progressPercentage, totalVotes, i + 1);

            // 각 후보별 현재까지의 득표율 및 득표수 계산 및 출력
            for (int j = 0; j < candidateCount; j++) {
                double percentage = (double) votes[j] / (i + 1) * 100; // votes[j]는 현재 후보의 득표 수, (i + 1)은 현재까지의 총 투표 수, percentage는 현재 후보의 득표율을 계산(현재 득표 수 / 현재까지의 총 투표 수 * 100)
                System.out.printf("[기호:%d] %s: %.2f%% (투표수: %d)\n",
                    // printf를 사용해 각 후보의 정보를 형식화하여 출력
                    /* [기호:%d]: 후보 번호 (1부터 시작)
                    %s: 후보 이름
                    %.2f%%: 득표율 (소수점 둘째 자리까지)
                    %d: 투표 수(투표수: %d): 현재까지의 득표 수
                     */
                    j + 1, candidates.get(j), percentage, votes[j]);
            }
        }

        // 최종 결과 계산 및 당선인 선정
        // 이 변수는 루프를 돌면서 가장 높은 득표수를 추적하는 데 사용
        // 0으로 초기화하는 이유는 모든 유효한 득표수가 0보다 크거나 같기 때문
        int maxVotes = 0;
        // 최다 득표 후보의 인덱스를 저장할 변수를 0으로 초기화
        // 이 변수는 최종적으로 당선인의 인덱스를 나타내게 됩
        // 0으로 초기화하는 이유는 첫 번째 후보(인덱스 0)부터 비교를 시작하기 때문
        int winnerIndex = 0;
        // 모든 후보들의 득표수를 확인하기 위한 for 루프
        // i는 0부터 시작하여 candidateCount-1까지 증가
        // candidateCount는 총 후보자 수

        // 가장 많은 표를 받은 후보를 찾음
        for (int i = 0; i < candidateCount; i++) {
            // 현재 확인 중인 후보의 득표수(votes[i])가
            // 지금까지 확인한 최대 득표수(maxVotes)보다 큰지 비교
            // '>'를 사용하여 첫 번째로 가장 많은 표를 받은 후보를 선정
            // 만약 '>='를 사용하면 같은 표를 받은 경우 마지막 후보가 선정
            if (votes[i] > maxVotes) {
                // 현재 후보의 득표수가 더 크다면, maxVotes를 이 값으로 업데이트
                // 이렇게 하면 루프가 끝날 때 maxVotes에는 가장 높은 득표수가 저장
                maxVotes = votes[i];
                // 현재 후보가 새로운 최다 득표자가 되므로, winnerIndex를 현재 후보의 인덱스(i)로 업데이트
                // 루프가 끝나면 winnerIndex는 가장 많은 표를 받은 후보의 인덱스를 가리키게 됨
                winnerIndex = i;
            }
        }
        // 이 루프가 끝나면 maxVotes에는 최대 득표수가,
        // winnerIndex에는 최다 득표 후보의 인덱스가 저장
        // 동점자가 있을 경우, 이 로직은 첫 번째로 확인된 최다 득표자를 선정

        // 당선인 발표
        // 가장 많은 표를 받은 후보의 이름을 출력
        System.out.printf("\n[투표결과] 당선인: %s\n", candidates.get(winnerIndex));

        // Scanner 객체 닫기 (리소스 해제)
        // 이는 메모리 누수를 방지하고 시스템 리소스를 적절히 관리하기 위함
        scanner.close();
    }
}