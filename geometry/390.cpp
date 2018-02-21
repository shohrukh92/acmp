/*
http://acmp.ru/index.asp?main=task&id_task=390
Одним из субъектов Флатландии является Треугольная область. Как следует из ее названия, она имеет форму треугольника, вершины которого находятся в точках с координатами (x1,y1), (x2,y2), (x3,y3). Административный центр этой области находится в точке с координатами (xc,yc), которая лежит строго внутри указанного треугольника.

Для оценки транспортного и логистического потенциала области, ее руководству понадобилось узнать расстояние от административного центра области до ее границы. Напишите программу, которая вычислит это расстояние.

Входные данные
Первая строка входного файла INPUT.TXT содержит шесть целых чисел – x1, y1, x2, y2, x3, y3. Вторая строка входного файла содержит два целых числа – xc и yc. Все числа во входном файле не превосходят 10000 по абсолютной величине. В заданном треугольнике нет тупых углов.

Выходные данные
В выходной файл OUTPUT.TXT выведите искомое расстояние до границы с точностью не менее 10^-6.
*/
#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;
int xc,yc;
double min_d;
void calc_distance(int x1, int y1, int x2, int y2){
    int dx = x2-x1;
    int dy = y2-y1;
    double k = 1.0*dy/dx;
    double b = y1 - k*x1;
 
    double A = k;
    double B = -1.0;
    double C = b;
 
    double d = fabs( 1.0*(A*xc + B*yc + C) );
    d /= sqrt( 1.0*(A*A + B*B) );
    if (d < min_d) min_d = d;
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    int x1,y1,x2,y2,x3,y3;
    fscanf(fin, "%d %d %d %d %d %d\n%d %d", &x1,&y1, &x2,&y2, &x3,&y3, &xc, &yc);
    min_d = 1e20;
    calc_distance(x1,y1, x2,y2);
    calc_distance(x2,y2, x3,y3);
    calc_distance(x1,y1, x3,y3);
    fprintf(fout, "%.10f", min_d);
 
    fclose(fin);
    fclose(fout);
    return 0;
}