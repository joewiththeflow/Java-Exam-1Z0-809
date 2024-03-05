package Chapter9_Streams.Questions;

public class Temperature {
    String location;
    Double temp;

    public Temperature(String location, Double temp) {
        this.location = location;
        this.temp = temp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "July average temp at " + location + " was " + temp;
    }
}
