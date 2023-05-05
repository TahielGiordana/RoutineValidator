package services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class RoutineFinder {
    public static HashSet<String> findRoutine(String userName){
        JSONParser parser = new JSONParser();
        HashSet<String> exercises = new HashSet<>();
        try{
            File file = new File("");
            String path = file.getAbsolutePath() + File.separator + "files" + File.separator + "UsersRoutine.json";
            System.out.println("Se buscan Rutinas de Usuarios en: " + path);

            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
            for(Object jsonEntry : jsonArray){
                JSONObject user = (JSONObject) jsonEntry;

                if(user.get("username").toString().equals(userName)){
                    exercises = new HashSet<>((JSONArray) user.get("routine"));
                }
            }

        } catch (IOException | ParseException e) {

        }

        System.out.println("Rutina de "+userName+" : " + exercises);
        return exercises;
    }
}