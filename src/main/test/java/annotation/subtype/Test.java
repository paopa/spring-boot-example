package annotation.subtype;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.reflections.Reflections;
import per.pao.example.pojo.Input;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() throws InterruptedException {
        String jsonA = "{\"type\":\"a\",\"a\":\"100\"}";
        ObjectMapper mapper = new ObjectMapper();
        new Reflections("per.pao.example.pojo.")
                .getTypesAnnotatedWith(JsonTypeName.class)
                .forEach(mapper::registerSubtypes);

        try {
            Input.AInput input = (Input.AInput) mapper.readValue(jsonA, Input.class);
            System.out.println(input);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String jsonB = "{\"type\":\"b\",\"b\":\"999\"}";
        try {
            Input.BInput input = (Input.BInput) mapper.readValue(jsonB, Input.class);
            System.out.println(input);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
