import java.util.ArrayList;
import java.util.Collections;

public class Service {
    static String fiveNumbersAndMultiplier() {
        ArrayList fiveNumbers;
        fiveNumbers = Model.getNumberArray(69);
        String outputFiveNumbeers = getNumbers(fiveNumbers, 5);

        ArrayList multiplierNumber= Model.getNumberArray(1);
        String outputMultiplierNumbeer = getNumbers(multiplierNumber, 5);

        String str = outputFiveNumbeers + " Multiplier:" + outputMultiplierNumbeer;
        return str;
    }


    static String getNumbers(ArrayList numberArray, Integer num) {
        String stringOfNumbers = null;
        Collections.shuffle(numberArray);
        for (Integer i =0; i < (num-1); i++){
            stringOfNumbers += " " + Integer.toString((Integer)numberArray.get(i)) + " ";
        }
        return stringOfNumbers;
    }
}
