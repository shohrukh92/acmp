/*
http://acmp.ru/index.asp?main=task&id_task=368
В таблице из N строк и N столбцов клетки заполнены цифрами от 0 до 9. Требуется найти такой путь из клетки (1, 1) в клетку (N, N), чтобы сумма цифр в клетках, через которые он пролегает, была минимальной; из любой клетки ходить можно только вниз или вправо.

Входные данные
В первой строке входного файла INPUT.TXT находится число N. В следующих N строках содержатся по N цифр без пробелов. (2 ≤ N ≤ 250)

Выходные данные
В выходной файл OUTPUT.TXT выведите N строк по N символов. Символ «#» (решетка) показывает, что маршрут проходит через эту клетку, а «.» (точка) - что не проходит. Если путей с минимальной суммой цифр несколько, можно вывести любой.
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
 
        int min,i,j,n = sc.nextInt();  sc.nextLine();
        int arr[][] = new int[n][n];
        int ans[][] = new int[n][n];
        char path[][] = new char[n][n];
        for(i=0; i<n; i++){
            String s = sc.nextLine();
            int len = s.length();
            for(j=0; j<len; j++){
                arr[i][j] = s.charAt(j)-48;
                path[i][j] = '.';
            }
        }
        ans[0][0] = arr[0][0];
        for(i=1; i<n; i++) ans[0][i] = ans[0][i-1] + arr[0][i];
        for(i=1; i<n; i++) ans[i][0] = ans[i-1][0] + arr[i][0];
 
        path[0][0] = path[n-1][n-1] = '#';
        for(i=1; i<n; i++){
            for (j=1; j<n; j++){
                if ( ans[i][j-1] < ans[i-1][j] ){
                    min = ans[i][j-1];
                }
                else{
                    min = ans[i-1][j];
                }
                ans[i][j] = min + arr[i][j];
            }
        }
 
        i = n-1;
        j = n-1;
        while (true){
            if (i==0 && j ==0) break;
            else if (i == 0){
                path[i][j-1] = '#';
                j--;
            }
            else if (j == 0){
                path[i-1][j] = '#';
                i--;
            }
            else if (ans[i][j-1] < ans[i-1][j]){
                path[i][j-1] = '#';
                j--;
            }
            else{
                path[i-1][j] = '#';
                i--;
            }
        }
 
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                pw.print(path[i][j]);
            }
            pw.println();
        }
 
        pw.close();
    }
 
}