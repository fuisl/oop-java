
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class notamused {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> customers = new HashMap<>();
        int day = 1;
        String currentLine;  // Should be OPEN

        while ((currentLine = reader.readLine()) != null) {

            // print the day
            if (currentLine.equals("OPEN")) {
                System.out.println("Day " + day);
                day++;
                continue;
            } else if (currentLine.equals("CLOSE")) {
                // sort the customers by name and print the price
                List<String> keys = new ArrayList<>(customers.keySet());
                Collections.sort(keys);
                for (String key : keys) {
                    System.out.printf("%s $%.2f%n", key, customers.get(key) * 0.10);
                }
                System.out.println();

                // BUG: reset customers data
                customers.clear();
                continue;
            }

            // calculate time
            String[] line = currentLine.split(" ");
            if (line[0].equals("ENTER")) {
                customers.put(line[1], Integer.parseInt(line[2]) - customers.getOrDefault(line[1], 0));
            } else if (line[0].equals("EXIT")) {
                customers.put(line[1], (Integer.parseInt(line[2]) - customers.get(line[1])));
            }

        }
    }
}
