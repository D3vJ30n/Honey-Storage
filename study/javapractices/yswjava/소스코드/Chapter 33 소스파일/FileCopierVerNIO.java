package study.javapractices.yswjava.소스코드.Chapter

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

class FileCopierVerNIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("��� ����: ");
        Path src = Paths.get(sc.nextLine());
        
        System.out.print("�纻 �̸�: ");
        Path dst = Paths.get(sc.nextLine());

        // ���� ����
        ByteBuffer buf = ByteBuffer.allocate(1024);
 
        // try(�� ���� ä�� ����)
        try(FileChannel ifc = 
                FileChannel.open(src, StandardOpenOption.READ); 
            FileChannel ofc = 
                FileChannel.open(dst, StandardOpenOption.WRITE, 
                                      StandardOpenOption.CREATE)) {
            int num;

            while(true) {
                num = ifc.read(buf);    // ifc�κ��� ���۷� �о� ����
                if(num == -1)
                    break; 
                
                buf.flip();     // ���ۿ��� ������ ������ ���� ����!
                ofc.write(buf);     // ���ۿ��� ofc�� ������ ����            
                buf.clear();    // ���� ����
            }
        }
        catch(IOException e) {
            e.printStackTrace();       
        }
    }
}

