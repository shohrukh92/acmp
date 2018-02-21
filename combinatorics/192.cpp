/*
http://acmp.ru/index.asp?main=task&id_task=192
Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N.

Найдите по заданной перестановке следующую в лексикографическом порядке (будем считать, что за перестановкой (N, N-1, ... , 3, 2, 1) следует тождественная перестановка, то есть (1, 2, 3, ... , N)).

Входные данные
В первой строке входного файла INPUT.TXT содержится число N (1 ≤ N ≤ 104). Во второй строке содержится перестановка (последовательность натуральных чисел от 1 до N, разделенных пробелами).

Выходные данные
Выходной файл OUTPUT.TXT должен содержать искомую перестановку.
*/

#include <iostream>
#include <stdio.h>
using namespace std;
 
int *A;
int n;
 
void _swap(int i, int j){
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
    return;
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    fscanf(fin, "%d", &n);
    A = new int[n+1];
    int i, j;
    fscanf(fin, "%d", &A[1]);
    bool decr = true;
    for(i=2; i<=n; i++) {
        fscanf(fin, "%d", &A[i]);
        if (A[i] > A[i-1]) { decr = false; }
    }
    if (decr){
        for(i=n; i>0; i--)
            fprintf(fout, "%d ", A[i]);
    }
    else{
         i = n;
        while(i>0 && A[i] < A[i-1]) i--;
 
        j = n;
        while(A[j] < A[i-1]) j--;
        _swap(i-1, j);
        for(j=0; j<=(n-i+1)/2 - 1; j++){
            _swap(i+j, n-j);
        }
 
        for(i=1; i<=n; i++)
            fprintf(fout, "%d ", A[i]);
    }
 
 
    delete[] A;
    fclose(fin);
    fclose(fout);
    return 0;
}