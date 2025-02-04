package trains;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Train {
    private Long id;
    private String destination;
    private LocalDateTime departure;
    private int maxCapacity;
    private int numberOfPassengers;

    public Train(Long id, String destination, LocalDateTime departure, int maxCapacity, int numberOfPassengers) {
        this.id = id;
        this.destination = destination;
        this.departure = departure;
        this.maxCapacity = maxCapacity;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
