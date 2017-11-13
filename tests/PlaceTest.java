import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {
    private Place test1 = null;
    private Place test2 = null;
    private Place test3 = null;
    private Place test4 = null;
    private Place test5 = null;
    private Place test6 = null;
    private final double DELTA = 0.0001;

    @Before
    public void beforeEach() {
        test1 = new Place("KINGSVILLE", "OH", 41.9, -80.69, "44068");
        test2 = new Place("CORPUS CHRISTI", "TX", 27.8, -97.39, "78403");
        test3 = new Place("KASIGLUK", "AK", 60.87, -162.51, "99609");
        test4 = new Place("LIMA", "OH", "45807");
        test5 = new Place("HILLS", "TX", "78659");
        test6 = new Place("PIOPOLIS", "IL", "62859");
    }
    @Test
    public void hasLocation() throws Exception {
        assertTrue(test1.hasLocation());
        assertTrue(test2.hasLocation());
        assertTrue(test3.hasLocation());
        assertFalse(test4.hasLocation());
        assertFalse(test5.hasLocation());
        assertFalse(test6.hasLocation());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("KINGSVILLE", test1.getName());
        assertEquals("CORPUS CHRISTI", test2.getName());
        assertEquals("KASIGLUK", test3.getName());
        assertEquals("LIMA", test4.getName());
        assertEquals("HILLS", test5.getName());
        assertEquals("PIOPOLIS", test6.getName());
    }

    @Test
    public void setName() throws Exception {
        test1.setName("test1");
        test2.setName("test2");
        test3.setName("test3");
        test4.setName("test4");
        test5.setName("test5");
        test6.setName("test6");

        assertEquals("test1", test1.getName());
        assertEquals("test2", test2.getName());
        assertEquals("test3", test3.getName());
        assertEquals("test4", test4.getName());
        assertEquals("test5", test5.getName());
        assertEquals("test6", test6.getName());
    }

    @Test
    public void getState() throws Exception {
        assertEquals("OH", test1.getState());
        assertEquals("TX", test2.getState());
        assertEquals("AK", test3.getState());
        assertEquals("OH", test4.getState());
        assertEquals("TX", test5.getState());
        assertEquals("IL", test6.getState());
    }

    @Test
    public void setState() throws Exception {
        test1.setState("test1");
        test2.setState("test2");
        test3.setState("test3");
        test4.setState("test4");
        test5.setState("test5");
        test6.setState("test6");

        assertEquals("test1", test1.getState());
        assertEquals("test2", test2.getState());
        assertEquals("test3", test3.getState());
        assertEquals("test4", test4.getState());
        assertEquals("test5", test5.getState());
        assertEquals("test6", test6.getState());
    }

    @Test
    public void getLatitude() throws Exception {
        assertEquals(41.9, test1.getLatitude(), DELTA);
        assertEquals(27.8, test2.getLatitude(), DELTA);
        assertEquals(60.87, test3.getLatitude(), DELTA);
        assertEquals(Double.NaN, test4.getLatitude(), DELTA);
        assertEquals(Double.NaN, test5.getLatitude(), DELTA);
        assertEquals(Double.NaN, test6.getLatitude(), DELTA);
    }

    @Test
    public void setLatitude() throws Exception {
        test1.setLatitude(0.1);
        test2.setLatitude(0.2);
        test3.setLatitude(0.3);
        test4.setLatitude(0.4);
        test5.setLatitude(0.5);
        test6.setLatitude(0.6);

        assertEquals(0.1, test1.getLatitude(), DELTA);
        assertEquals(0.2, test2.getLatitude(), DELTA);
        assertEquals(0.3, test3.getLatitude(), DELTA);
        assertEquals(0.4, test4.getLatitude(), DELTA);
        assertEquals(0.5, test5.getLatitude(), DELTA);
        assertEquals(0.6, test6.getLatitude(), DELTA);
    }

    @Test
    public void getLongitute() throws Exception {
        assertEquals(-80.69, test1.getLongitude(), DELTA);
        assertEquals(-97.39, test2.getLongitude(), DELTA);
        assertEquals(-162.51, test3.getLongitude(), DELTA);
        assertEquals(Double.NaN, test4.getLongitude(), DELTA);
        assertEquals(Double.NaN, test5.getLongitude(), DELTA);
        assertEquals(Double.NaN, test6.getLongitude(), DELTA);
    }

    @Test
    public void setLongitute() throws Exception {
        test1.setLongitude(0.1);
        test2.setLongitude(0.2);
        test3.setLongitude(0.3);
        test4.setLongitude(0.4);
        test5.setLongitude(0.5);
        test6.setLongitude(0.6);

        assertEquals(0.1, test1.getLongitude(), DELTA);
        assertEquals(0.2, test2.getLongitude(), DELTA);
        assertEquals(0.3, test3.getLongitude(), DELTA);
        assertEquals(0.4, test4.getLongitude(), DELTA);
        assertEquals(0.5, test5.getLongitude(), DELTA);
        assertEquals(0.6, test6.getLongitude(), DELTA);
    }

    @Test
    public void getZipCode() throws Exception {
        assertEquals("44068", test1.getZipCode());
        assertEquals("78403", test2.getZipCode());
        assertEquals("99609", test3.getZipCode());
        assertEquals("45807", test4.getZipCode());
        assertEquals("78659", test5.getZipCode());
        assertEquals("62859", test6.getZipCode());
    }

    @Test
    public void setZipCode() throws Exception {
        test1.setZipCode("11111");
        test2.setZipCode("22222");
        test3.setZipCode("33333");
        test4.setZipCode("44444");
        test5.setZipCode("55555");
        test6.setZipCode("66666");

        assertEquals("11111", test1.getZipCode());
        assertEquals("22222", test2.getZipCode());
        assertEquals("33333", test3.getZipCode());
        assertEquals("44444", test4.getZipCode());
        assertEquals("55555", test5.getZipCode());
        assertEquals("66666", test6.getZipCode());
    }

    @Test
    public void equals() throws Exception {
        Place place1 = new Place("TESTING", "TE", 10.0, 20.0, "12345");
        Place place2 = new Place("TESTING", "TE", 10.0, 20.0, "12345");

        assertTrue(place1.equals(place2));
        assertFalse(place1.equals(test1));
    }

    @Test
    public void testHashCode() throws Exception {
        assertEquals(-1477276389, test1.hashCode());
        assertEquals(67517675, test2.hashCode());
        assertEquals(590224230, test3.hashCode());
        assertEquals(2062092534, test4.hashCode());
        assertEquals(-1795583225, test5.hashCode());
        assertEquals(-537338754, test6.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        String result1 = "KINGSVILLE, OH, 44068 (41.900000, -80.690000)";
        String result2 = "CORPUS CHRISTI, TX, 78403 (27.800000, -97.390000)";
        String result3 = "KASIGLUK, AK, 99609 (60.870000, -162.510000)";
        String result4 = "LIMA, OH, 45807";
        String result5 = "HILLS, TX, 78659";
        String result6 = "PIOPOLIS, IL, 62859";

        assertEquals(result1, test1.toString());
        assertEquals(result2, test2.toString());
        assertEquals(result3, test3.toString());
        assertEquals(result4, test4.toString());
        assertEquals(result5, test5.toString());
        assertEquals(result6, test6.toString());
    }

    @Test
    public void testCompareTo() throws Exception{
        assertEquals(-5, test1.compareTo(test2));
        assertEquals(19, test2.compareTo(test3));
        assertEquals(-14, test3.compareTo(test4));
        assertEquals(-5, test4.compareTo(test5));
        assertEquals(11, test5.compareTo(test6));
        assertEquals(-6, test6.compareTo(test1));

        assertEquals(-1, test1.compareTo(test4));

        assertEquals(0, test1.compareTo(test1));
        assertEquals(0, test2.compareTo(test2));
        assertEquals(0, test3.compareTo(test3));
        assertEquals(0, test4.compareTo(test4));
        assertEquals(0, test5.compareTo(test5));
        assertEquals(0, test6.compareTo(test6));
    }
}