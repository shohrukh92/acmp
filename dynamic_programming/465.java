/*
http://acmp.ru/index.asp?main=task&id_task=465
Рассмотрим последовательности длины N, состоящие из 0 и 1. Требуется написать программу, которая по заданному натуральному числу N определяет количество тех из них, в которых никакие две единицы не стоят рядом.

Входные данные
Входной файл INPUT.TXT содержит число N (1 ≤ N ≤ 1000).

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
*/
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner sc;
    PrintWriter pw;
 
 
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int n = sc.nextInt();
        if (n == 1) pw.print(2);
        else {
            BigInteger f0 = new BigInteger("1");
            BigInteger f1 = new BigInteger("2");
            BigInteger f2 = new BigInteger("2");
 
            for(int i=2; i<=n; i++){
                f2 = f1.add(f0);
                f0 = f1;
                f1 = f2;
            }
            pw.print(f2);
        }
 
        pw.close();
    }
 
}