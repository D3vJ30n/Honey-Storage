import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
  public static void main(String[] args) {
    Random random = new Random();
    Set<Integer> lottoSet = new HashSet<>();
    
    // 중복되지 않는 6개의 번호 생성
    while (lottoSet.size() < 6) {
      int number = random.nextInt(45) + 1;
      lottoSet.add(number);
    }
    
    // Set을 배열로 변환
    Integer[] lottoArray = lottoSet.toArray(new Integer[0]);
    
    // 배열 정렬
    Arrays.sort(lottoArray);
    
    // 결과 출력
    System.out.println(Arrays.toString(lottoArray));
  }
}