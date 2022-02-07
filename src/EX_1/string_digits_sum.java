package EX_1;


import java.util.Scanner;
//Класс программы
public class string_digits_sum {
    //Сканнер для ввода значений
    protected Scanner scaner = new Scanner(System.in);
    //Переменные для работы со строкой и подсчёта суммы цифр в ней
    private String line = "";
    private int digits_sum = 0;
    //Конструктор без значений
    public string_digits_sum()
    {
        line = scaner.nextLine();
        digits_sum = count_digits();
    }
    //Конструктор со значением задающие строку
    public string_digits_sum(String line)
    {
        this.line = line;
        digits_sum = count_digits();
    }
    //метод считающий сумму цифр в строке
    private int count_digits()
    {
        int digits_sum = 0;
        //проход по строке и проверка символов
        for(int i = 0; i < line.length(); i++)
        {
            if(Character.isDigit(line.charAt(i)))
                digits_sum += line.charAt(i) - 48;
        }
        return digits_sum;
    }
    //Геттеры
    public String getLine() {
        return line;
    }

    public int getDigits_sum() {
        return digits_sum;
    }
    //Вывод
    public String toString() {
        return "Input line is " + line + '\n' +
                "Digits sum is " + digits_sum + '\n';
    }
}
