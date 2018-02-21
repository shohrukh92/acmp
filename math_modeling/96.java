/*
http://acmp.ru/index.asp?main=task&id_task=96
Вини-Пух стоит на прямоугольном поле размером N×M клеток. В каждой клетке растет по одной ягоде. В начальный момент времени он стоит на левой верхней клетке. Он начинает собирать ягоды по верхнему краю поля. Если он доходит до края поля или до пустой клетки, он поворачивается на 90 градусов вправо и продолжает собирать ягоды. Но дойдя до очередной клетки Вини вспоминает, что его ждет Пятачок, и он уходит с поля.

Входные данные
В первой строке входного файла INPUT.TXT стоят размеры поляны N и M (0 < N, M ≤ 100) – высота и ширина, во второй числа Y и X (0 < Y ≤ N, 0 < X ≤ M) –номера строки и столбца клетки, дойдя до которой Вини-Пух прекращает собирать ягоды.

Выходные данные
В выходной файл OUTPUT.TXT выведите число ягод, которые соберет Пух.
*/
import java.io.*;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    public int arr[][];
    public int r,c,ans;
    public char dir;
    public void run() throws IOException{
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
 
 
        int row = sc.nextInt();
        int col = sc.nextInt();
        arr = new int[row+2][col+2];
 
        int str = sc.nextInt();
        int stl = sc.nextInt();
        arr[str][stl] = 10;
        for(int i=0; i<row+2; i++) arr[i][0] = arr[i][col+1] = -1;
        for(int i=0; i<col+2; i++) arr[0][i] = arr[row+1][i] = -1;
 
        ans = 1;
        dir = 'r';
        r = c = 1;
        while (true){
            if (str == r && stl == c){
                pw.print(ans);
                break;
            }
            arr[r][c] = -1;
            go();
            ans++;
        }
 
        pw.close();
    }
 
    public void go(){
        switch (dir){
            case 'r':
                if (arr[r][c+1] == -1){
                    dir = 'd';
                    r++;
                }
                else{
                    c++;
                }
                break;
 
            case 'd':
                if (arr[r+1][c] == -1){
                    dir = 'l';
                    c--;
                }
                else{
                    r++;
                }
                break;
 
            case 'l':
                if (arr[r][c-1] == -1){
                    dir = 'u';
                    r--;
                }
                else{
                    c--;
                }
                break;
            case 'u':
                if (arr[r-1][c] == -1){
                    dir = 'r';
                    c++;
                }
                else{
                    r--;
                }
                break;
        }
    } 
}