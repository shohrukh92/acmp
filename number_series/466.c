/*
http://acmp.ru/index.asp?main=task&id_task=466
Функция f(n) определена следующим образом:

f(0)=0, f(1)=1, f(2n)=f(n), f(2n+1)=f(n)+f(n+1).

Требуется написать программу, которая по заданному натуральному числу N определяет значение функции f(N).

Входные данные
Входной файл INPUT.TXT содержит число N (1 ≤ N ≤ 2147483647).

Выходные данные
В выходной файл OUTPUT.TXT выведите значение f(N).
*/

#include <stdio.h>
 
unsigned int f(unsigned int n){
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (n % 2 == 0) return f(n/2);
    else return f(n/2) + f(n/2 + 1);
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    unsigned int n;
    fscanf(fin, "%d", &n);
    fprintf(fout, "%d", f(n));
 
    fclose(fin);
    fclose(fout);
    return 0;
}