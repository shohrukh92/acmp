/*
http://acmp.ru/index.asp?main=task&id_task=322
Числа Фибоначчи строятся следующим образом: первые два равны единице, а каждое следующее равно сумме двух предыдущих. Например, первые десять чисел Фибоначчи равны: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55. В заданном тексте символы нумеруются слева направо, начиная с единицы.

Требуется написать программу, которая составит слово из символов, номера которых совпадают с числами Фибоначчи.

Входные данные
Входной файл INPUT.TXT содержит в единственной строке текст, состоящий из английских строчных букв. В тексте от 1 до 30000 символов.

Выходные данные
Выходной файл OUTPUT.TXT должен содержать слово из символов, номера которых совпадают с числами Фибоначчи. Символы слова идут в том же порядке, что и в заданном тексте.
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
 
        String s = "0" + sc.nextLine();
 
        int fc, f1=0, f2 = 1;
        while(true){
            fc = f1+f2;
            if (fc >= s.length()) break;
            pw.print(s.charAt(fc));
            f1 = f2;
            f2 = fc;
        }
 
        pw.close();
    }
}