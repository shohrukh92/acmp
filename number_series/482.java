/*
http://acmp.ru/index.asp?main=task&id_task=482
Дано целое число N. Рассмотрим последовательность S1S2S3...Sk..., где каждая группа цифр Sk состоит из записанных одно за другим чисел от 1 до k. Например, первые 75 цифр последовательности выглядят так:

112123123412345123456123456712345678123456789123456789101234567891011123456.

Требуется написать программу, которая определит: какая цифра находится на N-ой позиции в построенной последовательности.

Входные данные
Входной файл INPUT.TXT содержит одно число N (0 < N < 32768).

Выходные данные
В выходной файл OUTPUT.TXT выведите цифру, которая стоит на N-ой позиции в последовательности.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    public static void add(int[] arr, int x, int pos){
        String sx = String.valueOf(x);
 
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
 
        int N = sc.nextInt();
        ArrayList<Integer> digits = new ArrayList<Integer>();
        boolean ans = false;
        for(int k=1; ; k++){
            if (ans) break;
            for(int i=1; i<=k; i++){
                if (ans) break;
                String si = Integer.toString(i);
                for(int j=0; j<si.length(); j++){
                    int digit = Integer.parseInt(si.charAt(j)+"");
                    digits.add(digit);
                    if (digits.size() == N) {
                        ans = true;
                        pw.print(digit);
                        break;
                    }
                }
            }
        }
 
        sc.close();
        pw.close();
    }
}