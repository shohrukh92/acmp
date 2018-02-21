/*
http://acmp.ru/index.asp?main=task&id_task=135
Полный ориентированный взвешенный граф задан матрицей смежности. Постройте матрицу кратчайших путей между его вершинами. Гарантируется, что в графе нет циклов отрицательного веса.

Входные данные
В первой строке входного файла INPUT.TXT записано единственное число N (1 ≤ N ≤ 100) - количество вершин графа. В следующих N строках по N чисел - матрица смежности графа (j-ое число в i-ой строке соответствует весу ребра из вершины i в вершину j). Все числа по модулю не превышают 100. На главной диагонали матрицы - всегда нули.

Выходные данные
В выходной файл OUTPUT.TXT выведите N строк по N чисел - матрицу кратчайших расстояний между парами вершин. j-ое число в i-ой строке должно быть равно весу кратчайшего пути из вершины i в вершину j.
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int n = sc.nextInt();
        int d[][] = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                d[i][j] = sc.nextInt();
 
        for (int k=0; k<n; ++k)
            for (int i=0; i<n; ++i)
                for (int j=0; j<n; ++j)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
 
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                pw.print(d[i][j] + " ");
            pw.println();
        }
 
        pw.close();
    }
}