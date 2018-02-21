/*
http://acmp.ru/index.asp?main=task&id_task=495
Пусть задана некоторая замкнутая ломаная P. Двойственной для P ломаной называется ломаная, вершины которой находятся в серединах звеньев P.

Определим понятие двойственной для P ломаной k-ого порядка dual(P, K) следующим образом:

двойственной ломаной нулевого порядка является сама ломаная P (dual(P, 0) = P);
если K > 0, то двойственной ломаной K-ого порядка является ломаная, двойственная для dual(P, K - 1).
Задана замкнутая ломаная P и число K. Найдите длину двойственной для P ломаной k-ого порядка dual(P, K).

Входные данные
Входной файл INPUT.TXT содержит число звеньев исходной ломаной N (3 ≤ N ≤ 100). Каждая из последующих N строк содержит по два целых числа xi и yi - координаты i-ой вершины ломаной. Все xi и yi не превосходят 10^5 по абсолютной величине. Последняя строка входного файла содержит целое число K (0 ≤ K ≤ 10).

Выходные данные
В выходной файл OUTPUT.TXT выведите искомую длину с точностью не хуже, чем 10^-4.
*/
import java.io.*;
import java.util.*;
 
public class Main {
    public static class MyPoint{
        public double x,y;
        public MyPoint(double x, double  y){
            this.x = x;
            this.y = y;
        }
        public MyPoint(MyPoint P){
            x = P.x;
            y = P.y;
        }
    }
     
    public static class Polyline{
        private int N; //num of vertexes
        private int K;        
        private List<MyPoint> V;
         
        public Polyline(Scanner sc){
            N = sc.nextInt();
            V = new ArrayList<MyPoint>(N);
            for (int i=0; i<N; i++)
                V.add( new MyPoint (sc.nextInt(), sc.nextInt()) );
             
            K = sc.nextInt();
            Dual();
        }
         
        private MyPoint Middle(MyPoint P1, MyPoint P2){
            return ( new MyPoint( (P1.x + P2.x)/2., (P1.y + P2.y)/2.) );
        }
         
        private double Distance(MyPoint P1, MyPoint P2){
            return Math.sqrt( (P2.x-P1.x)*(P2.x-P1.x) + (P2.y-P1.y)*(P2.y-P1.y));
        }
         
        private void Dual(){            
            if ( K==0 )
                return;
             
            int i;
            MyPoint P0 = new MyPoint(V.get(0));
            for (i=0; i<N-1; i++)
                V.set(i, Middle(V.get(i), V.get(i+1)));
             
            V.set(i, Middle(V.get(i), P0));
            K--;
            Dual();
        }
         
        public double Length (){
            int i;
            double Len = 0.;
            for (i=0; i<N-1; i++)
                Len += Distance(V.get(i), V.get(i+1));
             
            return Len + Distance(V.get(i), V.get(0));
        }
    }
     
     
    public static void main(String[] a) throws IOException{
        Scanner sc = new Scanner (new File("input.txt"));
        PrintWriter pw = new PrintWriter (new File("output.txt"));
         
        Polyline PL = new Polyline(sc);
        pw.print(PL.Length());
         
        sc.close();
        pw.close();
    }
}