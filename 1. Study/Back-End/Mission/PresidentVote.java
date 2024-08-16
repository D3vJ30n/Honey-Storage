import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PresidentVote {
  public static void main(String[] args) {
    // 콘솔 출력 스트림 인코딩을 UTF-8로 설정
    // 이를 통해 한글이 깨지지 않고 올바르게 출력됩니다.
    System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

    // 사용자 입력을 받기 위한 Scanner 객체 생성
    Scanner scanner = new Scanner(System.in);
    // 무작위 숫자 생성을 위한 Random 객체 생성
    Random random = new Random();

    // 사용자로부터 전체 투표수 입력 받기
    System.out.print("투표수: ");
    int totalVotes = scanner.nextInt();
    scanner.nextLine(); // 입력 버퍼 비우기 (정수 입력 후 남은 개행문자 제거)

    // 사용자로부터 후보자 수 입력 받기
    System.out.print("인원: ");
    int candidateCount = scanner.nextInt();
    scanner.nextLine(); // 입력 버퍼 비우기

    // 후보자 이름을 저장할 ArrayList 생성
    List<String> candidates = new ArrayList<>();
    // 사용자로부터 각 후보자의 이름을 입력받아 리스트에 추가
    for (int i = 0; i < candidateCount; i++) {
      System.out.print((i + 1) + "번째 후보자 이름을 입력해 주세요: ");
      candidates.add(scanner.nextLine());
    }

    // 각 후보자별 득표수를 저장할 배열 생성
    int[] votes = new int[candidateCount];

    // 투표 시뮬레이션 시작
    for (int i = 0; i < totalVotes; i++) {
      // 0부터 (후보자 수 - 1) 사이의 무작위 숫자 생성하여 해당 후보에게 투표
      int vote = random.nextInt(candidateCount);
      votes[vote]++;

      // 현재까지의 투표 진행률 계산 및 출력
      double progressPercentage = (double) (i + 1) / totalVotes * 100;
      System.out.printf("\n[투표진행률]: %.2f%%, %d표 중 %d표 개표\n",
          progressPercentage, totalVotes, i + 1);

      // 각 후보별 현재까지의 득표율 및 득표수 계산 및 출력
      for (int j = 0; j < candidateCount; j++) {
        double percentage = (double) votes[j] / (i + 1) * 100;
        System.out.printf("[기호:%d] %s: %.2f%% (투표수: %d)\n",
            j + 1, candidates.get(j), percentage, votes[j]);
      }
    }

    // 최종 결과 계산 및 당선인 선정
    int maxVotes = 0;
    int winnerIndex = 0;
    // 가장 많은 표를 받은 후보를 찾음
    for (int i = 0; i < candidateCount; i++) {
      if (votes[i] > maxVotes) {
        maxVotes = votes[i];
        winnerIndex = i;
      }
    }

    // 당선인 발표
    System.out.printf("\n[투표결과] 당선인: %s\n", candidates.get(winnerIndex));

    // Scanner 객체 닫기 (리소스 해제)
    scanner.close();
  }
}