package study.javapractices.yswjava.소스코드.Chapter

import java.util.List;
import java.util.LinkedList;

class EnhancedForCollection {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        
        // �ν��Ͻ� ���� 
        list.add("Toy");
        list.add("Box");
        list.add("Robot");
	
        // �ν��Ͻ� ����
        for(String s : list)
            System.out.print(s + '\t');
        System.out.println();
		
        // ù ��° �ν��Ͻ� ����
        list.remove(0);
   
        // ���� �� �ν��Ͻ� ����
        for(String s : list)
            System.out.print(s + '\t');
        System.out.println();
    }
}