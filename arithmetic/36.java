/*
http://acmp.ru/index.asp?main=task&id_task=36
Постулат Бертрана (теорема Бертрана-Чебышева, теорема Чебышева) гласит, что для любого n > 1 найдется простое число p в интервале n < p < 2n. Такая гипотеза была выдвинута в 1845 году французским математиком Джозефем Бертраном (проверившим ее до n=3000000) и доказана в 1850 году Пафнутием Чебышевым. Раманужан в 1920 году нашел более простое доказательство, а Эрдеш в 1932 – еще более простое.

Ваша задача состоит в том, чтобы решить несколько более общую задачу – а именно по числу n найти количество простых чисел p из интервала n < p < 2n.

Напомним, что число называется простым, если оно делится только само на себя и на единицу.

Входные данные
Входной файл INPUT.TXT содержит целое число n (2 ≤ n ≤ 50000).

Выходные данные
В выходной файл OUTPUT.TXT выведите одно число – ответ на задачу.
*/
import java.io.*;
import java.util.Arrays;
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
 
        int n = sc.nextInt();
        boolean[] primes = new boolean[n*2];
        fillSieve(primes);
        int ans = 0;
        for(int i=n+1; i<2*n; i++){
            if (primes[i]) ans++;
        }
        pw.print(ans);
        pw.close();
    }
    public static void fillSieve(boolean primes[]) {
        Arrays.fill(primes, true);
        primes[0]=primes[1]=false;
        for (int i=2;i<primes.length;i++) {
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
    }
}