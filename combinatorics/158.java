/*
http://acmp.ru/index.asp?main=task&id_task=158
В результате очередной хитроумной комбинации у Остапа Бендера и его компаньонов - K детей лейтенанта Шмидта оказалось X рублей пятирублевыми банкнотами. И вот дело, как водится, дошло до дележа...

Шура Балаганов предложил "по справедливости", т.е. всем поровну. Паниковский порешил себе отдать половину, а остальным "по заслугам". Каждый из K детей лейтенанта предложил что-нибудь интересное. Однако, у Великого Комбинатора имелось свое мнение на этот счет...

Ваша же задача состоит в нахождении количества способов разделить имеющиеся деньги между всеми участниками этих славных событий: K детьми лейтенанта Шмидта и Остапом Бендером.

Входные данные
Во входном файле INPUT.TXT записаны целые числа X (0 ≤ X ≤ 500) и K (0 ≤ K ≤ 100). Естественно, что число X делится на 5. Да и при дележе рвать пятирублевые банкноты не разрешается.

Выходные данные
В выходной файл OUTPUT.TXT выведите одно целое число - количество способов дележа.
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
 
    BigInteger YKf, Kf, Yf;
    public void fact(int Y, int K){
        YKf = new BigInteger("1");
        Kf = new BigInteger("1");
        Yf = new BigInteger("1");
 
        String si = "";
        BigInteger bi;
        for(int i=2; i<=Y+K; i++){
            si = Integer.toString(i);
            bi = new BigInteger(si);
            YKf = YKf.multiply( bi );
            if (i <= K) { Kf = Kf.multiply( bi ); }
            if (i <= Y) { Yf = Yf.multiply( bi ); }
        }
    }
 
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int y = sc.nextInt()/5;
        int k = sc.nextInt();
 
        fact(y, k);
        YKf = YKf.divide(Kf);
        pw.print( YKf.divide(Yf) );
 
        pw.close();
    }
 
 
}