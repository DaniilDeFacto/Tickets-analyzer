package task.solution;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<Ticket> tickets = JsonReader.readTicketsFromJson("/tickets.json");
        Map<String, Duration> minFlightTimes = Analyzer.findMinFlightTimes(tickets, "VVO", "TLV");
        System.out.println("Минимальное время полета для каждого авиаперевозчика:");
        minFlightTimes.forEach((carrier, duration) -> System.out.println(carrier + ": "
                + duration.toHours() + " ч. "
                + duration.toMinutesPart() + " мин."));
        double priceDifference = Analyzer.calculatePriceDifference(tickets, "VVO", "TLV");
        System.out.println("Разница между средней ценой и медианой: " + priceDifference);
    }
}
