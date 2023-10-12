import java.util.Random;
public class Program {

    /*
    a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
    b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
    поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    c. Для хранения фруктов внутри коробки можно использовать ArrayList;
    d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
    вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
    e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
    подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
    Можно сравнивать коробки с яблоками и апельсинами;
    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
    g. Не забываем про метод добавления фрукта в коробку.

    Формат сдачи: ссылка на гитхаб проект
        * */
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();

        for(int i=0;i<new Random().nextInt(100);i++) box1.addFruit(new Orange());
        System.out.printf("В коробке 1 у нас %d фруктов типа %s\n", box1.getQuantity(),box1.boxtype);
        for(int i=0;i<new Random().nextInt(100);i++) box2.addFruit(new Apple());
        System.out.printf("В коробке 2 у нас %d фруктов типа %s\n", box2.getQuantity(),box2.boxtype);
        System.out.println("Добавим яблоко в коробку 1?");
        box1.addFruit(new Apple());
        System.out.println("А апельсин?");
        box1.addFruit(new Orange());
        System.out.printf("В коробке 1 у нас %d фруктов типа %s\n", box1.getQuantity(),box1.boxtype);
        System.out.println("Пересыпем все из коробки 1 в коробку 3");
        box1.spillTo(box3);
        System.out.printf("В коробке 1 у нас %d фруктов типа %s\n", box1.getQuantity(),box1.boxtype);
        System.out.printf("В коробке 3 у нас %d фруктов типа %s\n", box3.getQuantity(),box3.boxtype);
        System.out.println("Сравним коробки 2 и 3:");
        System.out.println(box2.compare(box3)?"Коробки равны":"Коробки не равны");
        Box box4 = box3.copy();
        System.out.println("Сравним коробки 4 и 3:");
        System.out.println(box4.compare(box3)?"Коробки равны":"Коробки не равны");
    }

}
