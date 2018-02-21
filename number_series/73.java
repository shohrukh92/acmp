/*
http://acmp.ru/index.asp?main=task&id_task=73
Рассмотрим работу простейшего шифра. Шифруемое сообщение состоит из английских букв, записанных в нижнем регистре и символа пробела. Шифрование происходит посимвольно. Каждой букве ставим в соответствие число: a – 1, b – 2, … , z – 26, ‘ ‘ – 27. Далее индекс символа складывается с номером в сообщении по модулю 27, а результат сложения представляется в системе счисления с основанием 27 (0, 1, …, Q в верхнем регистре).

Необходимо написать дешифратор.

Входные данные
В единственной строке входного файла INPUT.TXT содержится закодированная строка, длиной от 1 до 255 символов. Строка записана в верхнем регистре.

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести расшифровку заданной строки, при этом символы английского алфавита следует выводить в нижнем регистре.
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
 
 
        String s = sc.nextLine();
        int slen = s.length();
 
        for(int i=0; i<slen; i++){
            String ci = (s.charAt(i)+"").toLowerCase();
            int x = Integer.parseInt( ci, 27 );
            int y = (i+1);
            int diff = x - y;
            while (diff < 0) diff += 27;
 
            char curr = (char)(diff + 96);
            if (curr == '`') curr = ' ';
            pw.print(curr);
        }
 
        pw.close();
    }
}