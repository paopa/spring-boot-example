package per.pao.example.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String message;
    private long index;
    private long created;

    public Message(String message) {
        this(message, 0);
    }

    public Message(String message, long index) {
        this(message, index, Instant.now().getEpochSecond());
    }
}
