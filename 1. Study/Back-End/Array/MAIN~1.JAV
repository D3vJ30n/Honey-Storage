// 선형 자료구조 - 배열과 ArrayList 예제
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // 1차원 배열 예제
    System.out.println("== 1차원 배열 ==");
    // 정수형 1차원 배열 선언 및 초기화
    int[] arr = {1, 2, 3, 4, 5};
    
    // 향상된 for문을 사용하여 배열의 모든 요소 출력
    for (int item: arr) {
      System.out.println("item = " + item);
    }
    
    // 배열의 특정 인덱스 값 변경
    arr[1] = 100;
    // 배열 전체 출력 (주의: 이는 배열의 참조값을 출력합니다)
    System.out.println("arr = " + arr);

    // 2차원 배열 예제
    System.out.println("== 2차원 배열 ==");
    // 정수형 2차원 배열 선언 및 초기화
    int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
    
    // 2차원 배열의 특정 요소 접근 및 출력
    System.out.println(arr2[0][1]);
    
    // 중첩된 향상된 for문을 사용하여 2차원 배열의 모든 요소 출력
    for(int[] row: arr2) {
      for(int item: row) {
        System.out.println("item = " + item);
      }
    }

    // ArrayList 예제 - 1차원, 2차원
    System.out.println("== ArrayList ==");
    // 1차원 ArrayList 생성 및 초기화
    ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
    System.out.println("list1 = " + list1);
    
    // ArrayList에 요소 추가
    list1.add(4);
    list1.add(5);
    System.out.println("list1 = " + list1);
    
    // ArrayList에서 인덱스로 요소 제거
    list1.remove(2);
    System.out.println("list1 = " + list1);
    
    // ArrayList에서 값으로 요소 제거
    list1.remove(Integer.valueOf(2));
    System.out.println("list1 = " + list1);

    // 2차원 ArrayList 생성
    ArrayList list2d = new ArrayList();
    ArrayList list1d1 = new ArrayList(Arrays.asList(1, 2, 3));
    ArrayList list1d2 = new ArrayList(Arrays.asList(4, 5, 6));
    
    // 2차원 ArrayList에 1차원 ArrayList 추가
    list2d.add(list1d1);
    list2d.add(list1d2);
    
    // 각 ArrayList 출력
    System.out.println("list1d1 = " + list1d1);
    System.out.println("list1d2 = " + list1d2);
    System.out.println("list2d = " + list2d);
  }
}