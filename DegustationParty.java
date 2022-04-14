package FinalExam;

import java.util.*;

public class DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        HashMap<String, List<String> meals = new LinkedHashMap<>();

        while(!input.equals("Stop")) {

            String []command = input.split("-");

            if (command[0].equals("Like")) {
                if (!meals.containsKey(command[1])) {
                    meals.put(command[1], Collections.singletonList(command[2]));
                }
            }






            input = scanner.nextLine();
        }
    }
}
