package task.solution;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyzer {
    public static Map<String, Duration> findMinFlightTimes(List<Ticket> tickets, String origin, String destination) {
        tickets = tickets.stream()
                .filter(ticket -> ticket.getOrigin().equals(origin) && ticket.getDestination().equals(destination))
                .collect(Collectors.toList());
        Map<String, Duration> minFlightTimes = new HashMap<>();
        for (Ticket ticket : tickets) {
            var carrier = ticket.getCarrier();
            var flightDuration = Duration.between(ticket.getDepartureDateTime(), ticket.getArrivalDateTime());
            var currentMinDuration = minFlightTimes.getOrDefault(carrier, Duration.ofDays(365));
            if (flightDuration.compareTo(currentMinDuration) < 0) {
                minFlightTimes.put(carrier, flightDuration);
            }
        }
        return minFlightTimes;
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
