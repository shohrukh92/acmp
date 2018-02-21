/*
http://acmp.ru/index.asp?main=task&id_task=235
Петя написал программу движения робота К-79. Программа состоит из следующих команд:

S — сделать шаг вперед
L — повернуться на 90 градусов влево
R — повернуться на 90 градусов вправо
Напишите программу, которая по заданной программе для робота определит, сколько шагов он сделает прежде, чем впервые вернется на то место, на котором уже побывал до этого, либо установит, что этого не произойдет.

Входные данные
Во входном файле INPUT.TXT записана одна строка из заглавных английских букв S, L, R, описывающая программу для робота. Общее число команд в программе от 1 до 200, при этом команд S — не более 50.

Выходные данные
В выходной файл OUTPUT.TXT выведите, сколько шагов будет сделано (то есть выполнено команд S) прежде, чем робот впервые окажется в том месте, через которое он уже проходил. Если такого не произойдет, выведите в выходной файл число –1.
*/
import java.io.*;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    Scanner in;
    PrintWriter out;
 
 
    public void run() throws IOException{
        in = new Scanner(new File("input.txt"));
        out = new PrintWriter(new File("output.txt"));
 
        Robot rbt = new Robot();
        String comands = in.nextLine();
        int len = comands.length();
        int ans = -1;
        for(int i=0; i<len; i++){
            char curr = comands.charAt(i);
            if (curr == 'S'){
                if (!rbt.S()){
                    ans = rbt.steps;
                    break;
                }
            }
            else if (curr == 'L'){
                rbt.L();
            }
            else {
                rbt.R();
            }
        }
        out.print(ans);
 
        out.close();
    }
 
    public class Robot{
        public char direction;
        public int steps;
        public int arr[][];
        public int x, y;
        public Robot(){
            direction = 'u';
            steps = 1;
            x = 50;
            y = 50;
            arr = new int[110][110];
            arr[x][y] = 1;
        }
        public void R(){
            switch (direction){
                case 'u':
                    direction = 'r';
                    break;
                case 'r':
                    direction = 'd';
                    break;
                case 'd':
                    direction = 'l';
                    break;
                case 'l':
                    direction = 'u';
                    break;
                default:
                    break;
            }
        }
        public void L(){
            switch (direction){
                case 'u':
                    direction = 'l';
                    break;
                case 'l':
                    direction = 'd';
                    break;
                case 'd':
                    direction = 'r';
                    break;
                case 'r':
                    direction = 'u';
                    break;
                default:
                    break;
            }
        }
 
        public boolean S(){
            switch (direction){
                case 'u':
                    if (arr[x][y+1] == 1){ return false; }
                    else{
                        y++;
                    }
                    break;
                case 'l':
                    if (arr[x-1][y] == 1){ return false; }
                    else{
                        x--;
                    }
                    break;
                case 'd':
                    if (arr[x][y-1] == 1){ return false; }
                    else{
                        y--;
                    }
                    break;
                case 'r':
                    if (arr[x+1][y] == 1){ return false; }
                    else{
                        x++;
                    }
                    break;
                default:
                    break;
            }
            arr[x][y] = 1;
            steps++;
            return true;
        }
    }
}