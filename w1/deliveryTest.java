
/**
 * OOP Java Project  WiSe 2024/2025
 * Problem: Postal Delivery
 * Link: https://open.kattis.com/contests/eo92fp/problems/delivery
 * @author Pham Minh Tuan Bui
 * @version 1.0, 24.10.2024

 * Method : Choose one direction, go to the furthest unfulfilled place and fulfill that, delivering excess on the way back. Repeat.
 * Status : 
 * Runtime: 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class deliveryTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        int locationCount = Integer.parseInt(temp[0]);
        int mailCapacity = Integer.parseInt(temp[1]);
        int[] locationCoord = new int[locationCount];
        int[] mailRequirement = new int[locationCount];
        int totalDistanceTravelled = 0;

        for (int i = 0; i < locationCount; i++) {
            temp = reader.readLine().split(" ");
            locationCoord[i] = Integer.parseInt(temp[0]);
            mailRequirement[i] = Integer.parseInt(temp[1]);
        }

        int lowestPositiveIndex = locationCount; // we know which index has lowest positive coordinate
        int remainingMailCapacity = mailCapacity;
        boolean hasDeliveredMail = false;

        for (int i = 0; i < locationCount; i++) {
            if (locationCoord[i] > 0) {
                lowestPositiveIndex = i;
                break;
            }

            if (remainingMailCapacity >= mailRequirement[i]) {
                if (!hasDeliveredMail) {
                    totalDistanceTravelled += Math.abs(locationCoord[i] * 2);
                    hasDeliveredMail = true;
                }

                if (remainingMailCapacity == mailRequirement[i]) {
                    remainingMailCapacity = mailCapacity;
                    hasDeliveredMail = false;
                }
                else {
                    remainingMailCapacity -= mailRequirement[i];
                }

                continue;
            }

            mailRequirement[i] -= remainingMailCapacity;
            int roundTripCount = Math.ceilDiv(mailRequirement[i], mailCapacity);
            
            if (!hasDeliveredMail) {
                roundTripCount += 1;
            }

            totalDistanceTravelled += Math.abs(locationCoord[i] * 2 * roundTripCount);
            int lastDeliveredAmount = mailRequirement[i] % mailCapacity;

            if (lastDeliveredAmount == 0) {
                remainingMailCapacity = mailCapacity;
                hasDeliveredMail = false;
                continue;
            }

            remainingMailCapacity = mailCapacity - lastDeliveredAmount;
            hasDeliveredMail = true;

        }

        hasDeliveredMail = false;
        remainingMailCapacity = mailCapacity;

        for (int i = locationCount - 1; i >= lowestPositiveIndex; i--) {
            if (remainingMailCapacity >= mailRequirement[i]) {
                if (!hasDeliveredMail) {
                    totalDistanceTravelled += locationCoord[i] * 2;
                    hasDeliveredMail = true;
                }

                if (remainingMailCapacity == mailRequirement[i]) {
                    remainingMailCapacity = mailCapacity;
                    hasDeliveredMail = false;
                }
                else {
                    remainingMailCapacity -= mailRequirement[i];
                }

                continue;
            }

            mailRequirement[i] -= remainingMailCapacity;
            int roundTripCount = Math.ceilDiv(mailRequirement[i], mailCapacity);
            
            if (!hasDeliveredMail) {
                roundTripCount += 1;
            }

            totalDistanceTravelled += locationCoord[i] * 2 * roundTripCount;
            int lastDeliveredAmount = mailRequirement[i] % mailCapacity;

            if (lastDeliveredAmount == 0) {
                remainingMailCapacity = mailCapacity;
                hasDeliveredMail = false;
                continue;
            }

            remainingMailCapacity = mailCapacity - lastDeliveredAmount;
            hasDeliveredMail = true;
        }

        System.out.println(totalDistanceTravelled);
    }
}
