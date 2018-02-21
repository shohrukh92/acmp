/*
http://acmp.ru/index.asp?main=task&id_task=185
Иван Иванович любит ходить на скачки, надеясь на них заработать кругленькую сумму. Ему приглянулась лошадь с номером K, и он решил проверить, сможет ли она выиграть у всех остальных лошадей. Иван Иванович раздобыл информацию, в которой для некоторых пар лошадей сообщается, какая из этих лошадей быстрее. Также он узнал, что у всех лошадей разные скорости.

Требуется написать программу, которая поможет Ивану Ивановичу точно определить может ли выиграть выбранная им лошадь.

Входные данные
Входной файл INPUT.TXT содержит в первой строке два целых числа N (1 ≤ N ≤ 100) и K (1 ≤ K ≤ N), где N – количество лошадей, принимающих участие в скачках, K – номер лошади, на которую хочет сделать ставку Иван Иванович. Следующие строки содержат по два числа X и Y (1 ≤ X, Y ≤ N), обозначающие, что лошадь с номером X быстрее лошади с номером Y. Пары X и Y не повторяются. Набор данных завершается строкой, содержащей единственный ноль. Эту строку обрабатывать не надо.

Гарантируется, что информация, раздобытая Иваном Ивановичем, корректна.

Выходные данные
Выходной файл OUTPUT.TXT должен содержать слово «Yes», если Иван Иванович уверен в своем выигрыше и «No» в противном случае.
*/
import java.io.*;
import java.util.*;
 
public class Main {
    public static class Graph {
        int n, k;
        boolean arr[];
        List<Integer> G[];
        public Graph(Scanner sc, PrintWriter pw) {
            n = sc.nextInt();
            arr = new boolean[n];
            k = sc.nextInt()-1;
            G = new List[n];
            for (int i=0; i<n; i++){
                G[i] = new ArrayList<Integer>();
                arr[i] = false;
            }

            while (true){
                int x = sc.nextInt();
                if ( x == 0)
                    break;
                int y = sc.nextInt();
                G[x-1].add(y-1);
            }



            if (Solve())
                pw.print("Yes");
            else
                pw.print("No");

                /*for (int i=0; i<n; i++)
                {
                    System.out.print(i + " : ");
                    for (int j=0; j<G[i].size(); j++)
                        System.out.print(G[i].get(j) + " ");

                    System.out.println();
                }*/
        }

        public boolean Solve(){
            DFS(k);

            for (int i=0; i<n; i++){
                if (!arr[i])
                    return  false;
            }
            return  true;
        }

        public void DFS(int v){
            arr[v] = true;
            for (int i=0; i<G[v].size(); i++){
                if ( !arr[ G[v].get(i) ] )
                    DFS(G[v].get(i));
            }
        }
    }

    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner ( new File("input.txt") );
        PrintWriter pw = new PrintWriter ( new File("output.txt") );

        Graph G = new Graph(sc, pw);

        sc.close();
        pw.close();
    }
}