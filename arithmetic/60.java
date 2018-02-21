/*
http://acmp.ru/index.asp?main=task&id_task=60
Простым числом будем называть натуральное число, большее единицы и делящееся только на единицу и на само себя. Выпишем все простые числа в порядке возрастания и i-ое в этом порядке число обозначим pi (число 2 при этом будет иметь номер 1). Так, например, p1 = 2, p2 = 3, p3 = 5, p52 = 239.

Скажем, что число pi является сверхпростым, если i = pk для некоторого k. Иными словами, сверхпростое число — это простое число, номер которого в списке простых чисел, упорядоченном по возрастанию, является простым числом.

Дано натуральное число k. Упорядочим все сверхпростые числа по возрастанию. Найдите k-ое сверхпростое число в этом порядке.

Входные данные
Входной файл INPUT.TXT содержит натуральное число k (1 ≤ k ≤ 500).

Выходные данные
В выходной файл OUTPUT.TXT выведите k-ое сверхпростое число.
*/
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner sc;
    PrintWriter pw;
 
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        final int MAX = 1000000;
        boolean primes[] = new boolean[MAX];
        primes[0] = primes[1] = true;
        for(int i=2; i*i<MAX; i++){
            if (!primes[i]){
                for(int j=i*i; j<MAX; j+=i){
                    primes[j] = true;
                }
            }
        }
        int k = sc.nextInt();
        int j = 0, kk = 0;
        for(int i=2; i<MAX; i++){
            if (primes[i]) continue;
            else j++;
 
            if (!primes[j]) kk++;
 
            if (kk == k){
                pw.print(i);
                break;
            }
        }
 
 
        pw.close();
    }
}