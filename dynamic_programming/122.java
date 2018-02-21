/*
http://acmp.ru/index.asp?main=task&id_task=122
Дана числовая последовательность, требуется найти длину наибольшей возрастающей подпоследовательности.

Входные данные
В первой строке входного файла INPUT.TXT записано число N - длина последовательности (1 ≤ N ≤ 1000). Во второй строке записана сама последовательность (через пробел). Числа последовательности - целые числа, не превосходящие 10000 по модулю.

Выходные данные
В выходной файл OUTPUT.TXT требуется вывести наибольшую длину возрастающей подпоследовательности.
*/

import java.io.*;
import java.util.ArrayList;
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
 
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++) a[i] = sc.nextInt();
        final int MAXN = n+10;
        int d[] = new int[MAXN];
 
        for (int i=0; i<n; ++i) {
            d[i] = 1;
            for (int j=0; j<i; ++j)
                if (a[j] < a[i])
                    d[i] = Math.max (d[i], 1 + d[j]);
        }
 
        int ans = d[0];
        for (int i=0; i<n; ++i)
            ans = Math.max (ans, d[i]);
 
        pw.print(ans);
 
        pw.close();
    }
 
}