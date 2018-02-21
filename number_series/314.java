/*
http://acmp.ru/index.asp?main=task&id_task=314
Натуральные числа от 1 до N упорядочены лексикографически. Например, для N=25 результат этого упорядочения будет таким: 1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, 5, 6, 7, 8, 9.

Требуется написать программу, которая определит, на каком месте оказалось число K.

Входные данные
Входной файл INPUT.TXT содержит два натуральных числа N и K, записанных через пробел (1 ≤ K ≤ N ≤ 104).

Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно натуральное число – номер места, на котором оказалось число K.
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    public void run() throws IOException{
        sc = new Scanner( new File("input.txt") );
        pw = new PrintWriter( new File("output.txt") );
 
        int i,n = sc.nextInt();
        int k = sc.nextInt();
        String numbers[] = new String[n];
        for(i=0; i<n; i++) numbers[i] = String.valueOf(i+1);
        Arrays.sort(numbers);
 
        String sk = String.valueOf(k);
        for(i=0; i<n; i++){
            if (numbers[i].equals(sk)){ break; }
        }
 
        pw.print(i+1);
        pw.close();
    }
}