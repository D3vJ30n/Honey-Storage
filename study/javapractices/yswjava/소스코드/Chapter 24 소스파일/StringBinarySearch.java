package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class StringBinarySearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Box");
        list.add("Robot");
        list.add("Apple");

        // ����
        Collections.sort(list);        

        // Ž��
        int idx = Collections.binarySearch(list, "Robot");
 
        // Ž�� ��� ���
        System.out.println(list.get(idx));
    }
}