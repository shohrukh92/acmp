/*
http://acmp.ru/index.asp?main=task&id_task=281
Петя играет в интересную игру. Для этой игры необходима монетка. Петя подбрасывает ее n раз и считает, сколько раз выпадает «решка». Если решка выпадает хотя бы m раз, то Петя считает, что он выиграл игру.

Однажды Петя задумался, какова вероятность того, что он выиграет игру. Для этого он хочет найти количество последовательностей результатов подбрасывания монетки, содержащих ровно n подбрасываний, при которых «решка» выпала хотя бы m раз.

Помогите Пете — найдите это число, считая, что при каждом броске монетка может выпасть либо «орлом», либо «решкой».

Входные данные
Входной файл INPUT.TXT содержит два целых числа: n и m (1 < n ≤ 20, 0 ≤ m ≤ n).

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
*/
import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
     
    public void print_arr(int arr[][], int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return;
    }
     
    PrintWriter pw;
    Scanner sc;
     
    public void run() throws IOException
    {
        sc = new Scanner(new File("input.txt"));
        pw = new PrintWriter(new File("output.txt"));
         
        int n,m,i,j;
        n = sc.nextInt();
        m = sc.nextInt();
         
        int arr[][] = new int[21][21];      
         
        for (i = 0; i < n+1; i++)
        {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
         
        for (i = 2; i < n+1; i++)
        {
            for (j = 1; j < i; j++)
            {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
         
        long S = 0;
        for (i = m; i < n+1; i++)
        {
            S += arr[n][i];
        }
         
        pw.print(S);
         
        pw.close();
        //sc.close(); 
    }
}