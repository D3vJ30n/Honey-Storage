package study.javapractices;// 선형 자료구조 - 배열과 ArrayList 예제

// java.util 패키지에서 ArrayList와 Arrays 클래스를 import
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // 1차원 배열
        System.out.println("== 1차원 배열 ==");
        // int 타입의 1차원 배열 선언 및 초기화. 크기는 5이며 {1, 2, 3, 4, 5}로 초기화됨
        int[] arr = {1, 2, 3, 4, 5};
        // 향상된 for문(enhanced for loop)을 사용하여 배열의 모든 요소를 순회
        // int item은 arr 배열의 각 요소를 순서대로 참조
        for (int item: arr) {
            System.out.println("item = " + item);
        }

        // 배열의 두 번째 요소(인덱스 1)의 값을 100으로 변경
        arr[1] = 100;
        // 배열 객체 자체를 출력. 이는 배열의 메모리 주소를 나타내는 해시코드를 출력함
        System.out.println("arr = " + arr);


        // 2차원 배열
        System.out.println("== 2차원 배열 ==");
        // int 타입의 2차원 배열 선언 및 초기화. 2x3 크기의 배열이 생성됨
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        // 2차원 배열의 첫 번째 행(인덱스 0), 두 번째 열(인덱스 1)의 요소 출력. 결과는 2
        System.out.println(arr2[0][1]);

        // 중첩된 향상된 for문을 사용하여 2차원 배열의 모든 요소를 순회
        for(int[] row: arr2) {  // 외부 루프: 각 행(1차원 배열)을 순회
            for(int item: row) {  // 내부 루프: 각 행의 요소를 순회
                System.out.println("item = " + item);
            }
        }


        // ArrayList - 1차원, 2차원
        System.out.println("== ArrayList ==");
        // Integer 타입의 1차원 ArrayList 생성 및 초기화
        // Arrays.asList()를 사용하여 고정 크기의 List를 생성하고, 이를 ArrayList의 생성자에 전달
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("list1 = " + list1);
        // ArrayList의 끝에 새로운 요소 추가
        list1.add(4);
        list1.add(5);
        System.out.println("list1 = " + list1);
        // 인덱스를 사용하여 ArrayList에서 세 번째 요소(인덱스 2) 제거
        list1.remove(2);
        System.out.println("list1 = " + list1);
        // 값을 사용하여 ArrayList에서 요소 제거. Integer.valueOf()는 int를 Integer 객체로 변환
        list1.remove(Integer.valueOf(2));
        System.out.println("list1 = " + list1);

        // 2차원 ArrayList 생성. 실제로는 ArrayList를 요소로 갖는 ArrayList
        ArrayList list2d = new ArrayList();
        // 두 개의 1차원 ArrayList 생성 및 초기화
        ArrayList list1d1 = new ArrayList(Arrays.asList(1, 2, 3));
        ArrayList list1d2 = new ArrayList(Arrays.asList(4, 5, 6));
        // 1차원 ArrayList를 2차원 ArrayList의 요소로 추가
        list2d.add(list1d1);
        list2d.add(list1d2);
        // 각 ArrayList 출력
        System.out.println("list1d1 = " + list1d1);
        System.out.println("list1d2 = " + list1d2);
        System.out.println("list2d = " + list2d);
    }
}