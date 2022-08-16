import java.util.ArrayList;

public class Model {

    //method that creates an array based on max number in the list
    static ArrayList getNumberArray(Integer maxNum) {
        ArrayList<Object> numberArray = new ArrayList<>();

        for(Integer i = 1; i < maxNum; i++) {
            numberArray.add(i);
        }
        return numberArray;
    }
}


