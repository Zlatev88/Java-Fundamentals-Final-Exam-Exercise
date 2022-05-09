import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        HashMap<String, List<Integer>> cities = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String [] commandLine = input.split("\\|\\|");
            String city = commandLine[0];
            int population = Integer.parseInt(commandLine[1]);
            int gold = Integer.parseInt(commandLine[2]);

            if (!cities.containsKey(city)) {

            List<Integer> citiesInfo = new ArrayList<>();

            citiesInfo.add(population);
            citiesInfo.add(gold);

            cities.put(city, citiesInfo);

            }

            else {

                int newPopulation = cities.get(city).get(0) + population;
                int newGold = cities.get(city).get(1) + gold;

                cities.get(city).set(0,newPopulation);
                cities.get(city).set(1, newGold);


            }


            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("End")) {

            String [] commandLine = input2.split("=>");

            String command = commandLine[0];

            if (command.equals("Plunder")) {

                String town = commandLine[1];
                int people = Integer.parseInt(commandLine[2]);
                int gold = Integer.parseInt(commandLine[3]);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                int newPeople = cities.get(town).get(0)-people;
                int newGold = cities.get(town).get(1)-gold;

                if (newPeople<=0 || newGold<=0) {
                    cities.remove(town);

                    System.out.printf("%s has been wiped off the map!%n", town);
                }
                else {cities.get(town).set(0,newPeople);
                    cities.get(town).set(1,newGold);
                }


            }

            else if (command.equals("Prosper")) {
                String town = commandLine[1];
                int gold = Integer.parseInt(commandLine[2]);

                if (gold<0) {

                    System.out.printf("Gold added cannot be a negative number!%n");
                }

                else {

                    int newGold= cities.get(town).get(1)+gold;
                    cities.get(town).set(1,newGold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold,town, cities.get(town).get(1));
                }

            }





            input2 = scanner.nextLine();
        }
        int count=0;
        for(String element: cities.keySet()) {
            count++;
        }

        if (count<=0) {
            System.out.printf("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
        else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", count);
        }

        cities.entrySet()
                .stream()

                .forEach(g -> System.out.println(String.format
                        ("%s -> Population: %d citizens, Gold: %d kg", g.getKey(), g.getValue().get(0), g.getValue().get(1))));

    }
}
