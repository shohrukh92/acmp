/*
http://acmp.ru/index.asp?main=task&id_task=318
Задано натуральное число N.

Требуется написать программу, которая найдет следующее за ним число, в двоичном разложении которого столько же единиц, сколько в двоичном разложении числа N.

Входные данные
Входной файл INPUT.TXT содержит одно натуральное число N (N ≤ 230).

Выходные данные
Выходной файл OUTPUT.TXT должен содержать ответ на задачу.
*/
import java.io.*;
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
 
        int N = sc.nextInt();
        char[] units = ("0"+Integer.toBinaryString(N)).toCharArray();
        int len = units.length;
        int firs_unit = -1;
        for (int i=len-1; i>0; i--){
            if (units[i-1] == '0' && units[i] == '1'){
                char t = units[i-1];
                units[i-1] = units[i];
                units[i] = t;
 
                String ans = "";
                if (firs_unit < 0 || firs_unit == len-1) ans = String.valueOf(units);
                else {
                    int l,n;
                    l = 0; n = i+1;
                    String a = String.valueOf(units, 0, n);
                    l = firs_unit+1; n = len-firs_unit-1;
                    String b = String.valueOf(units, l, n);
                    l = i+1; n = firs_unit - i;
                    String c = String.valueOf(units, l, n);
                    ans = a + b + c;
                }
 
                if (len < 32){
                    pw.print(Integer.parseInt(ans, 2));
                }
                else{
                    long ans_l = fromBinToDecimal(units, len);
                    pw.print(ans_l);
                }
                break;
            }
            if (firs_unit < 0 && units[i] == '1') {
                firs_unit = i;
            }
        }
 
        pw.close();
    }
 
    public long fromBinToDecimal(char[] bits, int len){
        long ans = 0;
        for(int pow = len-1, i=0; i<len; i++, pow--){
            if (bits[i] == '1'){
                ans += (long)Math.pow( 2., (double)pow );
            }
        }
        return ans;
    }
}