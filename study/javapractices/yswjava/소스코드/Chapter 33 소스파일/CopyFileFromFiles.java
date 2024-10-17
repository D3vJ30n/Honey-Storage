package study.javapractices.yswjava.소스코드.Chapter

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

class CopyFileFromFiles {
    public static void main(String[] args) throws IOException {
        Path src = Paths.get("C:\\JavaStudy\\CopyFileFromFiles.java");
        Path dst = Paths.get("C:\\JavaStudy\\CopyFileFromFiles2.java");
        
        // src�� �����ϴ� ������ dst�� �����ϴ� �̸����� ����
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }
}

