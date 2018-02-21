/*
http://acmp.ru/index.asp?main=task&id_task=447
Требуется найти последнюю ненулевую цифру числа N! = 1*2*3*…*N.

Входные данные
Входной файл INPUT.TXT содержит единственное натуральное число N (N ≤ 9999).

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
*/
#include <stdio.h>
  
int main(){
    int n, i, j, k=5, km=0, f=1;
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
  
    scanf("%d", &n);
    while(n/k>0)
    {
        km+=n/k;
        k*=5;
    }
    for(i=2; i<=n; i++)
    {
        j=i;
        while(j%5==0)
        {
            j/=5;
        }
        while(km>0 && j%2==0)
        {
            km--;
            j/=2;
        }
        f=(f*(j%10))%10;
    }
    printf("%d", f);
    return 0;
}