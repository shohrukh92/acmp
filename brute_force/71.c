/*
http://acmp.ru/index.asp?main=task&id_task=71
У Вас есть N камней с массами W1, W2 , … WN. Требуется разложить камни на 2 кучки так, чтобы разница масс этих кучек была минимальной.

Входные данные
В первой строке входного файла INPUT.TXT записано число N – количество камней (1 ≤ N ≤ 18). Во второй строке через пробел перечислены массы камней W1, W2 , … WN (1 ≤ Wi ≤ 105).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно неотрицательное целое число – минимально возможную разницу между массами двух кучек.
*/

#include <stdio.h>

int n, w[20], bin[20];
 
int bin_add(){
    if (bin[n-1] == 0){
        bin[n-1] = 1;
        return 1;
    }
    int i = n-1;
    while(bin[i] == 1 && i>=0){
        bin[i] = 0;
        i--;
    }
    if (i == -1) return -1;
    bin[i] = 1;
    return 1;
}
 
int abs(int a){
    if (a < 0) return -1*a;
    return a;
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    int i, curr, min_dif = 0;
    fscanf(fin, "%d", &n);
    for(i=0; i<n; i++) {
        fscanf(fin, "%d", &curr);
        w[i] = curr;
        min_dif += curr;
        bin[i] = 0;
    }
 
    while(bin_add() > 0){
        int left = 0, right = 0;
        for(i=0; i<n; i++){
            if (bin[i] == 0)
                left += w[i];
            else
                right += w[i];
        }
        int curr_dif = abs(right - left);
        if (curr_dif < min_dif) min_dif = curr_dif;
    }
 
    fprintf(fout, "%d", min_dif);
 
    fclose(fin);
    fclose(fout);
    return 0;
}