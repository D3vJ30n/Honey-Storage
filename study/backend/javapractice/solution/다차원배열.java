public class 다차원배열 {
    public static void main(String[] args) {
        // 1. 일차원 배열
        System.out.println("== 일차원 배열 ==");
        // 크기가 3인 정수형 배열을 선언하고 초기화
        // 배열 선언 시 중괄호를 사용하여 직접 값을 할당하는 방식
        int[] myArray = {1, 2, 3};
        // 배열의 첫 번째 요소(인덱스 0)를 출력
        System.out.println("myArray = " + myArray[0]);
        
        // 전통적인 for 루프를 사용한 배열 순회
        // 배열의 길이(length)를 사용하여 모든 요소에 접근
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
        
        // 향상된 for 루프(enhanced for loop)를 사용한 배열 순회
        // 더 간단하고 가독성이 좋은 방식으로 배열의 모든 요소에 접근
        for (int i : myArray) {
            System.out.println("i = " + i);
        }
        
        // 2. 이차원 배열
        System.out.println("== 이차원 배열 ==");
        // 2x3 크기의 이차원 배열 선언 및 초기화
        // 2개의 행과 3개의 열을 가진 행렬 형태의 데이터 구조
        int[][] myArray2 = {{1, 2, 3}, {4, 5, 6}};
        // 두 번째 행(인덱스 1)의 세 번째 열(인덱스 2)의 요소 출력
        System.out.println("myArray2 = " + myArray2[1][2]);
        
        // 중첩된 전통적 for 루프를 사용한 이차원 배열 순회
        // 외부 루프는 행을, 내부 루프는 열을 순회
        System.out.println("== myArray2 ==");
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2[i].length; j++) {
                System.out.println(myArray2[i][j]);
            }
        }
        
        // 중첩된 향상된 for 루프를 사용한 이차원 배열 순회
        // 더 간단한 방식으로 모든 요소에 접근
				for (int[] ints : myArray2) {
					for (int anInt : ints) {
						System.out.println("anInt = " + anInt);
					}
				}

				/* 2차원 배열의 구조에 따라 자연스럽게 각 행과 열을 순회하게끔 만들어진 것
				
				개발자가 직접 일일이 접근할 필요 없이,
						for-each 루프가 배열의 구조를 기반으로 알아서 모든 요소를 순서대로 접근
				
				그래서, 배열의 모든 데이터를 다루려면 이중 for-each 루프 같은 방식으로 자동으로 각 행과 열을 순회하게끔 설계됨.
				
				for (int anInt : ints)에서 :는 데이터의 타입을 말하는 것이 아니라,
						"향상된 for 루프" (또는 for-each 루프)에서 컬렉션이나 배열을 순회할 때 사용되는 구문
				
				의미
				:는 "in" 또는 "안에 있는"이라는 의미를 가지고 있음
				이 구문은 배열이나 컬렉션의 각 요소를 차례대로 순회하기 위해 사용
				
				for (int anInt : ints)는 ints 배열의 각 요소를 하나씩 순회하면서 그 값을 anInt라는 변수에 담아 처리하겠다는 의미
구체적으로
int anInt: 순회하는 배열 ints의 각 요소가 정수(int)이므로, 그 값을 저장할 변수 anInt의 타입도 int
ints: 순회할 배열의 이름입니다. 여기서는 1차원 배열인 ints를 순회
:: 이는 "배열 ints의 각 요소를 anInt에 담아 순회한다"는 뜻을 나타내는 구문적 연결어
				*/
        
        // Q1: 3x3 행렬 문제 해결
        // 모든 요소를 1로, 대각선 요소는 10으로 설정하는 문제
        int[][] testArray1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        
        // 이중 for 루프를 사용하여 배열의 모든 요소를 순회
        for (int i = 0; i < testArray1.length; i++) {
            for (int j = 0; j < testArray1[i].length; j++) {
                // 기본적으로 모든 요소를 1로 설정
                testArray1[i][j] = 1;
                // 행 인덱스와 열 인덱스가 같은 경우(대각선 요소) 10으로 설정
                if (i == j) {
                    testArray1[i][j] = 10;
                }
            }
        }
        
        // 향상된 for 루프를 사용하여 결과 출력
        // printf를 사용하여 행렬 형태로 깔끔하게 출력
        for (int[] itemRow : testArray1) {
            for (int itemCol : itemRow) {
                System.out.printf("%d ", itemCol);
            }
            // 각 행이 끝날 때마다 새 줄로 이동
            System.out.println();
        }
    }
}