package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcard {

    static class Fruit {
        int number;
    }

    static class Citrus extends Fruit {
        int number;
    }

    static class Orange extends Citrus {
        int number;
    }

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Citrus citrus = new Citrus();
        Orange orange = new Orange();

        Fruit fruitOrange = new Orange();
        Citrus citrusOrange = new Orange();

        List<Fruit> fruitsExample = new ArrayList<>();
        List<Citrus> citrusesExample = new ArrayList<>();

        // citruses = fruits; NO

        // Могут быть ошибки ClassCastException в runtime. В памяти реально лежит объект Citrus, а ты говоришь JVM: "считай это Orange". JVM проверяет и кидает исключение 🚫.
        // orange = (Orange) citrus;
        // Orange orangeOrange = (Orange) fruitsExample.get(0);

        // Good
        Citrus citrusGood = new Orange();
        Orange orangeGood = (Orange) citrusGood; // OK

        // fruits = citruses; NO !!!!! WILDCARD

        // Good
        //Fruit fruitCitruses = citrusesExample.get(0);


        //------------------
        List<Fruit> fruits = new ArrayList<>(Arrays.asList(new Fruit[]{new Fruit(), new Fruit(), new Fruit()}));
        List<Citrus> citruses = new ArrayList<>(Arrays.asList(new Citrus[]{new Citrus(), new Citrus()}));
        List<Orange> oranges = new ArrayList<>(Arrays.asList(new Orange[]{new Orange(), new Orange()}));

        getFruit(oranges); // Только oranges

        getFruitWld(citruses);
        getFruitWld(oranges);
      //  getFruitWld(fruits); нельзя передать так как ? extends Citrus верхняя граница

        addFruitWldMedium(new ArrayList<>(List.of(new Object())));
        addFruitWldMedium(fruits);
        addFruitWldMedium(citruses);
       // addFruitWldMedium(oranges); ? super Citrus нижняя граница

    }

    // Good
    public static void getFruit(List<Orange> oranges) {
        for (int i = 0, orangesSize = oranges.size(); i < orangesSize; i++) {
            Fruit orange = oranges.get(i);
            System.out.println(orange);
            orange.number = orange.number + 1;
        }
    }

    public static void getFruitWld(List<? extends Citrus> citruses) {
        for (int i = 0, orangesSize = citruses.size(); i < orangesSize; i++) {
            Citrus citrus = citruses.get(i);
            Fruit fruit = citruses.get(i);
           // Orange orange = (Orange) oranges.get(i); если приходит массив List<Orange> то ок, иначе ClassCastExc
            System.out.println(fruit);
            fruit.number = fruit.number + 1;
        }
    }

    public static void addFruitWldFull(List<? super Fruit> fruit) {
        for (int i = 0, orangesSize = fruit.size(); i < orangesSize; i++) {
            fruit.add(new Citrus());
            fruit.add(new Orange());
            fruit.add(new Fruit());
            System.out.println(fruit);
        }
    }

    public static void addFruitWldMedium(List<? super Citrus> citruses) {
        for (int i = 0, orangesSize = citruses.size(); i < orangesSize; i++) {
            citruses.add(new Citrus());
            citruses.add(new Orange());
           // citruses.add(new Fruit()); НЕЛЬЗЯ передать потому что может прийти список Citrus на вход
            System.out.println(citruses);
        }
    }



}
