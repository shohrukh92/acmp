/*
http://acmp.ru/index.asp?main=task&id_task=88
Судоку размера n называется квадрат со стороной n2, разделенный на n2 средних квадратов со стороной n, каждый из которых разделен на n2 маленьких квадратов. В каждом маленьком квадрате записано число от 1 до n2.

Судоку называется правильным, если в каждом столбце, каждой строке и каждом среднем квадрате встречаются все числа от 1 до n2.

Недавно Вася нарисовал Судоку размера n. Ваша задача – помочь ему определить правильный ли он.

Входные данные
В первой строке входного файла INPUT.TXT содержится число n (1 ≤ n ≤ 10). В следующих n2 строчках содержится по n2 чисел, задающих нарисованный Васей Судоку.

Все числа во входном файле натуральные и не превосходят 100 по модулю.

Выходные данные
Если Судоку правильный, то выведите в выходной файл OUTPUT.TXT слово «Correct», иначе выведите «Incorrect».
*/

import java.io.*;
import java.util.Scanner;
 
public class Main {
    public static int arr[][];
    public static int num[];
    public static int n;
     
    public static boolean CheckRow(int row){
        int j;
        for (j=0; j<n*n; j++)
            num[j] = 0;
         
        for (j=0; j<n*n; j++)
            num[ arr[row][j]-1 ]++;
         
        for (j=0; j<n*n; j++)
            if (num[j] != 1)
                return false;
         
        return true;
    }   
     
    public static boolean CheckCol(int col){
        int j;
        for (j=0; j<n*n; j++)
            num[j] = 0;
         
        for (j=0; j<n*n; j++)
            num[ arr[j][col]-1 ]++;
         
        for (j=0; j<n*n; j++)
            if (num[j] != 1)
                return false;
         
        return true;
    }
     
    public static boolean CheckSq(int ii, int jj){
        int j,i;
        for (j=0; j<n*n; j++)
            num[j] = 0;
         
        for (i=ii; i<ii+n; i++)
            for (j=jj; j<jj+n; j++)
                num[ arr[i][j]-1 ]++;
         
        for (j=0; j<n*n; j++)
            if (num[j] != 1)
                return false;
         
        return true;
    }
     
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
                 
        int i,j;
        n = sc.nextInt();
         
        arr = new int[n*n][n*n];
        num = new int[n*n];
         
        for (i=0; i<n*n; i++){
            for (j=0; j<n*n; j++){
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > n*n){
                    pw.print("Incorrect");
                    pw.close();
                    return;
                }
            }
            if (!CheckRow(i)){
                pw.print("Incorrect");
                pw.close();
                return;
            }
        }
         
        for (j=0; j<n*n; j++){
            if (!CheckCol(j)){
                pw.print("Incorrect");
                pw.close();
                return;
            }
        }
         
        for (i = 0; i < n*n; i = i + n)
            for ( j = 0; j < n*n; j = j + n)
                if (!CheckSq(i, j)){
                    pw.print("Incorrect");
                    pw.close();
                    return;
                }
         
        pw.print("Correct");
         
        sc.close();
        pw.close();
    }
}