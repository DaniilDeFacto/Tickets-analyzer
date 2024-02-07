package test.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Ticket {
    private String origin;

    @JsonProperty("origin_name")
    private String originName;

    private String destination;

    @JsonProperty("destination_name")
    private String destinationName;

    @JsonProperty("departure_date")
    private String departureDate;

    @JsonProperty("departure_time")
    private String departureTime;

    @JsonProperty("arrival_date")
    private String arrivalDate;

    @JsonProperty("arrival_time")
    private String arrivalTime;

    private String carrier;

    private int stops;

    private double price;

    public ZonedDateTime getDepartureDateTime() {
        var dateTimeStr = departureDate + " " + departureTime;
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        var dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        var zoneId = ZoneId.of(TimeZone.IDS.get(originName));
        return dateTime.atZone(zoneId);
    }

    public ZonedDateTime getArrivalDateTime() {
        var dateTimeStr = arrivalDate + " " + arrivalTime;
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        var dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        var zoneId = ZoneId.of(TimeZone.IDS.get(destinationName));
        return dateTime.atZone(zoneId);
    }
}

