/*
TODO fix it, Wrong answer in 20 test
http://acmp.ru/index.asp?main=task&id_task=681
Какое минимальное количество спичек необходимо для того, чтобы выложить на плоскости N квадратов со стороной в одну спичку? Спички нельзя ломать и класть друг на друга. Вершинами квадратов должны быть точки, где сходятся концы спичек, а сторонами – сами спички.

Напишите программу, которая по количеству квадратов N, которые необходимо составить, находит минимальное необходимое для этого количество спичек.

Входные данные
В единственной строке входного файла INPUT.TXT записано одно целое число N (1 ≤ N ≤ 109).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число – минимальное количество спичек, требуемых для составления заданного количества квадратов.
*/
#include <iostream>
#include <fstream>
#include <cmath>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
using namespace std;
 
int main(){
    ifstream fin("input.txt");
    ofstream fout("output.txt");
 
    int n = 0;
    fin>>n;
    int root = (int)sqrt( (double)n );
    int answer = 2*root*(root + 1);
    int r = n - root*root;
 
    if (r != 0){
       if (r <= root){
           answer += 2*r+1;
       }
       else {
           answer += 2*root+1;
           r -= root;
           if (r != 0){
               answer += 2*r+1;
           }
       }
    }
 
 
    fout<<answer;
 
 
    fin.close();
    fout.close();
 
    return 0;
}