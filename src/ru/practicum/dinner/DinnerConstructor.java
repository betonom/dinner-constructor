package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private HashMap<String, ArrayList<String>> dishes = new HashMap<>();

    public void saveDish(String dishType, String dishName){
        if (dishes.containsKey(dishType)){

            dishes.get(dishType).add(dishName);

        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);

            dishes.put(dishType, dishNames);
        }
    }
    public void createAndPrintRandomDishCombos(int numberOfCombos, ArrayList<String> dishTypes){
        Random random = new Random();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();

            for (String dishType : dishTypes) {
                ArrayList<String> dishesListFromType = dishes.get(dishType);

                combo.add(dishesListFromType.get(random.nextInt(dishesListFromType.size())));
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo);
        }
        System.out.println();
    }

    public boolean isDishTypeExist(String dishType){
        return dishes.containsKey(dishType);
    }

}
