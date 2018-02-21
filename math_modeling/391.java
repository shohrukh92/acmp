/*
http://acmp.ru/index.asp?main=task&id_task=391
Задача: Взлом хеш-функции
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
    int x,m,L,v;
    String s;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        x = sc.nextInt();
        m = sc.nextInt();
        L = sc.nextInt();
        v = sc.nextInt();
        Random randomGenerator = new Random();
        while(true){
            s = random(randomGenerator, "0123456789", L);
            if (v == hash()){
                pw.print(s);
                break;
            }
        }
 
 
        pw.close();
    }
    public String random(Random rng, String characters, int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    public long hash(){
        long sum = 0;
        int L = s.length();
        for(int i=0; i<L; i++){
            long si = s.charAt(i)-48;
            sum += si*pow(x,i);
        }
        return sum%m;
    }
 
    public long pow(long x, long y){
        long ans = 1;
        for(long i=0; i<y; i++) ans *= x;
        return ans;
    }
}