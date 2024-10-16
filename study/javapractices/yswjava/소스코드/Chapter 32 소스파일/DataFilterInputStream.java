package study.javapractices.yswjava.소스코드.Chapter

import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataInputStream;

class DataFilterInputStream {
    public static void main(String[] args) {
        try(DataInputStream in = 
                 new DataInputStream(new FileInputStream("data.dat"))) {
            int num1 = in.readInt();
            double num2 = in.readDouble();
        
            System.out.println(num1);
            System.out.println(num2);
        }
        catch(IOException e) {
            e.printStackTrace();       
        }
    }
}