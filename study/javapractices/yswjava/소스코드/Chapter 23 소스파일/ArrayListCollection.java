package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.ArrayList;

class ArrayListCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        // �ν��Ͻ� ���� 
        list.add("Toy");
        list.add("Box");
        list.add("Robot");
	
        // �ν��Ͻ� ����
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + '\t');
        System.out.println();
		
        // ù ��° �ν��Ͻ� ����
        list.remove(0);
   
        // ���� �� �ν��Ͻ� ����
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + '\t');
        System.out.println();
    }
}
