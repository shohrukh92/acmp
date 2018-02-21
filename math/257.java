/*
http://acmp.ru/index.asp?main=task&id_task=257
Напишите программу, которая будет искать все целые X, удовлетворяющие уравнению A*X3 + B*X2 + C*X + D = 0, где A, B, C, D – заданные целые коэффициенты.

Входные данные
Во входном файле INPUT.TXT записаны четыре целых числа: A, B, C, D. Все числа по модулю не превышают 2×109.

Выходные данные
В выходной файл OUTPUT.TXT выведите сначала количество различных корней этого уравнения в целых числах, а затем сами корни в возрастающем порядке. Если уравнение имеет бесконечно много корней, то следует вывести в выходной файл одно число -1 (минус один).
*/

import java.io.*;
import java.util.*;
 
public class Main {
    public static class CubicEq{
        private double a, b, c, d;
        private List<Integer> IntX = new ArrayList<Integer>();
 
        private final double pi = Math.PI;
        private final double err = 1e-6;
        private int Roots;
        private double f(double x){
            return a*x*x*x + b*x*x + c*x + d;
        }
        public CubicEq( Scanner sc ){
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();
            d = sc.nextDouble();
            Solve();
        }
        public void Solve(){
            if ( abs(a) < err &&
                 abs(b) < err &&
                 abs(c) < err &&
                 abs(d) < err ){
                Roots = -1;
            }
            else if ( abs(a) < err &&
                      abs(b) < err &&
                      abs(c) < err ){
                Roots = 0;
            }
            else if ( abs(a) < err &&
                      abs(b) < err ){
                Roots = 0;
                double x = -d / c;
                if (isInteger(x)){
                    IntX.add( toInteger(x) );
                    Roots++;
                }
            }
            else if ( abs(a) < err ){
                Solve_2();
            }
            else{
                newSolve_3();
            }
        }
        private void newSolve_3(){
            double D = -4*(b*b*b)*d + b*b*c*c - 4*a*c*c*c + 18*a*b*c*d - 27*a*a*d*d;
            //System.out.println(D);
 
            double xx1=0., xx2=0.;
            double dd = b*b - 3*a*c;
 
            if ( dd >= 0.){
                xx1 = (-b - sqrt(dd))/(3.*a);
                xx2 = (-b + sqrt(dd))/(3.*a);
 
                if ( xx2 < xx1 ){
                    double t = xx1;
                    xx1 = xx2;
                    xx2 = t;
                }
            }
            Roots = 0;
            double xp = -b / (3.*a);
            //System.out.println(xx1 + ", " + xp + ", " + xx2);
            if ( D > 0. ){
                //System.out.println(3);
                FindX1(xx1);
                //FindX2(xx1, xx2);
                BinMiddle(xx1, xx2);
                FindX3(xx2);
                //Print();
            }
            else if ( D < 0.){
                //System.out.println(dd +" <-dd, x1; x2,x3 (- C");
 
                if ( a > 0. ){
                    if ( f(xp) > 0. ){ //<==
                        if (dd > 0.){
                            //System.out.print("+");
                            FindX1(xx1);
                        }
                        else {
                            FindX1(xp);
                        }
                    }
 
                    else if ( f(xp) < 0. ){ //==>
                        if (dd > 0.){
                            FindX3(xx2);
                        }
                        else{
                            FindX3(xp);
                        }
                    }
                }
                else if ( a < 0. ){
                    if ( f(xp) > 0. ){ //==>
                        if (dd > 0.){
                            FindX3(xx2);
                        }
                        else if (dd < 0.){
                            FindX3(xp);
                        }
                    }
 
                    else if ( f(xp) < 0. ){ //==>
                        if (dd > 0.){
                            FindX3(xx2);
                        }
                        else if (dd < 0.){
                            FindX3(xp);
                        }
                    }
                }
 
                //Print();
            }
            else{
                double x0 = -b/(3.*a);
                if ( abs(f(x0)) < err ){
                    //System.out.println("x1=x2=x3");
                    if (isInteger(xp)){
                        IntX.add(toInteger(xp));
                        Roots++;
                    }
                    //Print();
                }
                else{
                    //System.out.println("x1, x2=x3");
                    if ( abs(f(xx1)) < err ){
 
                        if (isInteger(xx1)){
                            IntX.add(toInteger(xx1));
                            Roots++;
                        }
                        FindX3(xx2);
                    }
                    else if ( abs(f(xx2)) < err ){
 
                        if (isInteger(xx2)){
                            IntX.add(toInteger(xx2));
                            Roots++;
                        }
                        FindX1(xx1);
                    }
                    //Print();
                }
            }
        }
 
        private void FindX2(double xx1, double xx2){
            int l = toInteger(xx1)-1;
            int r = toInteger(xx2)+1;
            for (int i = l; i <= r; i++){
                if ( i>l && i<r )
                    if ( abs(f(i)) < err ){
                        IntX.add(i);
                        Roots++;
                        //return;
                    }
            }
        }
        private void FindX3(double xx2){
            double XL = xx2;
            int step = 1000000;
            int Lsgn = sign( f(XL) );
            double XR = XL + step;
 
            while ( true ){
                //System.out.print( "R");
                if ( sign(f(XR)) != Lsgn )
                    break;
                XR += step;
            }
 
            BinMiddle(XL, XR);
        }
        private void FindX1(double xx1){
            double XR = xx1;
            int step = 1000000;
            int Rsgn = sign( f(XR) );
            double XL = XR - step;
 
            while ( true ){
                //System.out.print( "R");
                if ( sign(f(XL)) != Rsgn )
                    break;
                XL -= step;
            }
 
            BinMiddle(XL, XR);
        }
 
        private void BinMiddle(double XL, double XR){
            if ( sign( f(XL) ) == sign( f(XR) ) )
                return;
 
            double XD = XR - XL;
 
 
 
            while ( true ){
                if ( abs(XD) < 10) break;
                XD /= 2.;
                double XM = XL + XD;
                //System.out.println("*" + XL + " :: " + XR);
                if ( abs(f(XM)) < err ){
                    if ( isInteger(XM) ){
                        IntX.add( toInteger(XM) );
                        Roots++;
                        return;
                    }
                }
 
                if (sign(f(XL)) != sign(f(XM))){
                    XR = XM;
                }
                else{
                    XL = XM;
                }
            }
            FindX2(XL, XR);
        }
 
 
        private void Solve_2(){
            double D = c*c - 4*b*d;
            if ( D < 0. ){
                Roots = 0;
            }
            else if ( D > 0. ){
                Roots = 0;
                double rD = Math.sqrt(D);
                double x1 = (-c - rD) / (2*b);
                double x2 = (-c + rD) / (2*b);
                if (isInteger(x1)){
                    IntX.add(toInteger(x1));
                    Roots++;
                }
                if (isInteger(x2)){
                    IntX.add(toInteger(x2));
                    Roots++;
                }
            }
            else {
                Roots = 0;
                double x = -c / (2*b);
                if (isInteger(x)){
                    IntX.add(toInteger(x));
                    Roots++;
                }
            }
        }
        //--------------------------------------------------
        public void Print(PrintWriter pw){
            if (Roots == -1){
                pw.print(-1);
                return;
            }
            if (Roots == 0){
                pw.print(0);
                return;
            }
 
            if (Roots == 1){
                pw.print(1 + " " + IntX.get(0));
                return;
            }
 
            int i, n = IntX.size();
            int arr[] = new int[n];
            boolean arb[] = new boolean[n];
            for (i=0; i<n; i++){
                arr[i] = IntX.get(i);
                arb[i] = true;
            }
            Sort(arr, n);
 
            for(i=1; i<n; i++){
                if ( arr[i] == arr[i-1] ){
                    arb[i] = false;
                    Roots--;
                }
            }
 
            pw.print(Roots + " ");
            for (i=0; i<n; i++){
                if (arb[i])
                    pw.print(arr[i] + " ");
            }
        }
        public void Print(){
            //System.out.print("Roots = " + Roots + "\n ");
            for (int i = 0; i<IntX.size(); i++)
                System.out.print( IntX.get(i) + " " );
        }
        private double abs(double x){
            return Math.abs(x);
        }
        private double sqrt(double x){
            return Math.sqrt(x);
        }
        private int sign(double x){
            if ( x > 0. )
                return 1;
            else if (x < 0.)
                return -1;
            else
                return 0;
        }
        public boolean isInteger(double x){
            x = abs(x);
            if ( x-(int)(x+err) < err )
                return true;
            return false;
        }
        private int toInteger(double x){
            return (int)( x + sign(x)*err );
        }
        private void Sort(int[] arr, int n){
            for (int i = 0; i<n-1; i++){
                for (int j=0; j<n-1; j++){
                    if (arr[j] > arr[j+1]){
                        int t = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = t;
                    }
                }
            }
        }
 
        //--------------------------------------------------
 
 
    }
 
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner ( new File("input.txt") );
        PrintWriter pw = new PrintWriter ( new File("output.txt") );
 
        CubicEq CE = new CubicEq(sc);
        CE.Print(pw);
 
        sc.close();
        pw.close();
    }
}