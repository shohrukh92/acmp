/*
TODO has Time limit exceeded error, it should be optimized
http://acmp.ru/index.asp?main=task&id_task=475
Задана последовательность натуральных чисел из диапазона [1, 2147483647]. Необходимо определить: можно ли выстроить эти числа в отрезок арифметической прогрессии. При необходимости порядок чисел в последовательности можно изменять.

Требуется написать программу для решения этой задачи.

Входные данные
Входной файл INPUT.TXT содержит последовательность натуральных чисел. Количество чисел в последовательности может быть от 2 до 100 000. Числа в файле разделены пробелами или символами перехода на новую строку.

Выходные данные
Выходной файл OUTPUT.TXT должен содержать либо «Yes» в случае положительного ответа, либо «No» в противоположном случае.
*/

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner in;
    PrintWriter out;
    public int arr[];
    public int len;
    public void insert(int x){
        int j = len-1;
        while(j>-1 && arr[j] > x){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = x;
        len++;
    }
    public void run() throws IOException{
        in = new Scanner(new File("input.txt"));
        out = new PrintWriter(new File("output.txt"));
 
        arr = new int[100010];
        len = 0;
        while(in.hasNext()){
            int curr = in.nextInt();
            insert(curr);
        }
 
        int d = arr[1] - arr[0];
        String ans = "Yes";
        for(int i=2; i<len; i++){
            if (arr[i] - arr[i-1] != d) {
                ans = "No";
                break;
            }
        }
        out.print(ans);
        out.close();
    }
}