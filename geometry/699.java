/*
http://acmp.ru/index.asp?main=task&id_task=699
На лесной опушке растет дружная семейка грибов. Местоположение каждого гриба задается координатами X, Y, а шляпка гриба имеет радиус R. Когда идет дождь, радиус шляпки каждого гриба непрерывно и равномерно увеличивается cо скоростью 1 сантиметр в минуту. Когда дождь заканчивается (а он идет не более Т минут), шляпки прекращают расти. Если во время дождя шляпки двух грибов соприкоснулись, то они немедленно перестают расти, чтобы не навредить друг другу. Грибы очень дружные, поэтому если перестают расти два гриба, то и все остальные тоже не растут.

Требуется посчитать, на сколько сантиметров увеличился радиус шляпки каждого гриба после завершения дождя.

Входные данные
Первая строка входного файла INPUT.TXT содержит два натуральных числа: количество грибов K (K ≤ 10) и длительность дождя T (T ≤ 100). Следующие К строк содержат описание грибов: целые координаты X и Y (0 ≤ X, Y ≤ 100) и радиус шляпки R (1 ≤ R ≤ 10). Координаты и радиус даны в сантиметрах.

Выходные данные
В выходной файл OUTPUT.TXT выведите величину в сантиметрах, на которую увеличится радиус всех грибов. Результат следует вывести с точностью, не меньшей, чем два знака после запятой.
*/
import java.io.*;
import java.util.Scanner;
 
public class Main {
    public Grib[] all;
    double minDistance;
 
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int k = sc.nextInt();
        int T = sc.nextInt();
        all = new Grib[k];
        minDistance = 1e10;
        int allIndex = 0;
        while (k-- > 0){
            int x,y,r;
            x = sc.nextInt(); y = sc.nextInt(); r = sc.nextInt();
            Grib newGrib = new Grib(x,y,r);
            findMin(newGrib, allIndex);
            all[allIndex++] = newGrib;
        }
 
        double ans = 0.;
        if (2*T < minDistance) ans = T;
        else ans = minDistance/2.;
 
        pw.printf("%.2f", ans);
        pw.close();
    }
 
 
    public void findMin(Grib g, int n){
        for(int i=0; i<n; i++){
            double currDistance = g.calcDistance(all[i]);
            currDistance -= g.getR()+all[i].getR();
            if (currDistance < minDistance) minDistance = currDistance;
        }
    }
 
    public class Grib{
        private int x,y;
        private double r;
 
        public int getX() {
            return x;
        }
 
        public int getY() {
            return y;
        }
 
        public double getR() {
            return r;
        }
 
        public void setR(double r) {
 
            this.r = r;
        }
 
        public void setX(int x) {
            this.x = x;
        }
 
        public void setY(int y) {
            this.y = y;
        }
 
        public Grib(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = (double)r;
        }
 
        public double calcDistance(Grib g2){
            double distance = (x-g2.getX())*(x-g2.getX()) + (y-g2.getY())*(y-g2.getY());
            return Math.sqrt( distance );
        }
 
        public boolean isIntersect(Grib g2){
            double distance = calcDistance(g2);
            if (r + g2.r < distance) return false;
            return true;
        }
    }
}