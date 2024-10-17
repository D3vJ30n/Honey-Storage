package study.javapractices.yswjava.소스코드.Chapter

import java.util.HashMap;

class HashMapCollection {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        
        // Key-Value ��� ������ ����
        map.put(45, "Brown");
        map.put(37, "James");
        map.put(23, "Martin");


        // ������ Ž��
        System.out.println("23��: " + map.get(23));
        System.out.println("37��: " + map.get(37));
        System.out.println("45��: " + map.get(45));
        System.out.println();

        // ������ ����
        map.remove(37);

        // ������ ���� Ȯ��
        System.out.println("37��: " + map.get(37));
    }
}