package task.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonReaderTest {
    @Test
    void readTicketsFromJsonTest() {
        var tickets = JsonReader.readTicketsFromJson("/tickets.json");
        assertEquals(12, tickets.size());
    }
}
