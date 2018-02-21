/*
TODO fix it, 3d test is failed
http://acmp.ru/index.asp?main=task&id_task=295
Разведкой был перехвачен ряд шифровок, которые передавал Джеймс Бонд. Известно, что каждое послание зашифровано методом циклического сдвига. Суть которого в том, что каждая буква заменяется на букву, отстоящую в алфавите от первой на определенном расстоянии. Это расстояние называется знаменателем шифра. Так, при знаменателе шифра 2 буква D превратится в F, буква Q – в S, а Z – в B. Известно, что Бонд использует знаменатели от 0 до 25, и составляет послания исключительно из заглавных букв английского алфавита. Знаменатели в шифровках постоянно меняются, так что расшифровать содержимое послания будет не просто. После тщательного анализа удалось примерно определить предмет посланий. Теперь для каждого послания точно известно одно из входящих туда слов.

Входные данные
В первой строке входного файла INPUT.TXT содержится строка с перехваченным посланием, а во второй строке – слово, которое обязательно присутствует в этом послании. Обе строки состоят только из заглавных английских букв и содержат от 1 до 40 символов.

Выходные данные
В выходной файл OUTPUT.TXT выведите расшифрованный текст, либо сообщение «IMPOSSIBLE», если разгадать шифровку невозможно. В тех случаях, когда расшифровка возможна с различными знаменателями, то следует вывести вариант с наименьшим таким значением.
*/
#include <stdio.h>
#include <string.h>
char s1[50];
char s2[50];
int s1_len;
int s2_len;
 
bool substr(){
    int i,j;
    for(i=0; i<=s1_len-s2_len; i++){
        for(j=0; j<s2_len; j++){
            if (s1[i+j] != s2[j]) {
                break;
            }
        }
        if (j == s2_len){
            return true;
        }
    }
 
    return false;
}
 
void shift_s1(){
    int i, new_char;
    for(i=0; i<s1_len; i++){
        new_char = (int)s1[i]-1;
        if (new_char == 64) new_char = 90;
        s1[i] = (char) ( new_char );
    }
}
 
void shiftr_s1(){
    int i, new_char;
    for(i=0; i<s1_len; i++){
        new_char = (int)s1[i]+1;
        if (new_char == 91) new_char = 65;
        s1[i] = (char) ( new_char );
    }
}
 
int main(){
    FILE* fin = fopen("input.txt", "r");
    FILE* fout = fopen("output.txt", "w");
    int i,k;
 
    fgets(s1, sizeof(s1), fin);
    fgets(s2, sizeof(s2), fin);
    s1_len = strlen(s1)-1;
    s2_len = strlen(s2)-1;
    if (s1_len < s2_len){
        printf("IMPOSSIBLE");
        return 0;
    }
    bool hacked = false;
    int kk;
    char t[50];
    char ans[50];
    strcpy(t, s1);
    for(k=0; k<26; k++){
        if (substr() == true){
            hacked = true;
            kk=k;
            strcpy(ans, s1);
            break;
        }
        shift_s1();
    }
    strcpy(s1, t);
    for(k=0; k<26; k++){
        if (substr() == true){
            hacked = true;
            if (k < kk){
                strcpy(ans, s1);
            }
            break;
        }
        shiftr_s1();
    }
    if (hacked == true){ fprintf(fout, "%s", ans); }
    else { fprintf(fout, "IMPOSSIBLE"); }
 
    fclose(fin); fclose(fout);
    return 0;
}