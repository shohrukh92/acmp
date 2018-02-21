/*
http://acmp.ru/index.asp?main=task&id_task=413
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int i,j;
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        char arr[][] = new char[row+1][col+1];
        for(j=0; j<=col; j++){ arr[0][j] = '.'; }
        for(i=0; i<=row; i++){ arr[i][0] = '.'; }
        int ans = 0;
        for(i=1; i<=row; i++){
            String s = sc.nextLine();
            for(j=1; j<=col; j++){
                char curr = s.charAt(j-1);
                arr[i][j] = curr;
                if (curr == '#'){
                    if (arr[i-1][j] == '.' && arr[i][j-1] == '.'){ ans++; }
                }
            }
        }
        pw.print(ans);
        pw.close();
    }
 
 
}