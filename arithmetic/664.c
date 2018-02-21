/*
http://acmp.ru/index.asp?main=task&id_task=664
На сковородке одновременно можно положить k котлет. Каждую котлету нужно с каждой стороны обжаривать m минут непрерывно. За какое наименьшее время удастся поджарить с обеих сторон n котлет?

Входные данные
В единственной строке входного файла INPUT.TXT записано три натуральных числа: k, m, n, не превышающих 30000.

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести единственное число – минимальное время, за которое можно поджарить все котлеты.
*/
#include <stdio.h>
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    int k,m,n;
    fscanf(fin, "%d %d %d", &k, &m, &n);
 
    int ans;
    if (n < k ) ans = 2*m;
    else if (n % k == 0) ans = 2*m*n/k;
    else {
        ans = 2*m*(n/k-1);
        n = n%k;
        if (n <= k/2) ans += 3*m;
        else ans += 4*m;
    }
    fprintf(fout, "%d", ans);
    fclose(fin);
    fclose(fout);
    return 0;
}