package study.javapractices;

import java.util.Arrays; // Arrays 클래스를 사용하기 위해 임포트
import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 임포트

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성으로 입력을 받을 준비를 함

        int N = scanner.nextInt(); // 정수의 개수를 입력받아 배열의 크기를 설정
        int[] numbers = new int[N]; // 입력받은 크기 N의 배열을 생성하여 사용할 준비를 함

        // 사용자로부터 N개의 정수를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt(); // 각 입력된 정수를 배열의 i번째 위치에 저장
        }

        // 스트림(Stream)을 사용하여 배열에서 최솟값과 최댓값을 찾는 부분
        // 스트림(Stream)은 데이터 요소들의 흐름으로, 데이터 처리 작업을 함수형 스타일로 수행할 수 있게 해준다.
        // 배열, 컬렉션 등 다양한 데이터 소스를 스트림으로 변환하여 반복적인 작업을 쉽게 처리할 수 있다.

        // Arrays.stream(numbers): 배열(numbers)을 스트림으로 변환하여 처리할 준비를 한다.
        // min(): 스트림 내의 요소들 중에서 최솟값을 계산하여 OptionalInt로 반환
        // getAsInt(): OptionalInt에서 실제 정수 값을 추출합니다.
        int min = Arrays.stream(numbers).min().getAsInt(); // 배열에서 최솟값을 찾기

        // Arrays.stream(numbers): 배열(numbers)을 스트림으로 변환하여 처리할 준비를 한다..
        // max(): 스트림 내의 요소들 중에서 최댓값을 계산하여 OptionalInt로 반환
        // getAsInt(): OptionalInt에서 실제 정수 값을 추출
        int max = Arrays.stream(numbers).max().getAsInt(); // 배열에서 최댓값을 찾기

        // 최솟값과 최댓값을 공백으로 구분하여 출력
        System.out.println(min + " " + max);
    }
}