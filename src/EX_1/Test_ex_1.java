package EX_1;

public class Test_ex_1 {
    //Запуск программы
    public static void main(String[] args) {
        //Тест с числами
        string_digits_sum Ex_1 = new string_digits_sum("This line has six as a sum 123");
        System.out.print(Ex_1);
        //Тест без чисел
        Ex_1 = new string_digits_sum("This line has zero as a sum");
        System.out.print(Ex_1);
        //Ваш тест
        Ex_1 = new string_digits_sum();
        System.out.print(Ex_1);

    }

}
