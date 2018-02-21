/*
http://acmp.ru/index.asp?main=task&id_task=333
Заданы натуральные числа A, B, C. Требуется написать программу, которая найдет общие цифры в этих числах.

Входные данные
Входной файл INPUT.TXT содержит три натуральных числа A, B, C (1 ≤ A, B, C ≤ 1080). Числа разделены одним пробелом.

Выходные данные
Выходной файл OUTPUT.TXT должен содержать в первой строке количество общих цифр, а во второй строке в порядке возрастания через один пробел общие цифры.
*/
import java.io.*;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner in;
    PrintWriter out;
 
 
    public void run() throws IOException{
        in = new Scanner(new File("input.txt"));
        out = new PrintWriter(new File("output.txt"));
 
        String s1 = in.next();
        String s2 = in.next();
        String s3 = in.next();
 
        int[] digits = new int[10];
        for(int i=0; i<s1.length(); i++){
            int curr = (int)s1.charAt(i) - 48;
            if (digits[curr] == 0) digits[curr] = 1;
        }
        for(int i=0; i<s2.length(); i++){
            int curr = (int)s2.charAt(i) - 48;
            if (digits[curr] == 1) digits[curr] = 2;
        }
        int ans = 0;
        for(int i=0; i<s3.length(); i++){
            int curr = (int)s3.charAt(i) - 48;
            if (digits[curr] == 2 ) {
                digits[curr] = 3;
                ans++;
            }
        }
        out.println(ans);
        if (ans != 0){
            for(int i=0; i<10; i++){
                if (digits[i] >= 3) out.print(i + " ");
            }
        }
        out.close();
    }
}