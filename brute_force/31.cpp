/*
http://acmp.ru/index.asp?main=task&id_task=31
Перестановкой P[1..n] размера n называется набор чисел от 1 до n, расположенных в определенном порядке. При этом в нем должно присутствовать ровно один раз каждое из этих чисел. Примером перестановок являются 1,3,4,5,2 (для n=5) и 3,2,1 (для n=3), а, например, 1,2,3,4,5,1 перестановкой не является, так как число 1 встречается два раза.

Число i называется неподвижной точкой для перестановки P, если P[i] = i. Например, в перестановке 1,3,4,2,5 ровно две неподвижных точки: 1 и 5, а перестановка 4,3,2,1 не имеет неподвижных точек.

Даны два числа: n и k. Найдите количество перестановок размера n с ровно k неподвижными точками.

Входные данные
Входной файл INPUT.TXT содержит два целых числа n (1 ≤ n ≤ 9) и k (0 ≤ k ≤ n).

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
*/

#include <stdio.h>
#include <iostream>
int *X;
int N, K, ans;
 
void Swap(int a,int b){
    int t = X[a];
    X[a] = X[b];
    X[b] = t;
}
void Generate(int k){
    if (k==N){
        int np = 0;
        for(int i=0; i<N; i++){
            if (X[i] == i+1) np++;
        }
        if (np == K) ans++;
    }
    else{
        for(int j=k; j<N; j++){
            Swap(k,j);
            Generate(k+1);
            Swap(k,j);
        }
    }
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    ans = 0;
    fscanf(fin, "%d %d", &N, &K);
    X = new int[N];
    for(int i=0;i<N;i++) X[i]=i+1;
    Generate(0);
    fprintf(fout, "%d", ans);
    fclose(fin);
    fclose(fout);
    return 0;
}