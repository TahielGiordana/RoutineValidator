package services;

import java.util.HashSet;

public class RoutineFinder {
    public static HashSet<String> findRoutine(String userName){
        //TODO
        HashSet<String> exercises = new HashSet<>();
        exercises.add("BicicletaFija");
        exercises.add("Abdominales");
        exercises.add("Dominadas");
        exercises.add("Sentadillas");
        return exercises;
    }
}