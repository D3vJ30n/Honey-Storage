package study.javapractices.yswjava.소스코드.Chapter

class EnhancedFor {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
       
        // �迭 ��� ��ü ���     
        for(int e: ar) {
            System.out.print(e + " ");
        }

        System.out.println();   // �� �ٲ��� ��������
   
    
        int sum = 0;
        
        // �迭 ����� ��ü �� ���     
        for(int e: ar) {
            sum += e;
        }
        
        System.out.println("sum: " + sum); 
    }
}