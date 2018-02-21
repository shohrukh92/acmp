/*
http://acmp.ru/index.asp?main=task&id_task=580
Школьная столовая хочет заказать новые треугольные подносы. Естественно, был организован тендер. Основным критерием отбора предложений является условие того, что имеющиеся в столовой круглые тарелки должны помещаться на новые подносы.

Директор школы дал вам задание написать программу, проверяющую, помещается ли тарелка данного размера на поднос с данными длинами сторон.

Входные данные
В первой строке входного файла INPUT.TXT находятся 3 целых положительных числа - длины сторон подноса. Гарантируется, что поднос с такими сторонами существует. Во второй строке входного файла содержится радиус тарелки - целое положительное число. Все числа во входном файле не превосходят 100. Радиус тарелки и стороны подноса указаны в одних и тех же единицах измерения.

Выходные данные
Выведите в выходной файл OUTPUT.TXT сообщение YES, если тарелка помещается на поднос, и NO - в противном случае.
*/
import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
     
    public void run() throws IOException
    {
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
         
        int a,b,c,r;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        r = sc.nextInt();
        double p = ((double)a+b+c)/2.;     
        double R = Math.sqrt( (p-a)*(p-b)*(p-c)/p );
         
        if (r <= R)
        {
            pw.print("YES");
        }
        else
        {
            pw.print("NO");
        }
        pw.close();
    }
}