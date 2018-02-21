/*
http://acmp.ru/index.asp?main=task&id_task=680
Садовник посадил N деревьев в один ряд. После посадки деревьев садовнику нужно их покрасить. В его распоряжении есть краска трех цветов: белая, синяя и оранжевая. Сколько способов покраски деревьев есть у него, если никакие два соседних дерева нельзя красить в одинаковый цвет?

Входные данные
В единственной строке входного файла INPUT.TXT записано одно натуральное число - количество деревьев N (1 ≤ N ≤ 50).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно число - количество способов покраски.
*/

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner( new File("input.txt") );
        PrintWriter pw = new PrintWriter( new File("output.txt") );
 
        int n = sc.nextInt();
        BigInteger N = (new BigInteger("2")).pow(n-1).multiply(new BigInteger("3"));
 
        pw.println(N);
        sc.close();
        pw.close();
    }
}