/*
http://acmp.ru/index.asp?main=task&id_task=516
Число называется 2-простым, если являются простыми числа, составленные из цифр этого числа в возрастающем и убывающем порядках.

Требуется написать программу, которая по заданному числу определит его 2-простоту.

Входные данные
Входной файл INPUT.TXT содержит натуральное число N (10 < N < 109).

Выходные данные
В выходной файл OUTPUT.TXT выведите сообщение «Yes», если число N является 2-простым и «No» - иначе.
*/
import java.io.*;
import java.util.Scanner;
 
public class Main {
    public static char[] dec_n;
    public static int curr_len;
    public static void insert(char x){
        int j = curr_len;
        while(j > -1 && x > dec_n[j]) {
            dec_n[j+1] = dec_n[j];
            j--;
        }
        dec_n[j+1] = x;
    }
    public static boolean is_prime(int x){
        for (int i=2; i*i <= x; i++){
            if (x % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
        curr_len = 0;
        char curr;
        String s = sc.nextLine();
        int len = s.length();
        dec_n = new char[10];
        for (int i=0; i<len; i++){
            curr = s.charAt(i);
            insert(curr);
            curr_len++;
        }
 
        int max = Integer.parseInt(String.valueOf(dec_n).trim());
        int min = Integer.valueOf(new StringBuilder(String.valueOf(max)).reverse().toString());
        int last1 = min % 10;
        int last2 = max % 10;
        String ans = "No";
        if (last1 % 2 != 0 || last1 % 3 != 0 || last1 % 5 != 0 ||
            last2 % 2 != 0 || last2 % 3 != 0 || last2 % 5 != 0){
            if (is_prime(min) && is_prime(max)) ans = "Yes";
        }
 
        pw.print(ans);
        sc.close();
        pw.close();
    }
}