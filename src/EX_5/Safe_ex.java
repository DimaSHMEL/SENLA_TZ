package EX_5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Item {
    private final String name; //название вещи
    private final int weight; //вес
    private final int price; //стоимость

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
class Safe {
    private Item[] items;
    private int price;

    public Safe(Item[] items, int price) {
        this.items = items;
        this.price = price;
    }

    public Item[] getItems() {
        return items;
    }

    public int getPrice() {
        return price;
    }

    //Описание состояния рюкзака
    public String getDescription() {
        return items == null ? "" : Arrays.stream(items).map(Item::getName).collect(Collectors.joining("+")) + "-" + getPrice();
    }
}

public class Safe_ex {
    public static void main(String[] args) {
        int n, k;
        Scanner scaner = new Scanner(System.in);
        n = Integer.parseInt(scaner.nextLine().split(" ")[0]);
        Item[] items = new Item[n];
        for(int i = 0; i < n; i++)
        {
            String[] data = scaner.nextLine().split(" ");
            items[i] = new Item(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        }
        k = scaner.nextInt();
        Safe[][] sf = new Safe[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (i == 0 || j == 0) { //нулевую строку и столбец заполняем нулями
                    sf[i][j] = new Safe(new Item[]{}, 0);
                } else if (i == 1) {
                    /*первая строка заполняется просто: первый предмет кладём или не кладём в зависимости от веса*/
                    sf[1][j] = items[0].getWeight() <= j ? new Safe(new Item[]{items[0]}, items[0].getPrice())
                            : new Safe(new Item[]{}, 0);
                } else {
                    if (items[i - 1].getWeight() > j) //если очередной предмет не влезает в рюкзак,
                        sf[i][j] = sf[i - 1][j];    //записываем предыдущий максимум
                    else {
                        /*рассчитаем цену очередного предмета + максимальную цену для (максимально возможный для рюкзака вес − вес предмета)*/
                        int newPrice = items[i - 1].getPrice() + sf[i - 1][j - items[i - 1].getWeight()].getPrice();
                        if (sf[i - 1][j].getPrice() > newPrice) //если предыдущий максимум больше
                            sf[i][j] = sf[i - 1][j]; //запишем его
                        else {
                            /*иначе фиксируем новый максимум: текущий предмет + стоимость свободного пространства*/
                            sf[i][j] = new Safe(Stream.concat(Arrays.stream(new Item[]{items[i - 1]}),
                                    Arrays.stream(sf[i - 1][j - items[i - 1].getWeight()].getItems())).toArray(Item[]::new), newPrice);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                System.out.print(sf[i][j].getDescription() + " ");
            }
            System.out.print("\n");
        }
    }
}
