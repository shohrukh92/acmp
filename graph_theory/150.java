/*
http://acmp.ru/index.asp?main=task&id_task=150
В клубе N человек. Многие из них - друзья. Так же известно, что друзья друзей так же являются друзьями. Требуется выяснить, сколько всего друзей у конкретного человека в клубе.

Входные данные
В первой строке входного файла INPUT.TXT заданы два числа: N и S (1 ≤ N ≤ 100; 1 ≤ S ≤ N), где N - количество человек в клубе, а S – номер конкретного человека. В следующих N строках записано по N чисел - матрица смежности, состоящая из единиц и нулей. Причем единица, стоящая в i-й строке и j-м столбце гарантирует, что люди с номерами i и j – друзья, а 0 – выражает неопределенность.

Выходные данные
В выходной файл OUTPUT.TXT выведите количество гарантированных друзей у человека с номером S, помня о транзитивности дружбы.
*/

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    int a[][];
    boolean b[];
    int k,n,s;
    public void dfs(int v){
        k++;
        b[v] = true;
        for (int i=0; i<n; i++)
            if(a[v][i]==1 && !b[i]) dfs(i);
    }
 
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n][n];
        b = new boolean[n];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                a[i][j] = sc.nextInt();
 
        k = -1;
        dfs(s-1);
        pw.print(k);
 
        pw.close();
    }
 
 
}