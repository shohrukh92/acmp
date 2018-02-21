import java.io.*;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
 
        String s = sc.nextLine();
 
        int sum = 0;
        int len = s.length();
        for(int i=0; i<len; i++){
            sum += s.charAt(i)-48;
        }
        if (sum % 3 == 0){
            pw.print(2);
        }
        else if ( (sum+1) % 3 == 0 ){
            pw.println(1);
            pw.println(2);
        }
        else {
            pw.println(1);
            pw.println(1);
        }
        sc.close();
        pw.close();
    }
}