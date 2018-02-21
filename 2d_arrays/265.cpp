/*
http://acmp.ru/index.asp?main=task&id_task=265
Из шахматной доски по границам клеток выпилили связную (не распадающуюся на части) фигуру без дыр. Требуется определить ее периметр.

Входные данные
Во входном файле INPUT.TXT сначала записано число N (1 ≤ N ≤ 64) – количество выпиленных клеток. В следующих N строках указаны координаты выпиленных клеток, разделенные пробелом (номер строки и столбца – числа от 1 до 8). Каждая выпиленная клетка указывается один раз.

Выходные данные
В выходной файл OUTPUT.TXT выведите одно число – периметр выпиленной фигуры (сторона клетки равна единице).
*/
#include <iostream>
#include <stdio.h>
#include <vector>
#include <queue>
 
using namespace std;
 
class Point{
    public:
        int x;
        int y;
        Point(int newX, int newY){
            x = newX;
            y = newY;
        };
};
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
 
    vector<vector<int> > all(10, vector<int>(10, 0));
    queue<Point> points;
    int n, i, x, y;
    fscanf(fin, "%d", &n);
    for(i=0; i<n; i++){
        fscanf(fin, "%d %d", &x, &y);
        all[x][y] = 1;
        Point p(x,y);
        points.push(p);
    }
    Point* curr;
    int ans = 0;
    while(!points.empty()) {
        curr = &points.front();
        x = curr->x;
        y = curr->y;
        if (all[x-1][y] == 0) ans++;
        if (all[x][y-1] == 0) ans++;
        if (all[x+1][y] == 0) ans++;
        if (all[x][y+1] == 0) ans++;
        points.pop();
    }
    fprintf(fout, "%d", ans);
 
    fclose(fin);
    fclose(fout);
    return 0;
}