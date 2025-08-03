package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch(command){
                case "1" -> addNewDish();

                case "2" -> generateDishCombo();

                case "3" -> System.out.println("До свидания!");

                default -> System.out.println("Такой команды нет!");
            }

            if(command.equals("3")){
                return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.saveDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> dishTypes = new ArrayList<>();
        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if(!dc.isDishTypeExist(nextItem)){
                System.out.println("Такого типа не существует. Введите сущестующий тип.");
                nextItem = scanner.nextLine();
                continue;
            }
            dishTypes.add(nextItem);

            nextItem = scanner.nextLine();
        }

        dc.printRandomDishCombos(numberOfCombos, dishTypes);


    }
}
