package jackson.subtype.entity;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.pao.example.Application;
import per.pao.example.dao.jpa.JsonTRepository;
import per.pao.example.entity.JsonT;
import per.pao.example.pojo.Input;
import per.pao.example.util.InputAdapter;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test {

    @Autowired
    private JsonTRepository jsonTRepository;

    @BeforeEach
    public void setup() {
        JsonT jsonT = new JsonT();
        Input.AInput aInput = new Input.AInput();
        aInput.setType("a");
        aInput.setA("123");
        jsonT.setContent(aInput);
        jsonTRepository.save(jsonT);
    }

    @org.junit.jupiter.api.Test
    public void test() throws Exception {
        JsonT jsonT = jsonTRepository.findAll().get(0);
        Input.AInput xx = InputAdapter.to(jsonT.getContent(), Input.AInput.class);
        System.out.println(xx);
    }
}
