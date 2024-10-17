package study.javapractices;// 기본 배열 자료형을 이용한 동적 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;  // Arrays 클래스를 사용하기 위한 import

class MyArray {
    int[] arr;  // 내부적으로 사용할 정수 배열. MyArray 클래스의 핵심 데이터 구조

    // 생성자: 배열의 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];  // 주어진 크기로 새 정수 배열을 생성하여 arr에 할당
    }

    // 배열에 데이터 삽입 메서드
    public void insertData(int index, int data) {
        // 유효하지 않은 인덱스 처리: 인덱스가 음수이거나 현재 배열 길이보다 큰 경우
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;  // 메서드 실행 종료
        }

        int[] arrDup = this.arr.clone();  // 현재 배열의 복제본 생성
        this.arr = new int[this.arr.length + 1];  // 크기가 1 더 큰 새 배열 생성

        // 삽입 위치 이전의 요소들 복사
        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];  // 새 배열에 기존 데이터 복사
        }

        // 삽입 위치 이후의 요소들 한 칸씩 뒤로 이동하며 복사
        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];  // 기존 데이터를 한 칸씩 뒤로 밀어서 복사
        }

        this.arr[index] = data;  // 지정된 인덱스에 새로운 데이터 삽입
    }

    // 배열에서 특정 데이터 삭제 메서드
    public void removeData(int data) {
        int targetIndex = -1;  // 삭제할 데이터의 인덱스를 저장할 변수. -1은 데이터를 찾지 못했음을 의미

        // 삭제할 데이터의 인덱스 찾기
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == data) {
                targetIndex = i;  // 삭제할 데이터의 인덱스 저장
                break;  // 첫 번째로 발견된 데이터의 인덱스만 저장하고 루프 종료
            }
        }

        // 데이터를 찾지 못한 경우
        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        }
        else {
            int[] arrDup = this.arr.clone();  // 현재 배열의 복제본 생성
            this.arr = new int[this.arr.length - 1];  // 크기가 1 더 작은 새 배열 생성

            // 삭제할 요소 이전의 데이터 복사
            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];  // 새 배열에 기존 데이터 복사
            }

            // 삭제할 요소 이후의 데이터를 한 칸씩 앞으로 이동하며 복사
            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];  // 삭제할 요소 다음 데이터부터 복사
            }
        }
    }
}

public class Practice {
    public static void main(String[] args) {
        // 테스트 코드
        int size = 5;
        MyArray myArray = new MyArray(size);  // 크기가 5인 MyArray 객체 생성

        // 배열 초기화: 1부터 5까지의 숫자로 배열 채우기
        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));   // [1, 2, 3, 4, 5] 출력

        // 배열의 첫 번째 요소 변경
        myArray.arr[0] = 10;  // 인덱스 0의 값을 10으로 변경
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 3, 4, 5] 출력

        // 데이터 삽입 테스트
        myArray.insertData(2, 20);  // 인덱스 2에 20 삽입
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5] 출력

        myArray.insertData(6, 60);  // 배열 끝에 60 삽입
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5, 60] 출력

        myArray.insertData(-1, 0);  // 잘못된 인덱스 (-1)에 삽입 시도. "Index Error" 출력

        // 데이터 삭제 테스트
        myArray.removeData(4);  // 값 4 삭제
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 5, 60] 출력

        myArray.removeData(5);  // 값 5 삭제
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 60] 출력

        myArray.removeData(99); // 존재하지 않는 값 삭제 시도. "해당 데이터가 없습니다." 출력
    }
}