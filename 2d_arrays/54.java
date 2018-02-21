/*
http://acmp.ru/index.asp?main=task&id_task=54
Одним из интересных объектов, изучаемых в теории игр, являются так называемые антагонистические игры двух лиц. Такие игры характеризуются множеством X стратегий первого игрока, множеством Y стратегий второго игрока и функцией выигрыша K(x, y) (x из X, y из Y). Если множества стратегий X и Y конечны, то такую игру принято называть матричной, так как функцию выигрыша K в этом случае удобно задавать матрицей.

Рассмотрим матричную игру, в которой X = {1,…,n}, Y = {1,…,m}. Матрицу выигрышей обозначим символом K. Нижним значением игры назовем число maxi=1..nminj=1..m Kij . Верхним значением игры назовем число minj=1..mmaxi=1..n Kij. Отметим также, что игры, у которых нижнее и верхнее значение совпадают, называются играми с седловой точкой.

Задана матрица выигрышей K для некоторой матричной игры. Найдите ее верхнее и нижнее значение.

Входные данные
Первая строка входного файла INPUT.TXT содержит целые числа n и m (1 ≤ n,m ≤ 100). Далее следуют n строк по m чисел в каждой. j-ое число i-ой строки равно Kij . Все Kij по модулю не превосходят 1000.

Выходные данные
В выходной файл OUTPUT.TXT выведите нижнее и верхнее значение игры через пробел.
*/

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int n = sc.nextInt();
        int m = sc.nextInt();
        int K[][] = new int[n+1][m+1];
        int i,j,min,max;
        for(i=1; i<=n; i++)
            for(j=1; j<=m; j++)
                K[i][j] = sc.nextInt();
 
        int MIN = -2000000;
        for(i=1; i<=n; i++){
            int mini = 1000000;
            for(j=1; j<=m; j++){
                if (K[i][j] < mini){ mini = K[i][j]; }
            }
            if (mini > MIN) MIN = mini;
        }
        pw.print(MIN + " ");
 
 
 
        MIN = 2000000;
        for(j=1; j<=m; j++){
            int mini = -1000000;
            for(i=1; i<=n; i++){
                if (K[i][j] > mini){ mini = K[i][j]; }
            }
            if (mini < MIN) MIN = mini;
        }
        pw.print(MIN);
        pw.close();
    }
}