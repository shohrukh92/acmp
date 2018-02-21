/*
http://acmp.ru/index.asp?main=task&id_task=686
Требуется написать программу, которая в массиве из n целых чисел наименьший элемент поместит на первое место, наименьший из оставшихся – на последнее, следующий по величине – на второе место, следующий – на предпоследнее и так далее – до середины массива.

Входные данные
Во входном файле INPUT.TXT записано в первой строке число n (1 ≤ n ≤ 30000). Во второй строке записаны через пробел элементы массива, числа по абсолютной величине не большие 32767.

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести элементы полученного массива, разделенные одним пробелом.
*/
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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
        int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int k = n/2;
        Arrays.sort(arr);
 
        int ini[] = new int[n];
        int fin[] = new int[n];
        int l = 0;
        int r = 0;
        for(int i=0; i<n-1; i+=2){
            ini[l++] = arr[i];
            fin[r++] = arr[i+1];
        }
        for(int i=0; i<k; i++) pw.print(ini[i] + " ");
        if (n%2 != 0) pw.print(arr[n-1] + " ");
        for(int i=0; i<k; i++) pw.print(fin[k-i-1] + " ");
 
        pw.println();
        pw.close();
    }
 
 
}