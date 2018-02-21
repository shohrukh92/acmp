/*
http://acmp.ru/index.asp?main=task&id_task=541
Циклическим сдвигом строки s1s2…sn на k позиций назовем строку sk+1sk+2…sns1..sk. Например, циклическим сдвигом строки «abcde» на две позиции является строка «cdeab». В этой задаче далее будут рассматриваться только строки, состоящие из десятичных цифр от 0 до 9. Произвольной такой строке, первый символ которой не является нулем, можно сопоставить число, десятичной записью которого она является. Строкам, которые начинаются с нуля, никакое число сопоставляться не будет. Например, строке 123 сопоставляется число сто двадцать три, а строке 0123 не сопоставляется никакое число.
Пусть заданы две строки: s и t. Обозначим как S набор всех циклических сдвигов строки s, а как T – набор всех циклических сдвигов строки t. Например, если s = «1234», то S содержит строки «1234», «2341», «3412», «4123». Обозначим также как NUM(A) набор чисел, соответствующих строкам из набора A.
Требуется написать программу, которая по строкам s и t определит, максимальное число, представимое в виде разности (x – y), где x принадлежит NUM(S), а y принадлежит NUM(T). Например, если s = «25», t = «12», то NUM(S) содержит числа 25 и 52, NUM(T) – числа 12 и 21; их попарными разностями будут: 25 – 12 = 13, 25 – 21 = 4, 52 – 12 = 40, 52 – 21 = 31. Из этих разностей максимальным числом является 40.

Входные данные
Первая строка входного файла INPUT.TXT содержит строку s, вторая строка входного файла – строку t. Обе строки непустые. Они содержат только цифры, из которых хотя бы одна не является нулем. Строки имеют длину не более 3000 символов.

Выходные данные
В выходной файл OUTPUT.TXT выведите искомое число без ведущих нулей.
*/

import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class Main { 
    public static int MyCompare (char[] a, char[] b){
         
        int lena = a.length;
        int lenb = b.length;
        if ( lena > lenb )
            return 1;
        else if ( lena < lenb )
            return -1;
         
        for (int i=0; i<lena; i++){
            if ( a[i] > b[i] )
                return 1;
            else if ( a[i] < b[i] )
                return -1;            
        }
        return 0;
    }
     
    public static void Shift(int k, char[] arr){                        
        int i, n = arr.length;        
        char temp[] = new char[k];
        for (i=0; i<k; i++)
            temp[i] = arr[i];
 
        for (i=k; i<n; i++)
            arr[i-k] = arr[i];
 
        int j=0;
        for (i=n-k; i<n; i++)
            arr[i] = temp[j++];
    }
     
     
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner( new File ("input.txt") );
        PrintWriter pw = new PrintWriter ( new File ("output.txt") );
                         
        String s = sc.nextLine(), t = sc.nextLine();
         
        char CharS[] = s.toCharArray();
        char CharT[] = t.toCharArray();
         
        char MaxS[] = new char[CharS.length];
        for (int i = 0; i<CharS.length; i++)
            MaxS[i] = CharS[i];
         
        Shift(1, CharS);
         
        int i,j,k;
         
        for (i = 1; i < CharS.length; i++){
            if (CharS[0] == '0'){
                Shift(1, CharS);
                continue;       
            }
             
            if ( MyCompare(MaxS, CharS) == -1 )
                for (k = 0; k<CharS.length; k++)
                    MaxS[k] = CharS[k];
                         
            Shift(1, CharS);
        }
         
        char MinT[] = new char[CharT.length];
         
        for (k = 0; k<CharT.length; k++)
            if ( CharT[k] != '0' )
                break;
         
        if (k>0)
            Shift(k, CharT);
         
        for (i = 0; i<CharT.length; i++)
            MinT[i] = CharT[i];
         
        Shift(1, CharT);        
      
        for (i = k; i < CharT.length; i++){
            if (CharT[0] == '0'){
                Shift(1, CharT);
                continue;
            }
            if ( MyCompare(MinT, CharT) == 1 )
                for (k = 0; k<CharT.length; k++)
                    MinT[k] = CharT[k];
                         
            Shift(1, CharT);
        }
         
        BigInteger x = new BigInteger( String.valueOf(MaxS) );        
        BigInteger y = new BigInteger( String.valueOf(MinT) );
         
        pw.print( x.subtract(y) );
         
        sc.close();
        pw.close();
    }
}