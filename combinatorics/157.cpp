/*
http://acmp.ru/index.asp?main=task&id_task=157
На день рождения Пете подарили набор карточек с буквами. Теперь Петя с большим интересом составляет из них разные слова. И вот, однажды, составив очередное слово, Петя заинтересовался вопросом: "А сколько различных слов можно составить из тех же карточек, что и данное?".

Помогите ему ответить на этот вопрос.

Входные данные
Во входном файле INPUT.TXT задано слово, составленное Петей - строка из маленьких английских букв не длиннее 15 символов.

Выходные данные
В выходной файл OUTPUT.TXT выведите одно целое число - ответ на поставленную задачу.
*/
#include <fstream>
#include <string>
#include <algorithm>
#include<math.h>
#include<iomanip>
#include <sstream>
using namespace std;
  
ifstream fin("input.txt");
ofstream fout("output.txt");
  
int main()
{
      string s;
      int k=1;
      long long int fact=1,sum=1,pr=1;
      fin>>s;
      int len = s.length();
  
      for(int i=1; i<=len; i++)
            fact=fact*i;
  
      sort(s.begin(),s.end());
  
      for(int i=0; i<len; i++)
      {
            if(s[i]==s[i+1])
                  k++;
            else
            {
                   for(int j=1; j<=k; j++)
                        sum=sum*j;
  
                  k=1;
            }
  
      }
      fout<<fact/sum;
  
    return 0;
  
}