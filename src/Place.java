public class Place {
    private String name = "";
    private String state = "";
    private double latitude = 0.0;
    private double longitude = 0.0;
    private String zipCode = "";

    public Place(String name, String state, double latitude, double longitude, String zipCode) {
        setName(name);
        setState(state);
        setLatitude(latitude);
        setLongitude(longitude);
        setZipCode(zipCode);
    }
    public Place(String name, String state, String zipCode) {
        this(name, state, 0.0, 0.0, zipCode);
    }

    public boolean hasLocation() {
        return !(latitude == 0.0 && longitude == 0.0);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public double getLatitude() {
        if (hasLocation()) {
            return latitude;
        }
        return Double.NaN;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        if (hasLocation()) {
            return longitude;
        }
        return Double.NaN;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (Double.compare(place.latitude, latitude) != 0) return false;
        if (Double.compare(place.longitude, longitude) != 0) return false;
        if (name != null ? !name.equals(place.name) : place.name != null) return false;
        if (state != null ? !state.equals(place.state) : place.state != null) return false;
        return zipCode != null ? zipCode.equals(place.zipCode) : place.zipCode == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        if (hasLocation()) {
            result = String.format("%s, %s, %s (%f, %f)", name, state, zipCode, latitude, longitude);
        } else {
            result = String.format("%s, %s, %s", name, state, zipCode);
        }
        return result;
    }
}
