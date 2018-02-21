/*
http://acmp.ru/index.asp?main=task&id_task=171
Пусть х — натуральное число. Назовем у его делителем, если 1 ≤ у ≤ х и остаток от деления х на у равен нулю.

Задано число х. Найдите количество его делителей.

Входные данные
Входной файл INPUT.TXT содержит заданное число x (1 ≤ x ≤ 1018). Все простые делители числа x не превосходят 1000.

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
*/

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    HashMap<Long, Long> primes;
    void rec(long a, long b){
        if(a==1)
            return;
        for(;;b++)
            if(a%b==0){
                if (primes.containsKey(b)){
                    primes.put(b, primes.get(b)+1);
                }
                else{
                    primes.put(b, 1L);
                }
                rec(a/b, b);
                return;
            }
    }
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        long n = sc.nextLong();
        primes = new HashMap<Long, Long>();
        rec(n, 2);
 
        Iterator it = primes.entrySet().iterator();
        long ans = 1;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            ans *= (Long)pair.getValue()+1;
            it.remove();
        }
 
        pw.print(ans);
        pw.close();
    }
 
 
}