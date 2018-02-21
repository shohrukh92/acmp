/*
http://acmp.ru/index.asp?main=task&id_task=56
Программист Саша участвует в создании блог-сервиса Jивой Jурнал. Планируется, что этот сервис будет предоставлять гораздо больше возможностей, чем известный всем LiveJournal. В настоящее же время проблему составляет реализация всех базовых возможностей LiveJournal'а. Одной из таких возможностей является поддержка списков друзей для пользователей.

Заданы: список пользователей, являющихся друзьями данного пользователя, и список пользователей, у которых данный пользователь содержится в списке друзей.

Необходимо получить список друзей данного пользователя (Friends), список его взаимных друзей (Mutual Friends), и список тех пользователей, у кого данный пользователь содержится в списке друзей, но которые не являются его взаимными друзьями (Also Friend of).

Входные данные
Первая строка входного файла INPUT.TXT содержит число n (0 ≤ n ≤ 200) друзей данного пользователя. Последующие n строк содержат каждая по одному имени пользователя, который является другом данного. (n + 2)-ая строка содержит число m (0 ≤ m ≤ 200) пользователей, у которых данный содержится в списке друзей. Далее заданы имена пользователей, у которых данный находится в списке друзей. Эти пользователи заданы в том же формате, что и друзья данного.

Имена пользователей - строки длиной от 1 до 20 символов, содержащие только строчные буквы английского алфавита и символы тире ("-"). Каждый пользователь указан не более одного раза в каждом из списков.

Выходные данные
В выходной файл OUTPUT.TXT следует вывести список друзей данного пользователя (Friends), список его взаимных друзей (Mutual Friends), и список тех пользователей, у кого данный пользователь содержится в списке друзей, но которые не являются его взаимными друзьями (Also Friend of). В каждом списке пользователи должны быть отсортированы по алфавиту. Следуйте формату, приведенному в примерах.
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
 
    public void run() throws IOException{
        sc = new Scanner( new File("input.txt") );
        pw = new PrintWriter( new File("output.txt") );
 
 
        int i,n = sc.nextInt(); sc.nextLine();
        ArrayList<String> friends = new ArrayList<String>();
        ArrayList<String> mutual = new ArrayList<String>();
        ArrayList<String> also = new ArrayList<String>();
 
        for(i=0; i<n; i++) friends.add( sc.nextLine() );
 
        int m = sc.nextInt();
        if (n != 0){
            sc.nextLine();
            for(i=0; i<m; i++){
                String curr = sc.nextLine();
                if (friends.contains(curr)) mutual.add(curr);
                else also.add(curr);
            }
        }
 
        Collections.sort(friends);
        Collections.sort(mutual);
        Collections.sort(also);
 
        pw.print("Friends: ");
        for(i=0; i<friends.size()-1; i++) pw.print(friends.get(i) + ", ");
        if(!friends.isEmpty()) pw.print(friends.get(i));
        pw.println();
 
        pw.print("Mutual Friends: ");
        for(i=0; i<mutual.size()-1; i++) pw.print(mutual.get(i) + ", ");
        if(!mutual.isEmpty()) pw.print(mutual.get(i));
        pw.println();
 
        pw.print("Also Friend of: ");
        for(i=0; i<also.size()-1; i++) pw.print(also.get(i) + ", ");
        if (!also.isEmpty()) pw.print(also.get(i));
        pw.println();
 
        pw.close();
    }
 
}