/*
http://acmp.ru/index.asp?main=task&id_task=65
В связи с особенностями линии связи, используемой для передачи сообщений из пункта A в пункт B, каждый бит принятого сообщения с вероятностью 0.001 содержит ошибку.

Из пункта A в пункт B было послано одно из n сообщений m1, m2, ..., mn. В пункте B было принято сообщение s.

Ваша задача заключается в определении наиболее вероятного исходного сообщения. Очевидно, что оно будет одним из тех сообщений, расстояние Хэмминга между которым и строкой s минимально.

Расстоянием Хэмминга двух строк a и b одинаковой длины называется количество позиций, в которых эти строки различаются (количество элементов в множестве {i | 1 ≤ i ≤ |a|, ai ≠ bi }).

Входные данные
Первая строка входного файла INPUT.TXT содержит s — принятое сообщение. Вторая строка содержит целое число n — количество сообщений, которые могли быть отправлены. Следующие n строк содержат mi — эти сообщения. Длины всех сообщений равны (|s| = |m1| = |m2| = ... = |mn|). Сообщения непустые, состоят только из символов 0 и 1. Размер входного файла не превосходит 60 Кб.

Выходные данные
В первую строку выходного файла OUTPUT.TXT выведите k — количество сообщений, на которых достигается минимум расстояния Хэмминга. Во вторую строку выведите в порядке возрастания k чисел — номера этих сообщений.
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner sc;
    PrintWriter pw;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        String s = sc.nextLine();
        int len = s.length();
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<Integer> all = new ArrayList<Integer>();
        int min = 1000000000;
        for(int i=1; i<=n; i++){
            String curr = sc.nextLine();
            int x = calcXem(s, curr, len);
            if ( x < min ) {
                min = x;
                all.clear();
                all.add(i);
            }
            else if (x == min){
                all.add(i);
            }
        }
        pw.println(all.size());
        for (Integer anAll : all) {
            pw.print(anAll + " ");
        }
        pw.close();
    }
 
    public int calcXem(String a, String b, int len){
        int ans = 0;
        for(int i=0; i<len; i++)
            if (a.charAt(i) != b.charAt(i)) ans++;
        return ans;
    }
}