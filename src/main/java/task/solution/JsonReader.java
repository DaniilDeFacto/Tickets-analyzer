package task.solution;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class JsonReader {
    public static List<Ticket> readTicketsFromJson(String jsonFilePath) {
        try (InputStream inputStream = JsonReader.class.getResourceAsStream(jsonFilePath)) {
            var objectMapper = new ObjectMapper();
            var jsonData = objectMapper.readValue(inputStream, JsonData.class);
            return jsonData.getTickets();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
