/*
http://acmp.ru/index.asp?main=task&id_task=557
Входные данные
В первой строчке входного файла INPUT.TXT стоят два числа: m - количество матриц, n - размер каждой из матриц (1 ≤ m ≤ 130, 1 ≤ n ≤ 130). В следующей строчке содержатся номер строки и столбца, интересующего Аню элемента 1 ≤ a ≤ n, 1 ≤ b ≤ n. В третьей строке содержится простое число p ≤ 1000. Далее следует описание m матриц. Описание каждой матрицы состоит из n строк. В каждой из строк содержится n неотрицательных целых чисел, меньших p. Соседние числа в строке разделены пробелом, а перед каждой матрицей пропущена строка.

Выходные данные
В выходной файл OUTPUT.TXT выведите нужный Ане элемент произведения матриц.
*/
#include <stdio.h>
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    int m, n, ii, jj, p;
    fscanf(fin, "%d %d %d %d %d", &m, &n, &ii, &jj, &p);
    ii--;
    jj--;
    int *i_row = new int[n];
    int *t_row = new int[n];
    int m2[210][210];
    int c, i, j, t, s;
 
    for(i=0; i<n; i++){
        for(j=0; j<n; j++){
            fscanf(fin, "%d", &m2[i][j]);
        }
    }
    for(i=0; i<n; i++) i_row[i] = m2[ii][i];
 
 
    for(int t=1; t<m; t++){
        for(i=0; i<n; i++){ for(j=0; j<n; j++){ fscanf(fin, "%d", &m2[i][j]); } }
 
        for(j=0; j<n; j++){
            int s = 0;
            for(i=0; i<n; i++){
                s += i_row[i]*m2[i][j];
                if (s > p) s = s%p;
            }
            t_row[j] = s;
        }
        for(i=0; i<n; i++) i_row[i] = t_row[i];
    }
 
    fprintf(fout, "%d", i_row[jj]);
 
    fclose(fin);
    fclose(fout);
    return 0;
}