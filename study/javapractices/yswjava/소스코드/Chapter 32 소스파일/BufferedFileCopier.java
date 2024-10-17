package study.javapractices.yswjava.소스코드.Chapter

import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class BufferedFileCopier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("��� ����: ");
        String src = sc.nextLine();

        System.out.print("�纻 �̸�: ");
        String dst = sc.nextLine();

        try(InputStream in = new FileInputStream(src) ;
            OutputStream out = new FileOutputStream(dst)) {
            byte buf[] = new byte[1024];
            int len;

            while(true) {
                len = in.read(buf);             
                if(len == -1)
                    break;             
                out.write(buf, 0, len);
            }
        }
        catch(IOException e) {
            e.printStackTrace();       
        }
    }
}