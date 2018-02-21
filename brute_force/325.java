/*
http://acmp.ru/index.asp?main=task&id_task=325
Заданы две клетки шахматной доски. Требуется определить, возможно ли попасть из одной клетки в другую одним ходом шахматного коня, а если нет, то следует выяснить, возможно ли попасть с помощью двух ходов.

Входные данные
Входной файл INPUT.TXT содержит координаты двух клеток в общепринятом формате: каждая координата записывается как английская строчная буква и цифра, координаты отделены друг от друга запятой и пробелом.

Выходные данные
Выходной файл OUTPUT.TXT должен содержать цифру «1», если возможно из одной клетки в другую попасть за 1 ход, либо цифру «2», если попасть можно за 2 хода, либо «NO», если одна клетка недостижима из другой ни за 1 ни за 2 хода.
*/

import java.io.*;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner sc;
    PrintWriter pw;
    int arr[][] = new int[12][12];
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        String line = sc.nextLine();
        int x1 = line.charAt(0) - 95;
        int y1 = line.charAt(1) - 47;
 
        int x2 = line.charAt(4) - 95;
        int y2 = line.charAt(5) - 47;
 
        fill(x1,y1, 1);
        if (check(x2,y2, 1)) {
            pw.print(1);
        }
        else{
            for(int i=2; i<10; i++){
                for(int j=2; j<10; j++){
                    if (arr[i][j] == 1){ fill(i,j,2); }
                }
            }
            if (check(x2,y2, 2)) pw.print(2);
            else pw.print("NO");
        }
 
        pw.close();
    }
    public boolean check(int x2, int y2, int ind){
        for(int i=2; i<10; i++){
            for(int j=2; j<10; j++){
                if (arr[i][j] == ind && i == x2 && j == y2) {
                    return true;
                }
            }
        }
        return false;
    }
    public void fill(int x, int y, int ind){
        arr[x+2][y+1] = ind;
        arr[x+2][y-1] = ind;
        arr[x-2][y+1] = ind;
        arr[x-2][y-1] = ind;
        arr[x+1][y+2] = ind;
        arr[x+1][y-2] = ind;
        arr[x-1][y+2] = ind;
        arr[x-1][y-2] = ind;
    }
}