/*
http://acmp.ru/index.asp?main=task&id_task=87
Задан набор строк S = {s1, s2, s3, ... , sn}. Необходимо найти количество строк si из S, представимых в виде конкатенации двух строк sj и sk из S (si = sjsk, j и k при этом могут совпадать).

Входные данные
Входной файл INPUT.TXT содержит набор строк S – по одному элементу на строке. i-ая строка входного файла содержит si. Последняя строка входного файла содержит строку ENDOFINPUT. Она обозначает конец входных данных и не входит в S.

Все si состоят только из маленьких букв английского алфавита и имеют длину от 1 до 100 символов. Во входном файле не более 240 строк (включая строку, содержащую ENDOFINPUT).

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ без ведущих нулей.
*/

import java.io.*;
import java.util.*;
  
public class Main implements Runnable {
  
    private Scanner in;
    private PrintWriter out;
  
    public void run() {
        HashSet<String> hs = new HashSet<String>();
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = in.nextLine();
            if ("ENDOFINPUT".equals(s)) {
                break;
            }
            hs.add(s);
            list.add(s);
        }
  
        int ans = 0;
  
        for (String s : list) {
            int n = s.length();
            boolean good = false;
            for (int i = 0; i < n; i++) {
                if (hs.contains(s.substring(0, i)) && hs.contains(s.substring(i, n))) {
                    good = true;
                    break;
                }
            } 
            if (good) {
                ans++;
            }
        }
  
        out.println(ans);
  
        out.close();
    }
      
    private Main() {
        try {
            in = new Scanner(new File("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));    
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(239);
        }
    }
  
    public static void main(String[] args) {
        (new Thread(new Main())).start();
    }
}