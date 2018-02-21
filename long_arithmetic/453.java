/*
http://acmp.ru/index.asp?main=task&id_task=453
Для заданного натурального числа N требуется найти число, состоящее только из цифр 1 и 2, которое делилось бы на 2^N.

Входные данные
Входной файл INPUT.TXT содержит натуральное число N, не превосходящее 300.

Выходные данные
В выходной файл OUTPUT.TXT выведите искомое число, состоящее не более чем из 10 000 цифр.
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
 
        int k,n = sc.nextInt();
        String ans = "2";
        BigInteger two = new BigInteger("2");
        for(k=2; k<=n; k++){
            BigInteger testAns = new BigInteger("1" + ans);
            BigInteger testPow = two.pow(k);
            if (testAns.remainder(testPow).equals(BigInteger.ZERO)) {
                ans = "1" + ans;
            }
            else {
                ans = "2" + ans;
            }
        }
        pw.print(ans);
 
        pw.close();
    }
}