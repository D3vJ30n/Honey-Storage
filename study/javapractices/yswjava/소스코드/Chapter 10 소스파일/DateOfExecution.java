package study.javapractices.yswjava.소스코드.Chapter

import java.time.LocalDate;

class DateOfExecution {
    static String date;
    
    static {
        LocalDate nDate = LocalDate.now();
        date = nDate.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(date);    
    }
}
