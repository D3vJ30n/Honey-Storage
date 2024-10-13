import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Lotto {
  public static void main(String[] args) {
    // Scanner 객체 생성. 사용자 입력 받을 준비 완료.
    Scanner scanner = new Scanner(System.in);
    // Random 객체 생성. 무작위 숫자 뽑을 준비 완료.
    Random random = new Random();

    System.out.println("[로또 당첨 프로그램]");
    System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10): ");
    // 사용자가 구매할 로또 개수 입력받음. 정수형으로 저장
    int count = scanner.nextInt();

    // 입력값 검사. 1~10 사이 숫자인지 확인
    if (count < 1 || count > 10) {
      System.out.println("잘못된 입력입니다. 1에서 10 사이의 숫자를 입력해주세요.");
      scanner.close();
      return; // 프로그램 종료. 잘못된 입력이므로 더 이상 진행하지 않음
    }

    // 2차원 배열 생성. 로또 번호 저장용. 행: 로또 개수, 열: 6개의 번호
    int[][] lottoNumbers = new int[count][6];
    for (int i = 0; i < count; i++) {
      // generateLottoNumbers 메서드 호출. 새 로또 번호 세트 생성
      lottoNumbers[i] = generateLottoNumbers(random);
      // 생성된 로또 번호 출력. A, B, C 등의 알파벳으로 구분
      System.out.println((char)('A' + i) + " " + arrayToString(lottoNumbers[i]));
    }

    System.out.println("\n[로또 발표]");
    // 당첨 번호 생성. 위에서 만든 것과 동일한 메서드 사용
    int[] winningNumbers = generateLottoNumbers(random);
    // 당첨 번호 출력. 사용자가 확인할 수 있게 함
    System.out.println(arrayToString(winningNumbers));

    System.out.println("\n[내 로또 결과]");
    for (int i = 0; i < count; i++) {
      // 각 로또 번호와 당첨 번호 비교. 일치하는 숫자 개수 계산
      int matches = countMatches(lottoNumbers[i], winningNumbers);
      // 결과 출력. 로또 번호, 일치하는 숫자 개수 표시
      System.out.printf("%c %s => %d개 일치\n", (char)('A' + i), arrayToString(lottoNumbers[i]), matches);
    }

    // Scanner 객체 닫음. 리소스 누수 방지.
    scanner.close();
  }

  // 로또 번호 6개 생성 메서드. 중복 없는 1~45 사이의 숫자 생성
  public static int[] generateLottoNumbers(Random random) {
    int[] numbers = new int[6];
    for (int i = 0; i < 6; i++) {
      int number;
      do {
        // 1~45 사이의 랜덤 숫자 생성
        number = random.nextInt(45) + 1;
      // 중복 검사. 이미 뽑은 숫자와 같으면 다시 뽑음
      } while (contains(numbers, number, i));
      numbers[i] = number;
    }
    // 번호를 오름차순으로 정렬. 보기 좋게 만듦
    Arrays.sort(numbers);
    return numbers;
  }

  // 배열에 특정 숫자가 있는지 확인하는 메서드. 중복 체크에 사용
  private static boolean contains(int[] array, int number, int end) {
    for (int i = 0; i < end; i++) {
      if (array[i] == number) {
        return true; // 숫자 발견되면 true 반환
      }
    }
    return false; // 숫자가 없으면 false 반환
  }

  // 정수 배열을 보기 좋은 문자열로 변환. 출력 시 사용
  private static String arrayToString(int[] array) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      // 숫자를 두 자리로 맞춤. 예: 1 -> 01
      sb.append(String.format("%02d", array[i]));
      if (i < array.length - 1) {
        sb.append(","); // 숫자 사이에 쉼표 추가
      }
    }
    return sb.toString();
  }

  // 두 배열에서 일치하는 숫자 개수를 세는 메서드. 당첨 확인용
  private static int countMatches(int[] numbers, int[] winningNumbers) {
    int count = 0;
    for (int number : numbers) {
      // 구매한 로또 번호가 당첨 번호에 포함되어 있는지 확인
      if (contains(winningNumbers, number, winningNumbers.length)) {
        count++; // 일치하는 번호 발견 시 카운트 증가
      }
    }
    return count; // 총 일치하는 번호 개수 반환
  }
}