package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private HashMap<String, ArrayList<String>> dishes = new HashMap<>();

    public void saveDish(String dishType, String dishName){

        ArrayList<String> dishNames = new ArrayList<>();

        if (dishes.containsKey(dishType)){
            dishNames = dishes.get(dishType);

            if (dishNames.contains(dishName)){
                System.out.println("Такое блюдо уже есть!");
                return;
            }

            dishNames.add(dishName);

        } else {
            dishNames.add(dishName);

            dishes.put(dishType, dishNames);
        }
    }
    public void printRandomDishCombos(int numberOfCombos, ArrayList<String> dishTypes){


        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(generateRandomCombo(dishTypes));
        }
        System.out.println();
    }

    public boolean isDishTypeExist(String dishType){
        return dishes.containsKey(dishType);
    }

    private ArrayList<String> generateRandomCombo (ArrayList<String> dishTypes){
        Random random = new Random();
        ArrayList<String> combo = new ArrayList<>();

        for (String dishType : dishTypes) {
            ArrayList<String> dishNames = dishes.get(dishType);

            combo.add(dishNames.get(random.nextInt(dishNames.size())));
        }
        return combo;
    }

}
