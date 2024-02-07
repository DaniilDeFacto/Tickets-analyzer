package task.solution;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyzer {
    public static Map<String, Duration> findMinFlightTimes(List<Ticket> tickets, String origin, String destination) {
        Map<String, Duration> minFlightTimes = new HashMap<>();
        for (Ticket ticket : tickets) {
            if (ticket.getOrigin().equals(origin) && ticket.getDestination().equals(destination)) {
                var carrier = ticket.getCarrier();
                var departureDateTime = getDateTime(ticket.getOriginName(),
                        ticket.getDepartureDate(), ticket.getDepartureTime());
                var arrivalDateTime = getDateTime(ticket.getDestinationName(),
                        ticket.getArrivalDate(), ticket.getArrivalTime());
                var flightDuration = Duration.between(departureDateTime, arrivalDateTime);
                var currentMinDuration = minFlightTimes.getOrDefault(carrier, Duration.ofDays(365));
                if (flightDuration.compareTo(currentMinDuration) < 0) {
                    minFlightTimes.put(carrier, flightDuration);
                }
            }
        }
        return minFlightTimes;
    }

    public static ZonedDateTime getDateTime(String name, String date, String time) {
        var dateTimeStr = date + " " + time;
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        var dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        var zoneId = ZoneId.of(TimeZone.IDS.get(name));
        return dateTime.atZone(zoneId);
    }

    public static double calculatePriceDifference(List<Ticket> tickets, String origin, String destination) {
        var prices = tickets.stream()
                .filter(ticket -> ticket.getOrigin().equals(origin) && ticket.getDestination().equals(destination))
                .map(Ticket::getPrice)
                .sorted()
                .collect(Collectors.toList());
        var averagePrice = prices.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
        var medianPrice = calculateMedian(prices);
        return averagePrice - medianPrice;
    }

    public static double calculateMedian(List<Double> list) {
        int size = list.size();
        if (size % 2 == 0) {
            return Stream.of(list.get(size / 2), list.get(size / 2 - 1))
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);
        } else {
            return list.get(size / 2);
        }
    }
}
