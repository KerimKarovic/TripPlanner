public class Destination {
    private String name;
    private double distance; // Distance from Zivinice in km
    private int minutes;     // Time traveled from Zivinice in minutes

    public Destination(String name, double distance, int minutes) {
        this.name = name;
        this.distance = distance;
        this.minutes = minutes;
    }

    public String getDestination() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public int getMinutes() {
        return minutes;
    }
}
