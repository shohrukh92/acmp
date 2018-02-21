/*
http://acmp.ru/index.asp?main=task&id_task=290
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    public void run() throws IOException{
        sc = new Scanner( new File("input.txt") );
        pw = new PrintWriter( new File("output.txt") );
 
 
        int i,j;
        int nb = sc.nextInt();
        int mb = sc.nextInt();
        int len = nb*mb;
        sc.nextLine();
        String B = "";
        for(i=0; i<nb; i++){ B += sc.nextLine(); }
 
        int nd = sc.nextInt();
        int md = sc.nextInt();
        sc.nextLine();
        char D[][] = new char[nd][md];
        for(i=0; i<nd; i++){
            String s = sc.nextLine();
            for(j=0; j<md; j++) D[i][j] = s.charAt(j);
        }
 
        int ans = 0;
        for(i=0; i<=nd-nb; i++){
            for(j=0; j<=md-mb; j++){
                String Bi = "";
                for(int ii=i; ii<nb+i; ii++){
                    for(int jj=j; jj<mb+j; jj++){
                        Bi += D[ii][jj];
                    }
                }
                if (isExist(B, Bi, len)) ans++;
            }
        }
        pw.print(ans);
        pw.close();
    }
    public boolean isExist(String B, String Bi, int len){
        String x = B;
        String y = Bi;
        for(int i=0; i<len; i++){
            if (B.charAt(i) == '#' && Bi.charAt(i) == '.') return false;
        }
        return true;
    }
 
}