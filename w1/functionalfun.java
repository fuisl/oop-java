
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class functionalfun {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            HashMap<String, Boolean> domainCheck = new HashMap<>();
            HashMap<String, Boolean> codomainCheck = new HashMap<>();

            // read the domain and codomain
            for (String element : currentLine.split(" ")) {
                domainCheck.put(element, false);
            }

            String[] codomain = reader.readLine().split(" ");
            for (String element : codomain) {
                codomainCheck.put(element, false);
            }

            // read the number of pairs
            int numPairs = Integer.parseInt(reader.readLine());

            // tracking variables
            boolean isFunction = true;
            boolean injective = true;
            boolean surjective = false;
            int countUnique = 0;

            for (int i = 0; i < numPairs; i++) {
                // read the pair
                String[] pair = reader.readLine().split(" -> ");
                String domainElement = pair[0];
                String codomainElement = pair[1];

                // check if in domain and codomain
                if (domainCheck.containsKey(domainElement)) {
                    if (domainCheck.get(domainElement)) {
                        isFunction = false;

                        // skip the rest of the pairs # BUG FIX
                        for (int k = i; k < numPairs - 1; k++) {
                            reader.readLine();
                        }
                        break;
                    } else {
                        domainCheck.put(domainElement, true);
                    }

                    if (!codomainCheck.containsKey(codomainElement)) {
                        isFunction = false;
                        // skip the rest of the pairs # BUG FIX
                        for (int k = i; k < numPairs - 1; k++) {
                            reader.readLine();
                        }
                        break;
                    }

                    // check if injective and surjective
                    if (!codomainCheck.get(codomainElement)) {
                        codomainCheck.put(codomainElement, true);
                        countUnique++;
                    } else {
                        injective = false;
                    }

                    if (countUnique == (codomain.length - 1)) {
                        surjective = true;
                    }
                }
            }

            // print the result
            if (!isFunction) {
                System.out.println("not a function");
            } else if (injective && surjective) {
                System.out.println("bijective");
            } else if (injective) {
                System.out.println("injective");
            } else if (surjective) {
                System.out.println("surjective");
            } else {
                System.out.println("neither injective nor surjective");
            }
        }
    }
}
