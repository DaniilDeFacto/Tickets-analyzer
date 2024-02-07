package task.solution;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnalyzerTest {

    private static List<Ticket> tickets;

    @BeforeAll
    static void setup() {
        tickets = JsonReader.readTicketsFromJson("/tickets.json");
    }

    @Test
    void findMinFlightTimesTest() {
        var minFlightTimes = Analyzer.findMinFlightTimes(tickets, "VVO", "TLV");
        assertEquals(4, minFlightTimes.size());
        assertTrue(minFlightTimes.containsKey("TK"));
        assertTrue(minFlightTimes.containsKey("S7"));
        assertTrue(minFlightTimes.containsKey("SU"));
        assertTrue(minFlightTimes.containsKey("BA"));
        assertEquals(12, minFlightTimes.get("TK").toHours());
        assertEquals(13, minFlightTimes.get("S7").toHours());
        assertEquals(13, minFlightTimes.get("SU").toHours());
        assertEquals(15, minFlightTimes.get("BA").toHours());
    }

    @Test
    void calculatePriceDifferenceTest() {
        double priceDifference = Analyzer.calculatePriceDifference(tickets, "VVO", "TLV");
        assertEquals(460, priceDifference);
    }
}
