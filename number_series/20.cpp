/*
http://acmp.ru/index.asp?main=task&id_task=20
Последовательность a1, a2, a3, … , an-1, an называется пилообразной, если она удовлетворяет одному из следующих условий:
1)	a1 < a2 > a3 < … > an-1 < an
2)	a1 > a2 < a3 > … < an-1 > an

Дана числовая последовательность. Требуется определить длину самой длинной ее пилообразной непрерывной подпоследовательности.

Входные данные
В первой строке входного файла INPUT.TXT записано натуральное число N – количество элементов последовательности. Во второй строке файла через пробел записаны N элементов целочисленной последовательности {ai}. Ограничения: N<106, |ai| < 32000.

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — длину самой длиной непрерывной пилообразной подпоследовательности.
*/

#include <iostream>
#include <stdio.h>
using namespace std;
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    int i,n,x1,x2,x3,max_len, curr_len;
    fscanf(fin, "%d", &n);
 
    if (n == 1){
        max_len = 1;
    }
    else{
        fscanf(fin, "%d %d", &x1, &x2);
        if (n == 2){
            if (x1 == x2) max_len = 1;
            else max_len = 2;
        }
        else{
            max_len = -1;
            curr_len = 2; //?
            bool eq = true;
            for(i=2; i<n; i++){
                fscanf(fin, "%d", &x3);
                if (x1 != x2 || x2 != x3) eq = false;
                if ((x2 > x1 && x2 > x3) || (x2 < x1 && x2 < x3)){
                    curr_len++;
                }
                else{
                    if (curr_len > max_len) max_len = curr_len;
                    curr_len = 2;
                }
                x1 = x2;
                x2 = x3;
            }
            if (eq) max_len = 1;
            else if (curr_len > max_len) max_len = curr_len;
        }
    }
    fprintf(fout, "%d", max_len);
    fclose(fin);
    fclose(fout);
    return 0;
}