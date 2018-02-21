/*
http://acmp.ru/index.asp?main=task&id_task=102
В декартовой системе координат на плоскости заданы координаты вершин треугольника и еще одной точки. Требуется написать программу, определяющую, принадлежит ли эта точка треугольнику.

Входные данные
В четырех строках входного файла INPUT.TXT находятся пары целых чисел - координаты точек. Числа в первых трех строках - это координаты вершин треугольника (x1,y1), (x2,y2), (х3,у3), в четвертой строке - координаты тестируемой точки (x4,у4). Все координаты не превышают 10000 по абсолютной величине.

Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести слово «In», если точка находится внутри треугольника и «Out» в противном случае.
*/

#include <iostream>
#include <fstream>
#include <math.h>
using namespace std;
typedef struct ppoint
{
    int x;
    int y;
}point;
 
point mas[3];
 
double triangle_area()
{
    int i;
    double s=0;
    for (i=0; i<3; i++)
    {
        s=s+(double)(mas[(i+1)%3].x - mas[i].x)*
        ((double)(mas[(i+1)%3].y + mas[i].y))/2;
    }
    return fabs(s); //*********-----+++++
}
 
 
int main()
{
    ifstream in("INPUT.txt");
    ofstream out("OUTPUT.txt");
    short i,x0,y0,xv,yv;
    for (i=0; i<3; i++)
    {
        in>>mas[i].x;
        in>>mas[i].y;
    }
    in>>x0>>y0;
    double sp=0;
    double str = triangle_area();
        //============
    for (i=0; i<3; i++)
    {
        xv=mas[i].x;
        yv=mas[i].y;
 
        mas[i].x=x0;
        mas[i].y=y0;
 
        sp=sp + triangle_area();
        mas[i].x=xv;
        mas[i].y=yv;
    }
        //============
    if (str!=sp) out<<"Out";
    else out<<"In";
 
    in.close();
    out.close();
    return 0;
}