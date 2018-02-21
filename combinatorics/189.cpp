/*
http://acmp.ru/index.asp?main=task&id_task=189
Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N. Количество всех перестановок порядка N равно PN = N!

Требуется найти перестановку по ее номеру в лексикографическом порядке (по алфавиту). Например, для N=3 лексикографический порядок перестановок выглядит следующим образом:

(1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), (3,2,1).

Таким образом, перестановка (2,3,1) имеет номер 4 в этой последовательности.

Входные данные
В первой строке входного файла INPUT.TXT записано число N (1 ≤ N ≤ 12) - количество элементов в перестановке, во второй - число K (1 ≤ K ≤ N!) - номер перестановки.

Выходные данные
В выходной файл OUTPUT.TXT выведите через пробел N чисел - искомую перестановку.
*/

#include <iostream>
#include <stdio.h>
using namespace std;
 
int *A, *Ans;
int n;
 
int fact(int n){
    if (n == 1) return 1;
    else return n*fact(n-1);
}
 
void _swap(int i, int j){
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
    return;
}
 
void pi(){
    int i = n;
    while(i>0 && A[i] < A[i-1]) i--;
 
    int j = n;
    while(A[j] < A[i-1]) j--;
    _swap(i-1, j);
    for(j=0; j<=(n-i+1)/2 - 1; j++){
        _swap(i+j, n-j);
    }
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    int i,j,J;
    fscanf(fin, "%d %d", &n, &J);
    A = new int[n+1];
 
    int nf = fact(n)/n;
    int init = J/nf;
    if (J % nf != 0) init++;
 
    A[1] = init;
    for(i=2, j=1; i<=n; i++, j++) {
        if (j == init) j++;
        A[i] = j;
    }
    for(i=1; i<=n; i++) printf("%d ", A[i]);
    j = (init-1)*nf+1;
    while(true){
        if (j == J) break;
        pi();
        j++;
    }
    for(i=1; i<=n; i++) fprintf(fout, "%d ", A[i]);
 
    delete[] A;
    fclose(fin);
    fclose(fout);
    return 0;
}