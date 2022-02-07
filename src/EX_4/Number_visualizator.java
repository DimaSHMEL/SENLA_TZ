package EX_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Number_visualizator {
    //Сканнер для ввода значений
    protected Scanner scaner = new Scanner(System.in);
    //Переменные для визуализаии числа
    private String number = "";
    final int max = 70;
    private ArrayList<boolean[][]> vizual = new ArrayList<>();
    private int line_mark = 0, x_mark = 0, y_mark = 0;
    interface FILL
    {
        void fill();
    }
    private FILL[] fillActions = new FILL[] {
            new FILL() { public void fill(){ fill_0();} },
            new FILL() { public void fill(){ fill_1();} },
            new FILL() { public void fill(){ fill_2();} },
            new FILL() { public void fill(){ fill_3();} },
            new FILL() { public void fill(){ fill_4();} },
            new FILL() { public void fill(){ fill_5();} },
            new FILL() { public void fill(){ fill_6();} },
            new FILL() { public void fill(){ fill_7();} },
            new FILL() { public void fill(){ fill_8();} },
            new FILL() { public void fill(){ fill_9();} },
    };
    //Конструктор
    public Number_visualizator()
    {
        number = scaner.nextLine();
        vizual.add(new boolean[7][max]);
        fill_viz();
        print_viz();
    }
    private void fill_viz()
    {
        for(int i = 0; i < number.length(); i++)
        {
            if(x_mark == max) {
                x_mark = 0;
                line_mark++;
                vizual.add(new boolean[7][max]);
            }

            fillActions[number.charAt(i) - 48].fill();

        }
    }
    private void fill_0()
    {
        for(int i = 0; i < 5; i++)
        {
            vizual.get(line_mark)[y_mark + 1 + i][x_mark + 1] = true;
            vizual.get(line_mark)[y_mark + 1 + i][x_mark + 5] = true;
        }
        for(int i = 0; i < 3; i++)
        {
            vizual.get(line_mark)[y_mark][x_mark + 2  + i] = true;
            vizual.get(line_mark)[y_mark + 6][x_mark + 2  + i] = true;
        }
        x_mark+=7;
    }
    private void fill_1()
    {
        for (int i = 0; i < 7; i++)
        {
            vizual.get(line_mark)[y_mark+i][x_mark+3] = true;
        }
        vizual.get(line_mark)[y_mark+1][x_mark+2] = true;
        vizual.get(line_mark)[y_mark+2][x_mark+1] = true;
        x_mark+=7;
    }
    private void fill_2()
    {
        vizual.get(line_mark)[y_mark + 1][x_mark + 1] = true;
        vizual.get(line_mark)[y_mark + 2][x_mark + 1] = true;
        for(int i = 0; i < 5; i++) {
            vizual.get(line_mark)[y_mark + 6][x_mark + 1 + i] = true;
        }
        for(int i = 0; i < 5; i++) {
                vizual.get(line_mark)[y_mark + 5 - i][x_mark + 1 + i] = true;
        }
        for(int i = 0; i < 3; i++) {
            vizual.get(line_mark)[y_mark][x_mark + 2 + i] = true;
        }
        x_mark+=7;
    }
    private void fill_3()
    {
        for(int i = 0; i < 2; i++)
        {
            vizual.get(line_mark)[y_mark][x_mark+2+i] = true;
            vizual.get(line_mark)[y_mark + 3][x_mark+2+i] = true;
            vizual.get(line_mark)[y_mark + 6][x_mark  + 2 + i] = true;
        }
        for(int i = 0; i < 7; i++)
        {
            vizual.get(line_mark)[y_mark  + i][x_mark+4] = true;

        }

        x_mark+=7;
    }
    private void fill_4() {
        for (int i = 0; i < 7; i++)
        {
            vizual.get(line_mark)[y_mark + i][x_mark + 4] = true;
        }
        for (int i = 0; i < 5; i++)
        {
            vizual.get(line_mark)[y_mark + 4][x_mark + 1  + i] = true;
        }
        for (int i = 0; i < 5; i++)
        {
            vizual.get(line_mark)[y_mark + 4][x_mark + 1  + i] = true;
        }
        for (int i = 0; i < 4; i++)
        {
            vizual.get(line_mark)[y_mark + 3 - i][x_mark + 1  + i] = true;
        }

        x_mark+=7;
    }
    private void fill_5()
    {
        for(int i = 0; i < 4; i++)
        {
            vizual.get(line_mark)[y_mark][x_mark + 1 + i] = true;
            vizual.get(line_mark)[y_mark + 3][x_mark + 1  + i] = true;
            vizual.get(line_mark)[y_mark + 6][x_mark  + 1 + i] = true;
        }
        for(int i = 0; i < 4; i++)
        {
            vizual.get(line_mark)[y_mark + i][x_mark + 1] = true;
            vizual.get(line_mark)[y_mark + 3 + i][x_mark + 4] = true;

        }
        x_mark+=7;
    }
    private void fill_6()
    {
        for(int i = 0; i < 4; i++)
        {
            vizual.get(line_mark)[y_mark][x_mark + 2 + i] = true;
            vizual.get(line_mark)[y_mark + 3][x_mark + 2  + i] = true;
            vizual.get(line_mark)[y_mark + 6][x_mark  + 2 + i] = true;
        }
        for(int i = 0; i < 2; i++)
        {
            vizual.get(line_mark)[y_mark + 1 + i][x_mark + 2] = true;
            vizual.get(line_mark)[y_mark + 4 + i][x_mark + 2 ] = true;
            vizual.get(line_mark)[y_mark + 4  + i][x_mark  + 5] = true;
        }
        x_mark+=7;
    }
    private void fill_7()
    {
        for(int i = 0; i < 6; i++)
        {
            vizual.get(line_mark)[y_mark][x_mark + i] = true;
        }
        for(int i = 0; i < 5; i++)
        {
            vizual.get(line_mark)[y_mark + 5 - i][x_mark + i] = true;
        }
        vizual.get(line_mark)[y_mark + 6][x_mark] = true;

        x_mark+=7;
    }
    private void fill_8()
    {
        for(int i = 0; i < 3; i++)
        {
            vizual.get(line_mark)[y_mark][x_mark + 2 + i] = true;
            vizual.get(line_mark)[y_mark + 3][x_mark + 2 + i] = true;
            vizual.get(line_mark)[y_mark + 6][x_mark + 2 + i] = true;
        }
        for(int i = 0; i < 2; i++)
        {
            vizual.get(line_mark)[y_mark + i + 4][x_mark + 1] = true;
            vizual.get(line_mark)[y_mark + i + 4][x_mark + 5] = true;
            vizual.get(line_mark)[y_mark + i + 1][x_mark + 1] = true;
            vizual.get(line_mark)[y_mark + i + 1][x_mark + 5] = true;
        }
        x_mark+=7;
    }
    private void fill_9()
    {
        for(int i = 0; i < 4; i++)
        {
            vizual.get(line_mark)[y_mark][x_mark + 2 + i] = true;
            vizual.get(line_mark)[y_mark + 3][x_mark + 2 + i] = true;
        }
        for(int i = 0; i < 7; i++)
        {
            vizual.get(line_mark)[y_mark + i][x_mark + 5] = true;
        }
        vizual.get(line_mark)[y_mark + 1][x_mark + 1] = true;
        vizual.get(line_mark)[y_mark + 2][x_mark + 1] = true;

        x_mark+=7;
    }

    public void print_viz()
    {
        for(int i = 0; i < vizual.size(); i++)
        {
            for (int j = 0; j < vizual.get(i).length; j++)
            {
                for (int k = 0; k < vizual.get(i)[j].length; k++)
                {
                    if(vizual.get(i)[j][k] == true)
                        System.out.print('*');
                    else
                        System.out.print(' ');
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
