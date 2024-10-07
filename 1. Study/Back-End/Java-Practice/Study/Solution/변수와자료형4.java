import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Basic_02_4 {
    public static void main(String[] args) {

        // 1. 자료형 - 리스트 (ArrayList)
        System.out.println("== 리스트 ==");
        ArrayList l1 = new ArrayList();  // 타입을 지정하지 않은 ArrayList 생성

        // 1-1. add 메소드: 리스트에 요소 추가
        l1.add(2);  // 정수 추가
        l1.add("hello");  // 문자열 추가
        l1.add(3);
        l1.add(4);
        l1.add("world");
        System.out.println("l1 = " + l1);  // 리스트의 모든 요소 출력

        l1.add(0, 1);  // 인덱스 0 위치에 1 삽입
        System.out.println("l1 = " + l1);

        // 1-2. get 메소드: 특정 인덱스의 요소 가져오기
        System.out.println(l1.get(0));  // 첫 번째 요소 출력
        System.out.println(l1.get(1));  // 두 번째 요소 출력

        // 1-3. size 메소드: 리스트의 크기(요소 개수) 반환
        System.out.println(l1.size());

        // 1-4. remove 메소드: 요소 제거
        l1.remove(1);  // 인덱스 1의 요소 제거
        System.out.println("l1 = " + l1);

        l1.remove(Integer.valueOf(1));  // 값이 1인 요소 제거
        System.out.println("l1 = " + l1);

        l1.remove("hello");  // 문자열 "hello" 제거
        System.out.println("l1 = " + l1);

        // 1-5. clear 메소드: 리스트의 모든 요소 제거
        l1.clear();
        System.out.println("l1 = " + l1);

        // 1-6. sort 메소드: 리스트 정렬
        ArrayList l2 = new ArrayList();
        l2.add(5);
        l2.add(3);
        l2.add(4);
        System.out.println("l2 = " + l2);

        l2.sort(Comparator.naturalOrder());  // 오름차순 정렬
        System.out.println("l2 = " + l2);

        l2.sort(Comparator.reverseOrder());  // 내림차순 정렬
        System.out.println("l2 = " + l2);

        // 1-7. contains 메소드: 리스트에 특정 요소가 있는지 확인
        System.out.println(l2.contains(1));  // false
        System.out.println(l2.contains(3));  // true

        // 2. Maps (HashMap)
        System.out.println("== Maps ==");
        HashMap map = new HashMap();  // 타입을 지정하지 않은 HashMap 생성

        // 2-1. put 메소드: 키-값 쌍 추가
        map.put("kiwi", 9000);
        map.put("apple", 10000);
        map.put("mango", 12000);
        System.out.println("map = " + map);

        // 2-2. get 메소드: 키에 해당하는 값 가져오기
        System.out.println(map.get("mandarin"));  // 없는 키: null 반환
        System.out.println(map.get("apple"));  // 10000

        // 2-3. size 메소드: 맵의 크기(키-값 쌍의 개수) 반환
        System.out.println(map.size());

        // 2-4. remove 메소드: 키-값 쌍 제거
        System.out.println(map.remove("hi"));  // 없는 키: null 반환
        System.out.println(map.remove("mango"));  // 12000 반환 및 제거
        System.out.println("map = " + map);

        // 2-5. containsKey 메소드: 특정 키가 맵에 있는지 확인
        System.out.println(map.containsKey("mango"));  // false
        System.out.println(map.containsKey("kiwi"));  // true

        // 3. Generics (제네릭스)
        System.out.println("== Generics ==");
        ArrayList l3 = new ArrayList();  // 제네릭 타입 미지정
        l3.add(1);
        l3.add("hello");  // 다양한 타입 추가 가능
        System.out.println("l3 = " + l3);

        ArrayList<String> l4 = new ArrayList<String>();  // String 타입으로 제한
        // l4.add(1);  // 컴파일 에러: Integer 추가 불가
        l4.add("hello");  // String만 추가 가능

        HashMap map2 = new HashMap();  // 제네릭 타입 미지정
        map2.put(123, "id");
        map2.put("apple", 10000);  // 다양한 타입의 키와 값 사용 가능
        System.out.println("map2 = " + map2);

        HashMap<String, Integer> map3 = new HashMap<String, Integer>();  // 키는 String, 값은 Integer로 제한
        // map3.put(123, "id");  // 컴파일 에러: 타입 불일치
        map3.put("apple", 10000);  // String 키, Integer 값만 가능
        System.out.println("map3 = " + map3);
    }
}