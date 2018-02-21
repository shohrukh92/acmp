/*
http://acmp.ru/index.asp?main=task&id_task=574
Cтрока S1 называется анаграммой строки S2, если она получается из S2 перестановкой символов. Даны строки S1 и S2. Напишите программу, которая проверяет, является ли S1 анаграммой S2.

Входные данные
Первая строка входного файла INPUT.TXT содержит строку S1, вторая - S2. Обе строки состоят только из прописных букв английского алфавита. Строки не пусты и имеют длину не больше 100000 символов.

Выходные данные
В выходной файл OUTPUT.TXT выведите YES, если S1 является анаграммой S2, и NO - в противном случае.
*/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class Main{
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner ( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
        //65-90, A-Z
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        String s1,s2;
        s1 = sc.nextLine();
        s2 = sc.nextLine();
         
        for ( int i = 0; i < s1.length(); i++ )
            arr1[(int)s1.charAt(i)-65]++;
         
        for ( int i = 0; i < s2.length(); i++ )
            arr2[(int)s2.charAt(i)-65]++;
         
        boolean yn = true;
        for ( int i = 0; i < 26; i++){
            if ( arr1[i] != arr2[i] ){
                yn = false;
                break;
            }
        }
         
        if (yn)
            pw.print("YES");
        else
            pw.print("NO");
         
        sc.close();
        pw.close();
    }
}