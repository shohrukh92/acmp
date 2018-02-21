/*
http://acmp.ru/index.asp?main=task&id_task=156
Требуется найти число способов расставить на шахматной доске N×N K ладей так, чтобы они не били друг друга. Все ладьи считаются одинаковыми.

Входные данные
Во входном файле INPUT.TXT записаны натуральные числа N и K (N, K ≤ 8).

Выходные данные
В выходной файл OUTPUT.TXT выведите одно целое число – ответ на задачу.
*/
#include <iostream>
#include <stdio.h>
 
using namespace std;
 
int fact(int n){
    if (n == 0) return 1;
    return n*fact(n-1);
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    int n,k,ans;
    fscanf(fin, "%d %d", &n, &k);
    if (k>n) {
        k = n;
        ans = 0;
    }
    else{
        int nf = fact(n);
        int kf = fact(k);
        int nk = fact(n-k);
        ans = nf*nf;
        ans /= kf;
        ans /= fact(n-k)*fact(n-k);
    }
 
 
    fprintf(fout, "%d", ans);
 
    fclose(fin);
    fclose(fout);
    return 0;
}