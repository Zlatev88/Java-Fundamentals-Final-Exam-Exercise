package FinalExam;

import MethodsEx.CharactersInRange;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(password);

        while (!input.equals("Complete")) {

            String [] command = input.split(" ");

            if (command[0].equals("Make") && command[1].equals("Upper")) {
                int index = Integer.parseInt(command[2]);
                sb.setCharAt(index, (char) Character.toUpperCase(index));
                System.out.println(sb);


            }
            else if (command[0].equals("Insert")) {
                int index = Integer.parseInt(command[1]);
                char charToAdd = (char) Integer.parseInt(command[2]);
                sb.setCharAt(index, charToAdd);
                System.out.println(sb);


            }

            if (input.equals("Validation")) {


                if (password.length() < 8) {
                    System.out.println("Password must be at least 8 characters long!");
                }
                for (char symbol : password.toCharArray()) {

                    if (!Character.isLetterOrDigit(symbol) && symbol != '_') {
                        System.out.println("Password must consist only of letters, digits and _!");
                    }


                }


            }





            input = scanner.nextLine();
        }


    }
}
