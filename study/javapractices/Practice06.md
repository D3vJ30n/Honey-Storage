# study.backend.javapractice.solution.lineards04.src.study.backend.javapractice.solution.lineards05.src.study.backend.javapractice.solution.lineards06.src.study.backend.javapractice.solution.lineards07.src.study.backend.javapractice.solution.lineards08.src.study.backend.javapractice.solution.lineards09.src.study.backend.javapractice.solution.lineards10.src.study.backend.javapractice.solution.lineards11.src.study.backend.javapractice.solution.lineards12.src.study.backend.javapractice.solution.lineards142.src.Practice1

## 문제 설명

로마 숫자 표기를 정수형으로 변환하는 프로그램을 작성하세요.

로마 숫자 표기법은 I, V, X, L, C, D, M 으로 이루어져있다.

| 로마 숫자 | 정수형 |
| --------- | ------ |
| I         | 1      |
| V         | 5      |
| X         | 10     |
| L         | 50     |
| C         | 100    |
| D         | 500    |
| M         | 1000   |

로마 숫자 표기 방식

- 큰 기호에서 작은 기호 방향으로 작성 (XI, VI, II, ...)
- 다음의 경우 작은 기호가 큰 기호 앞에 올 수 있다.
  - I 는 V 와 X 의 앞에 올 수 있다. (IV: 4, IX: 9)
  - X 는 L 과 C 의 앞에 올 수 있다. (XL: 40, XC: 90)
  - C 는 D 와 M 의 앞에 올 수 있다. (CD: 400, CM: 900)

## 입출력 예시

| 입력      | 출력 |
| --------- | ---- |
| "III"     | 3    |
| "IV"      | 4    |
| "VI"      | 6    |
| "XIII"    | 13   |
| "XXVI"    | 26   |
| "MCMXCIV" | 1994 |
