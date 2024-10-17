// java.util 패키지에서 ArrayList와 Arrays 클래스를 임포트합니다.
// ArrayList는 동적 배열을 구현한 클래스이고, Arrays는 배열을 다루는 유틸리티 메서드를 제공합니다.
import java.util.ArrayList;
import java.util.Arrays;

public class peacticecodingtest.Main {
  public static void main(String[] args) {
    // 1차원 배열 예제
    System.out.println("== 1차원 배열 ==");
    // 정수형 1차원 배열을 선언하고 초기화합니다.
    // 중괄호 {}를 사용하여 배열의 요소를 직접 나열하는 방식으로 초기화합니다.
    int[] arr = {1, 2, 3, 4, 5};
    
    // 향상된 for문(enhanced for loop)을 사용하여 배열의 모든 요소를 순회하며 출력합니다.
    // 이 루프는 배열의 각 요소를 순서대로 item 변수에 할당하고, 블록 내의 코드를 실행합니다.
    for (int item: arr) {
      System.out.println("item = " + item);
    }
    
    // 배열의 특정 인덱스(1번 인덱스) 값을 100으로 변경합니다.
    // 배열의 인덱스는 0부터 시작하므로, arr[1]은 두 번째 요소를 가리킵니다.
    arr[1] = 100;
    // 배열 전체를 출력합니다. 
    // 주의: 이는 배열의 참조값(메모리 주소)을 출력하므로 실제 내용이 아닌 해시코드가 출력됩니다.
    // 배열의 실제 내용을 보려면 Arrays.toString(arr)을 사용해야 합니다.
    System.out.println("arr = " + arr);

    // 2차원 배열 예제
    System.out.println("== 2차원 배열 ==");
    // 정수형 2차원 배열을 선언하고 초기화합니다.
    // 이는 2행 3열의 배열을 생성합니다.
    int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
    
    // 2차원 배열의 특정 요소(0행 1열)에 접근하여 출력합니다.
    // arr2[0][1]은 첫 번째 행의 두 번째 열을 가리킵니다.
    System.out.println(arr2[0][1]);
    
    // 중첩된 향상된 for문을 사용하여 2차원 배열의 모든 요소를 순회하며 출력합니다.
    // 외부 루프는 각 행을 순회하고, 내부 루프는 각 행의 요소를 순회합니다.
    for(int[] row: arr2) {
      for(int item: row) {
        System.out.println("item = " + item);
      }
    }

    // ArrayList 예제 - 1차원, 2차원
    System.out.println("== ArrayList ==");
    // 1차원 ArrayList를 생성하고 초기화합니다.
    // Arrays.asList()를 사용하여 고정 크기 리스트를 생성하고, 이를 ArrayList의 생성자에 전달합니다.
    ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
    System.out.println("list1 = " + list1);
    
    // ArrayList에 새로운 요소들을 추가합니다.
    // add() 메서드를 사용하여 리스트의 끝에 요소를 추가합니다.
    list1.add(4);
    list1.add(5);
    System.out.println("list1 = " + list1);
    
    // ArrayList에서 인덱스(2번 인덱스)로 요소를 제거합니다.
    // remove(int index) 메서드는 지정된 인덱스의 요소를 제거합니다.
    list1.remove(2);
    System.out.println("list1 = " + list1);
    
    // ArrayList에서 값(2)으로 요소를 제거합니다.
    // Integer.valueOf()를 사용하여 기본 타입 int를 Integer 객체로 변환합니다.
    // remove(Object o) 메서드는 지정된 객체와 동일한 첫 번째 요소를 제거합니다.
    list1.remove(Integer.valueOf(2));
    System.out.println("list1 = " + list1);

    // 2차원 ArrayList를 생성합니다.
    // 이는 ArrayList를 요소로 갖는 ArrayList입니다.
    ArrayList list2d = new ArrayList();
    ArrayList list1d1 = new ArrayList(Arrays.asList(1, 2, 3));
    ArrayList list1d2 = new ArrayList(Arrays.asList(4, 5, 6));
    
    // 2차원 ArrayList에 1차원 ArrayList들을 추가합니다.
    // 각 1차원 ArrayList가 2차원 ArrayList의 한 '행'이 됩니다.
    list2d.add(list1d1);
    list2d.add(list1d2);
    
    // 각 ArrayList를 출력합니다.
    // ArrayList는 toString() 메서드가 오버라이드되어 있어 내용을 직접 출력할 수 있습니다.
    System.out.println("list1d1 = " + list1d1);
    System.out.println("list1d2 = " + list1d2);
    System.out.println("list2d = " + list2d);
  }
}