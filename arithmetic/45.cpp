/*
http://acmp.ru/index.asp?main=task&id_task=45
Требуется найти наименьшее натуральное число Q такое, что произведение его цифр равно заданному числу N.

Входные данные
В единственной строке входного файла INPUT.TXT записано одно целое число N (0 ≤ N ≤ 109).

Выходные данные
В выходной файл OUTPUT.TXT нужно вывести искомое число Q. В том случае, если такого числа не существует, следует вывести -1.
*/
#include <fstream>
#include <cmath>
#include <vector>
  
using namespace std;
  
ifstream cin("input.txt");
ofstream cout("output.txt");
  
int main()
{       
    int n;
    cin >> n;
    vector<int> ans;

    if(n == 0)
        cout << 10;
    else if(n <= 9)
        cout << n;
    else
    {
        for(int i = 9; i >= 2; i--)
            while(n % i == 0)
            {
                ans.push_back(i);
                n /= i;
            }
        if(n != 1)
            cout << -1;
        else
            for(int i = ans.size()-1; i >= 0; i--)
                cout << ans[i];
    }
}