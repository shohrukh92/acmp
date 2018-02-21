/*
http://acmp.ru/index.asp?main=task&id_task=50
Циклическим сдвигом строки s называется строка sksk+1sk+2…s|s|s1s2…sk-1 для некоторого k, здесь |s| - длина строки s. Подстрокой строки s называется строка sisi+1…sj-1sj для некоторых i и j. Вам даны две строки a и b. Выведите количество подстрок строки a, являющихся циклическими сдвигами строки b.

Входные данные
Первая строка входного файла INPUT.TXT содержит строку a (1 ≤ |a| ≤ 1000). Во второй строке входного файла записана строка b (1 ≤ |b| ≤ min(100,|a|)). Обе строки состоят только из символов английского алфавита и цифр.

Выходные данные
В выходной файл OUTPUT.TXT выведите целое число – ответ на задачу.
*/
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
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
 
        String a = sc.nextLine();
        String b = sc.nextLine();
 
        HashMap<String, Integer> bb = new HashMap<String, Integer>();
        int alen = a.length();
        int blen = b.length();
        int ans = 0;
        for(int i=0; i<blen; i++){
            bb.put(b, 0);
            b = sdv(b);
        }
 
        Iterator it = bb.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            b = (String)pair.getKey();
            for(int i=0; i<=alen-blen; i++){
                if (a.substring(i, i+blen).equals(b)) ans++;
            }
            it.remove();
        }
 
 
        pw.print(ans);
 
        pw.close();
    }
 
    public String sdv(String s){
        String ans = s.substring(1, s.length());
        return ans + s.charAt(0);
    }
 
}