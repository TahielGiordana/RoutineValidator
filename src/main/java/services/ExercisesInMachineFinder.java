package services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ExercisesInMachineFinder {
    public static HashSet<String> findExercises(String machineCode){
        JSONParser parser = new JSONParser();
        HashSet<String> exercises = new HashSet<>();
        try{
            File file = new File("");
            String path = file.getAbsolutePath() + File.separator + "files" + File.separator + "ExercisesByMachine.json";
            System.out.println("Se buscan Ejercicios por Maquina en: " + path);

            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
            for(Object jsonEntry : jsonArray){
                JSONObject machine = (JSONObject) jsonEntry;

                if(machine.get("machineCode").toString().equals(machineCode)){
                    exercises = new HashSet<>((JSONArray) machine.get("exercises"));
                }
            }

        } catch (IOException | ParseException e) {
            System.out.println("error al obtener ejericios: " + e.getMessage());
        }

        System.out.println("La maquina "+machineCode+" permite hacer: "+exercises);
        return exercises;
    }
}