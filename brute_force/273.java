/*
http://acmp.ru/index.asp?main=task&id_task=273
Задано натуральное число N. Требуется написать программу, вычисляющую количество различных трехзначных чисел получающихся из N вычеркиванием цифр из его десятичной записи.

Входные данные
Входной текстовый файл INPUT.TXT содержит одно натуральное число N (1 ≤ N ≤ 10100).

Выходные данные
Выходной текстовый файл OUTPUT.TXT должен содержать одно целое число - найденное количество трехзначных чисел.
*/


import java.io.*;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
 
        int numbers[] = new int[10000];
        String s = sc.nextLine();
        int len = s.length();
        int a1, a2, a3;
        int ans = 0;
        if (len < 3) ans = 0;
        else {
            for (int i=0; i<len-2; i++){
                a1 = (int)s.charAt(i)-48;
                for(int j=i+1; j<len-1; j++){
                    a2 = (int)s.charAt(j)-48;
                    for(int k=j+1; k<len; k++){
                        a3 = (int)s.charAt(k)-48;
                        a3 = a1*100 + a2*10 + a3;
                        if (a3 > 99 && numbers[a3] == 0) {
                            ans++;
                            numbers[a3]++;
                        }
                    }
                }
            }
        }
        pw.println(ans);
 
        sc.close();
        pw.close();
    }
}