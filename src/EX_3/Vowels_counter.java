package EX_3;

import java.util.*;

public class Vowels_counter {
    //Сканнер для ввода значений
    protected Scanner scaner = new Scanner(System.in);

    //Переменные нужные для работы над словарем слов с количеством гласных букв
    private String text = "";
    private HashMap<String, Integer> words_vowels_cnt_dic = new HashMap<>();
    private ArrayList<Character> vowels = new ArrayList<>();
    //Конструктор
    public  Vowels_counter()
    {
        text = scaner.nextLine();
        vowels_fill();
        seperate_and_count_text();
    }

    //метод создающий массив гласных
    private void vowels_fill()
    {
        vowels.clear();
        vowels.add('я'); vowels.add('и'); vowels.add('ю'); vowels.add('э'); vowels.add('о');
        vowels.add('а'); vowels.add('ы'); vowels.add('у'); vowels.add('е'); vowels.add('ё');
    }

    //Метод создающий словарь
    private void seperate_and_count_text()
    {
        String[] words = text.split(" ");
        for(int i = 0; i < words.length; i++)
        {
            words_vowels_cnt_dic.put(words[i], count_vowels(words[i]));
        }
    }

    // Метод считающий гласные в словах
    private int count_vowels(String word)
    {
        int vwl_count = 0;
        word = word.toLowerCase(Locale.ROOT);
        for(int i = 0; i < word.length(); i++)
        {
            if(vowels.contains(word.charAt(i)))
                vwl_count++;
        }
        return vwl_count;
    }
    //Вывод слов
    public  void print_words()
    {
        System.out.println("Вывод слов и количества гласных в них");
        words_vowels_cnt_dic.entrySet().forEach(System.out::println);
        System.out.println();
    }
    //Вывод отсортированного словаря слов
    public void print_sorted_dic()
    {
        System.out.println("Слова отсортированные в порядке убывания количества по гласным в них");
        words_vowels_cnt_dic.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
        System.out.println();
    }
    //Метод делающий первую гласную в слове заглавной
    private String touppword(String word)
    {
        for(int i = 0; i < word.length(); i++)
        {
            if(vowels.contains(Character.toLowerCase(word.charAt(i))))
                return word.substring(0, i) +
                        Character.toUpperCase(word.charAt(i)) +
                        word.substring(i + 1, word.length());
        }
        return word;
    }
    //Метод собирающий текст в слова с первыми гласными заглавными
    private StringBuilder transform_text()
    {
        StringBuilder line = new StringBuilder();
        String[] words = text.split(" ");
        for(int i = 0; i < words.length; i++)
        {
            line.append(touppword(words[i]) + " ");
        }
        return line;
    }
    //Вывод такого текста
    public void print_upper_first()
    {
        System.out.println("Текст со словами где первые гласные заглавные \n" + transform_text() + '\n');
    }

}
