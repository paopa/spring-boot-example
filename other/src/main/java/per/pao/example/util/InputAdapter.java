package per.pao.example.util;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.reflections.Reflections;

public class InputAdapter {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        new Reflections("per.pao.example.pojo.")
                .getTypesAnnotatedWith(JsonTypeName.class)
                .forEach(mapper::registerSubtypes);
    }

    public static <T> T to(Object object, Class<T> valueType)
            throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(object),valueType);
    }
}
