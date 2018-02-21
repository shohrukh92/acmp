/*
http://acmp.ru/index.asp?main=task&id_task=519
Требуется написать программу, которая найдет наименьшее и наибольшее числа, состоящие из тех же цифр, что и заданное натуральное число N.

Входные данные
Входной файл INPUT.TXT содержит натуральное число N (N ≤ 2×109).

Выходные данные
Выходной файл OUTPUT.TXT должен содержать в одной строке наименьшее, а через пробел – наибольшее числа.
*/
#include <iostream>
#include <stdio.h>
#include <vector>
using namespace std;
 
 
void printReverse(FILE* fout, vector<int> digits){
    for(int i=9; i>=0; i--){
        for(int j=0; j<digits[i]; j++){
            fprintf(fout, "%d", i);
        }
    }
}
 
void printDigits(FILE* fout, vector<int> digits, int ii){
    for(int i=ii; i<10; i++){
        for(int j=0; j<digits[i]; j++){
            fprintf(fout, "%d", i);
        }
    }
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    char curr;
    int i = 0, j, code;
    vector<int> digits(10, 0);
    while( fscanf(fin, "%c", &curr) == 1 ){
        code = (int)curr-48;
        digits[code]++;
    }
    if (digits[0] !=0 ){
        int pos = 0;
        for (i=1; i<10; i++){
            if (digits[i] != 0){
                pos = i;
                break;
            }
        }
        fprintf(fout, "%d", pos);
        digits[pos]--;
        printDigits(fout, digits, 0);
        digits[pos]++;
        fprintf(fout, " ");
        printReverse(fout, digits);
    }
    else{
        printDigits(fout, digits, 1);
        fprintf(fout, " ");
        printReverse(fout, digits);
    }
 
    fclose(fin); fclose(fout);
    return 0;
}