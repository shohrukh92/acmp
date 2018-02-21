/*
http://acmp.ru/index.asp?main=task&id_task=173
Напомним, что палиндромом называется строка, одинаково читающаяся с обеих сторон. Например, строка «ABBA» является палиндромом, а строка «ABC» - нет.

Необходимо определить, в каких системах счисления с основанием от 2 до 36 представление заданного числа N является палиндромом.

В системах счисления с основанием большим 10 в качестве цифр используются буквы английского алфавита: A, B, ... , Z. Например, A11 = 1010, Z36 = 3510.

Входные данные
Входной файл INPUT.TXT содержит заданное число N в десятичной системе счисления (1 ≤ N ≤ 109).

Выходные данные
Если соответствующее основание системы счисления определяется единственным образом, то выведите в первой строке выходного файла OUTPUT.TXT слово «unique», если оно не единственно — выведите в первой строке выходного файла слово «multiple». Если же такого основания системы счисления не существует — выведите в первой строке выходного файла слово «none».

В случае существования хотя бы одного требуемого основания системы счисления выведите через пробел в возрастающем порядке во второй строке выходного файла все основания системы счисления, удовлетворяющие требованиям.
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
        ArrayList<Integer> bases = new ArrayList<Integer>();
        for(int i=2; i<=36; i++){
            String s = Integer.toString(n, i);
            if (isPal(s)) bases.add(i);
        }
        int size = bases.size();
        if (size == 0){
            pw.print("none");
        }
        else if (size == 1){
            pw.println("unique");
            pw.print(bases.get(0));
        }
        else {
            pw.println("multiple");
            for (Integer base : bases) pw.print(base + " ");
        }
        pw.close();
    }
 
    public boolean isPal(String s){
        String x = new StringBuilder(s).reverse().toString();
        return s.equals(x);
    }
}