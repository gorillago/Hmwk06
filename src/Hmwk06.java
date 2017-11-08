import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hmwk06 {
    public static void main(String[] args) {
        ArrayList<Place> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        read("input.txt", list);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime + "ms");
        selectionSort(list);
        printSome(list, 10000);
    }

    public static void read(String fileName, ArrayList<Place> list) {
        File inputFile = new File(fileName);

        try {
            Scanner input = new Scanner(inputFile);
            if (input.hasNextLine()) {
                int n = 0;
                while(input.hasNextLine()) {
                    String line = input.nextLine();

                    Place place = textToPlace(line, n+1);
                    list.add(place);

                    n++;
                }
            } else {
                System.out.printf("File \"%s\" is empty.\n", fileName);
                System.exit(1);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.printf("File \"%s\" not found.\n", fileName);
            System.exit(1);
        }
    }

    public static Place textToPlace(String line, int lineNumber) {
        String[] data = line.split("\t");
        Place place = null;

        if (data.length == 3) {
            String zipCode = data[0];
            String name = data[1];
            String state = data[2];

            place = new Place(name, state, zipCode);

        } else if (data.length == 5) {
            String zipCode = data[0];
            double latitude = Double.NaN;
            double longitude = Double.NaN;
            String name = data[3];
            String state = data[4];

            if (isValidDouble(data[1])) {
                latitude = toDouble(data[1]);
            } else {
                System.out.printf("Line %d: \"%s\" \ncontains an invalid double. (%s is not a valid double.)",
                        lineNumber, line, data[1]);
                System.exit(1);
            }
            if (isValidDouble(data[2])) {
                longitude = toDouble(data[2]);
            } else {
                System.out.printf("Line %d: \"%s\" \ncontains an invalid double. (%s is not a valid double.)",
                        lineNumber, line, data[2]);
                System.exit(1);
            }

            place = new Place(name, state, latitude, longitude, zipCode);
        } else {
            System.out.printf("Line %d: \"%s\" \ndoes not contain 3 or 5 items. (Contains %d items)",
                    lineNumber, line, data.length);
            System.exit(1);
        }
        return place;
    }
    public static double toDouble(String input) {
        return Double.parseDouble(input);
    }
    public static boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void selectionSort(ArrayList<Place> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Place currentMin = list.get(i);
            int currentMinIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }

    public static void printSome(ArrayList<Place> list, int n) {
        n = (n <= 0) ? 1 : n;

        for (int i = 0; i < list.size(); i+=n) {
            System.out.println(list.get(i));
        }
    }
}
