package EX_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

//Класс программы
public class simple_dividers_prog {
    //Сканнер для ввода значений
    protected Scanner scaner = new Scanner(System.in);
    //Переменные для подсчёта простых делителей
    private int number = 0;
    private ArrayList<Integer> simple_dividers = new ArrayList<>();

    //Конструктор
    public simple_dividers_prog()
    {
        try
        {
            number = scaner.nextInt();
            divide_number();
        }
        catch (Exception e)
        {
            System.out.println("INPUT NOT VALID");
        }
    }

    //Метод подсчитывающий простые делители числа
    private void divide_number()
    {
        simple_dividers.clear();
        simple_dividers.add(1);
        int number = this.number;
        int divider = 2;
        while(number != 1)
        {
            if(number % divider == 0)
            {
                simple_dividers.add(divider);
                number /= divider;
            }
            else
                divider++;
        }
    }
    //Метод для вывода массива делителей
    private StringBuilder print_dividers()
    {
        StringBuilder line = new StringBuilder();
        if(simple_dividers.size() > 0) {
            for (int i = 0; i < simple_dividers.size() - 1; i++) {
                line.append(simple_dividers.get(i) + " * ");
            }
            line.append(simple_dividers.get(simple_dividers.size() - 1));
        }
        return line;
    }
    //Вывод программы
    public String toString() {
        return "Original number is " + number + '\n' +
                "It has this simple dividers " + print_dividers() + '\n';
    }
}
