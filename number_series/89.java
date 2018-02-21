/*
http://acmp.ru/index.asp?main=task&id_task=89
Между двумя крупнейшими городами нашей страны Санкт-Петербургом и Москвой ежедневно совершают рейсы n поездов. Для каждого поезда известно его время отправления из Санкт-Петербурга и время прибытия в Москву.

Найдите самый быстрый поезд и его скорость в предположении, что длина железной дороги между Санкт-Петербургом и Москвой равна 650 км.

Входные данные
Первая строка входного файла INPUT.TXT содержит целое число n (1 ≤ n ≤ 100). Каждая из последующих n строк описывает ровно один поезд.

Описание поезда состоит из его названия, времени отправления и времени прибытия. Название поезда – строка длиной от 1 до 50 символов, заключенная в кавычки. Она может содержать буквы английского алфавита, пробелы, цифры, символы тире («–») и подчеркивания («_»). Время отправления и прибытия заданы в формате ЧЧ:ММ. Строчные и заглавные буквы в названиях поездов различаются.

Время в пути для каждого из поездов составляет хотя бы одну минуту и не превышает 24 часов.

Гарантируется, что самый быстрый поезд определяется единственным образом.

Выходные данные
В выходной файл OUTPUT.TXT выведите название самого быстрого поезда и его скорость. Скорость выводите в километрах в час и округляйте к ближайшему целому по математическим правилам. Следуйте формату вывода, приведенному в примерах.
*/
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner sc;
    PrintWriter pw;
 
 
 
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
 
        int n = sc.nextInt(); sc.nextLine();
 
        String maxTrain = sc.nextLine();
        double maxSpeed = calcSpeed(maxTrain);
 
        for(int i=1; i<n; i++){
            String currTrain = sc.nextLine();
            double currSpeed = calcSpeed(currTrain);
            if (currSpeed > maxSpeed) {
                maxSpeed = currSpeed;
                maxTrain = currTrain;
            }
        }
 
        int pos = maxTrain.indexOf("\"", 1);
        maxTrain = maxTrain.substring(1, pos);
        long speed = Math.round(maxSpeed*60./1000.);
        String ans = "The fastest train is \"" + maxTrain + "\".\n" +
                "It's speed is " + speed + " km/h, approximately.";
 
        pw.print(ans);
 
        pw.close();
    }
 
    public double calcSpeed(String train){
        int pos = train.indexOf("\"", 1)+2;
        String hours[] = train.substring(pos, train.length()).split(" ");
        String begin[] = hours[0].split(":");
        String end[] = hours[1].split(":");
        int beginMinutes = Integer.parseInt(begin[0])*60 + Integer.parseInt(begin[1]);
        int endMinutes = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]);
 
        int diff = endMinutes - beginMinutes;
        if (diff <= 0) diff += 24*60;
        double ans = 650000.0/(0.0 + diff);
        return ans;
    }
}