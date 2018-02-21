/*
http://acmp.ru/index.asp?main=task&id_task=454
Задан ряд последовательных натуральных чисел от M до N (M < N), из которого удаляют сначала все числа, стоящие на нечетных местах. Затем, из оставшегося ряда удаляют все числа, стоящие в нем на четных местах. Эти действия повторяют до тех пор, пока не останется одно число.

Требуется написать программу, которая находит оставшееся число.

Входные данные
Входной файл INPUT.TXT содержит число M в первой строке и число N во второй (M < N < 10^9).

Выходные данные
В выходной файл OUTPUT.TXT выведите оставшееся число.
*/
import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    public String ipToInt(String ip){
        String nums[] = ip.split("\\.");
        String bin = "";
        for(int i=0; i<4; i++){
            int I = Integer.parseInt(nums[i]);
            String sbyte = Integer.toString(I, 2);
            for(int j=0; j<8-sbyte.length(); j++) bin += "0";
            bin += sbyte;
        }
        return bin;
    }
 
    public String And(String mask, String ip){
        int len = mask.length();
        int zeroPos = mask.indexOf("0");
        if (zeroPos < 0) return ip;
        String ans = ip.substring(0, zeroPos);
        ans += mask.substring(zeroPos, len);
        return ans;
    }
 
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x=0;    int y=2;
        while(true){
            x++;
            if(n+y>=m){
                pw.print((x%2==1)?(n+y)-y/2:n);
                break;
            }else
            if(x%2!=0)  n+=y/2;
            y*=2;
        }
 
        pw.close();
    }
}