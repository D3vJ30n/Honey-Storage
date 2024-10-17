package study.javapractices.yswjava.문제의

import java.util.Scanner;
import java.util.Random;

class RandomBetween {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("�Է�1: ");
        int A = keyboard.nextInt();
        
        System.out.print("�Է�2: ");
        int Z = keyboard.nextInt();

        int min, max; 

        if(A > Z) {
            min = Z;
            max = A;
        } 
        else {
            min = A;
            max = Z;
        }

        Random rand = new Random();
        int rn;
   
        for(int i = 0; i < 10; i++) {
           rn = min;
           rn += rand.nextInt(max - min + 1);
           System.out.println(rn);
        }
    }
}
