package per.pao.example.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String origin;
    private String interaction;
    private long index;
    private long created;

    public Message(String origin, String interaction) {
        this(origin, interaction, 0);
    }

    public Message(String origin, String interaction, long index) {
        this(origin, interaction, index, Instant.now().getEpochSecond());
    }
}
