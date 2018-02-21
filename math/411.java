/*
http://acmp.ru/index.asp?main=task&id_task=411
Сложно найти человека, который любит решать однообразные задачки по математике. В последнее время школьникам стало легче, ведь с появлением компьютеров почти в каждой квартире стало существенно проще проверять себя.

Но программы, в которых решение уравнений является стандартной функцией, установлены не везде. Напишите программу, которая сможет решить уравнение

ax2 + bx + c = 0

при заданных коэффициентах a, b и c.
Входные данные
Единственная строка входного файла INPUT.TXT содержит три целых числа a, b и c, каждое из которых не превосходит по модулю 30000. Числа разделяются пробелами.

Выходные данные
На первой строке выходного файла OUTPUT.TXT выведите число действительных корней заданного уравнения. Затем выведите сами корни по одному на строке с ошибкой, не превосходящей 10-4. Если для заданных коэффициентов корней бесконечно много, на единственной строке выходного файла выведите -1.
*/
import java.io.*;
import java.util.Scanner;
 
public class Main { 
    public static class QuadraticEq{
        private double a, b, c;
        private double[] x = new double[2];
        private int Roots; //0,1; -1 when infinite num of roots
        public QuadraticEq( Scanner sc ){
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();            
            Roots = -2;
            Solve();
        }
 
        public void Solve(){
            if ( Math.abs(a) < 1e-6 && 
                 Math.abs(b) < 1e-6 && 
                 Math.abs(c) < 1e-6 ){
                Roots = -1;
            }
            else if ( Math.abs(a) < 1e-6 && 
                      Math.abs(b) < 1e-6){
                Roots = 0;
            }
            else if ( Math.abs(a) < 1e-6 ){
                Roots = 1;
                x[0] = -c/b;
            }
            else {
                Solve_2();
            }
        }
 
        private void Solve_2(){
            double D = b*b - 4*a*c;
            if ( D < 0. ){
                Roots = 0;
            }
            else if ( D > 0. ){
                Roots = 2;
                double rD = Math.sqrt(D);
                x[0] = (-b - rD)/(2*a);
                x[1] = (-b + rD)/(2*a);
            }
            else {
                Roots = 1;
                x[0] = -b/(2*a);
            }
        }
 
        public void Print(PrintWriter pw){
            pw.println(Roots);
            for (int i = 0; i<Roots; i++)
                pw.println( x[i] );
        }
    }
     
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner( new File ("input.txt") );
        PrintWriter pw = new PrintWriter ( new File ("output.txt") );
         
        QuadraticEq QE = new QuadraticEq(sc);
        QE.Print(pw);
         
        sc.close();
        pw.close();
    }
}