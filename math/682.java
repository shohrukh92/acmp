/*
http://acmp.ru/index.asp?main=task&id_task=682
По заданному n найти сумму всех n-значных чисел.

Входные данные
В единственной строке входного файла INPUT.TXT записано одно натуральное число n (1 ≤ n ≤ 100).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести все цифры суммы всех n-значных чисел.
*/
import java.io.*;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner in;
    PrintWriter out;
 
 
    public void run() throws IOException{
        in = new Scanner(new File("input.txt"));
        out = new PrintWriter(new File("output.txt"));
 
        int n = in.nextInt();
 
        /*
        3 ---> 494550
        4 ---> 49495500
        5 ---> 4949955000
         */
        String ans = "";
        switch (n){
            case 1:
                ans = "45";
                break;
            case 2:
                ans = "4905";
                break;
            default:
                int nines = n - 3;
                int zeros = n - 2;
                ans = "494";
                for(int i=0; i<nines; i++) ans += "9";
                ans += "55";
                for(int i=0; i<zeros; i++) ans += "0";
                break;
        }
        out.print(ans);
 
        out.close();
    }
}