package co.develhope.customQueries.entities;

import co.develhope.customQueries.EnumFlightStatus;

import javax.persistence.*;

@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;
    private String fromAirport;
    private String toAirport;
    @Enumerated(EnumType.STRING)
    private EnumFlightStatus status;

    public Flight() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setStatus(EnumFlightStatus status) {
        this.status = status;
    }

    public EnumFlightStatus getStatus() {
        return status;
    }

    public Flight(String description, String fromAirport, String toAirport, EnumFlightStatus status) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }
}
