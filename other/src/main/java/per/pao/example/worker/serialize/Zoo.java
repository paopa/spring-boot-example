package per.pao.example.worker.serialize;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Zoo {
    public Animal animal;

    /**
     * if not specified name at JsonSubTypes.Type annotation
     * can binding name via JsonTypeName annotation
     */
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.WRAPPER_OBJECT,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Zoo.Dog.class),
            @JsonSubTypes.Type(value = Zoo.Cat.class)
    })
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Animal {
        public String name;
    }

    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @JsonTypeName("dog")
    @NoArgsConstructor
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @JsonTypeName("cat")
    @NoArgsConstructor
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }

}

class Test {
    public static void main(String[] args) throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo zoo = new Zoo(dog);
        ObjectMapper mapper = new ObjectMapper();
        mapper.readerFor(Zoo.class);
        String result = mapper.writeValueAsString(zoo);
        System.out.println(result);
        Zoo animal = mapper.readValue(result, Zoo.class);
        System.out.println(animal);
    }
}