import interfaces.Validator;
import services.ExercisesInMachineFinder;
import services.RoutineFinder;

import java.util.HashSet;

public class RoutineValidator implements Validator {
    public boolean validate(String username, String codeMachine){
        HashSet<String> userExercises = RoutineFinder.findRoutine(username);
        HashSet<String> possibleExercisesInMachine = ExercisesInMachineFinder.findExercises(codeMachine);
        for(String userExercise : userExercises){
            if(possibleExercisesInMachine.contains(userExercise)){
                return true;
            }
        }
        return false;
    };

    public static void main(String[] args){
        RoutineValidator validator = new RoutineValidator();
        System.out.println(validator.validate("Tahiel", "A1"));
    }
}
