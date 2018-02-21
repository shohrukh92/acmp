/*
http://acmp.ru/index.asp?main=task&id_task=528
Замок состоит из K уровней. Каждый уровень - это правильный N-угольник, угол которого совпадает с углом предыдущего. На сторонах первого уровня находится по две комнаты (в углах), на сторонах каждого следующего - на одну больше. Сколько в замке комнат?

Входные данные
В первой строке входного файла INPUT.TXT указаны два целых числа N и K (3 ≤ N ≤ 106; 1 ≤ K ≤ 106).

Выходные данные
В выходной файл OUTPUT.TXT выведите целое число - количество комнат в замке.
*/
import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
 
public class Main {    
    public static void main(String[] a) throws IOException{
        Scanner sc = new Scanner( new File ("input.txt") );
        PrintWriter pw = new PrintWriter ( new File ("output.txt") );
         
        BigInteger N = new BigInteger( Integer.toString(sc.nextInt()) );
        BigInteger K = new BigInteger( Integer.toString(sc.nextInt()) );
        BigInteger E = new BigInteger("1");
        BigInteger D = new BigInteger("2");
         
        BigInteger A = E.add( K.multiply(N.subtract(E)) );
         
        BigInteger M = K.multiply( K.subtract(E) );
        M = M.multiply(N.subtract(D));
        M = M.divide(D);
         
        A = A.add(M);
         
        pw.print(A);
         
        sc.close();
        pw.close();
    }
}