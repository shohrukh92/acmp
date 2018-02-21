/*
http://acmp.ru/index.asp?main=task&id_task=42
Известно, что у дракона может быть несколько голов и его сила определяется числом голов. Но как определить силу драконьей стаи, в которой несколько драконов и у каждого из них определенное число голов? Вероятно, вы считаете, что это значение вычисляется как сумма всех голов? Это далеко не так, иначе было бы слишком просто вычислить силу драконьей стаи. Оказывается, что искомое значение равно произведению значений числа голов каждого из драконов. Например, если в стае 3 дракона, у которых 3, 4 и 5 голов соответственно, то сила равна 3*4*5 = 60. Предположим, что нам известно суммарное значение голов драконьей стаи, как нам вычислить максимально возможное значение силы этого логова драконов? Именно эту задачу Вам и предстоит решить.

Входные данные
В единственной строке входного файла INPUT.TXT записано натуральное число N (0 < N < 100) – количество голов драконьей стаи.

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести максимально возможное значение силы, которая может быть у стаи драконов из N голов.
*/
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
 
        int N = sc.nextInt();
        BigInteger ans = new BigInteger(String.valueOf(N));
        if (N > 4) {
            int k = N/3;
            if (N % 3 == 0){
                ans = (new BigInteger("3").pow(k));
            }
            else if (N % 3 == 2){
                ans = (  new BigInteger("3")  ).pow(k);
                ans = (  new BigInteger("2")  ).multiply(ans);
            }
            else{
                k--;
                ans = (  new BigInteger("3")  ).pow(k);
                ans = (  new BigInteger("4")  ).multiply(ans);
            }
        }
 
        pw.print(ans);
 
        sc.close();
        pw.close();
    }
}