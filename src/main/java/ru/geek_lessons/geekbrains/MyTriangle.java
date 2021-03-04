package ru.geek_lessons.geekbrains;

public class MyTriangle {

    //площадь треугольника

    public static double triangleSquare(int a, int b, int c){
        int p = (a+b+c);
        int s = p*(p-a)*(p-b)*(p-c);
        return Math.sqrt(s);
    }
}
