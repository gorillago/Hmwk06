import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Hmwk06Test {
    final double DELTA = .0001;

    @Test
    public void read() throws Exception {
        final String fileName = "tests/testInput.txt";
        ArrayList<Place> list = new ArrayList<>();
        Hmwk06.read(fileName, list);

        assertTrue(list.get(0).getName().equals("KINGSVILLE"));
        assertTrue(list.get(1).getState().equals("TX"));
        assertTrue(list.get(2).getZipCode().equals("99609"));
        assertEquals(40.79, list.get(3).getLatitude(), DELTA);
        assertEquals(-97.11, list.get(4).getLongitude(), DELTA);
        assertEquals(20, list.size());
    }

    @Test
    public void textToPlace() throws Exception {
        String testText1 = "44068\t41.9\t-80.69\tKINGSVILLE\tOH";
        String testText2 = "78403\tCORPUS CHRISTI\tTX";

        Place testPlace1 = Hmwk06.textToPlace(testText1, 1);
        Place testPlace2 = Hmwk06.textToPlace(testText2, 2);

        assertTrue(testPlace1.getZipCode().equals("44068"));
        assertEquals(41.9, testPlace1.getLatitude(), DELTA);
        assertEquals(-80.69, testPlace1.getLongitude(), DELTA);
        assertTrue(testPlace1.getName().equals("KINGSVILLE"));
        assertTrue(testPlace1.getState().equals("OH"));

        assertTrue(testPlace2.getZipCode().equals("78403"));
        assertEquals(Double.NaN, testPlace2.getLatitude(), DELTA);
        assertEquals(Double.NaN, testPlace2.getLongitude(), DELTA);
        assertTrue(testPlace2.getName().equals("CORPUS CHRISTI"));
        assertTrue(testPlace2.getState().equals("TX"));
    }

    @Test
    public void toDouble() throws Exception {
        assertEquals(4.2, Hmwk06.toDouble("4.2"), DELTA);
        assertEquals(0, Hmwk06.toDouble("0"), DELTA);
        assertEquals(3, Hmwk06.toDouble("3"), DELTA);
        assertEquals(-3.2, Hmwk06.toDouble("-3.2"), DELTA);
        assertEquals(42, Hmwk06.toDouble("42"), DELTA);
        assertEquals(-503, Hmwk06.toDouble("-503"), DELTA);
    }

    @Test
    public void isValidDouble() throws Exception {
        assertTrue(Hmwk06.isValidDouble("4.2"));
        assertTrue(Hmwk06.isValidDouble("0"));
        assertTrue(Hmwk06.isValidDouble("3"));
        assertFalse(Hmwk06.isValidDouble("a"));
        assertFalse(Hmwk06.isValidDouble("a.3"));
    }

    @Test
    public void selectionSort() throws Exception {
        Place test1 = new Place("KINGSVILLE", "OH", 41.9, -80.69, "44068");
        Place test2 = new Place("CORPUS CHRISTI", "TX", 27.8, -97.39, "78403");
        Place test3 = new Place("KASIGLUK", "AK", 60.87, -162.51, "99609");
        Place test4 = new Place("LIMA", "OH", "45807");
        Place test5 = new Place("HILLS", "TX", "78659");
        Place test6 = new Place("PIOPOLIS", "IL", "62859");

        ArrayList<Place> list = new ArrayList<>();

        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        list.add(test6);

        Hmwk06.selectionSort(list);

        assertEquals("KASIGLUK", list.get(0).getName());
        assertEquals("PIOPOLIS", list.get(1).getName());
        assertEquals("KINGSVILLE", list.get(2).getName());
        assertEquals("LIMA", list.get(3).getName());
        assertEquals("CORPUS CHRISTI", list.get(4).getName());
        assertEquals("HILLS", list.get(5).getName());
    }
}