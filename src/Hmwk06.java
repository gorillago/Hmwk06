import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hmwk06 {
    public static void main(String[] args) {
        final int LIMIT = 100;
        Place[] list = new Place[LIMIT];
        int n = read("input.txt", list, LIMIT);
        for (int i = 0; i < n; i++) {
            System.out.println(list[i]);
        }
    }

    public static int read(String fileName, Place[] list, int limit) {
        File inputFile = new File(fileName);
        int n = 0;

        try {
            Scanner input = new Scanner(inputFile);
            if (input.hasNextLine()) {
                while(input.hasNextLine() && n < limit) {
                    String line = input.nextLine();

                    Place place = textToPlace(line, n+1);
                    list[n] = place;

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
        return n;
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
}
