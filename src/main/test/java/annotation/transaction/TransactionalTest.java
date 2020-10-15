package annotation.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import per.pao.example.Application;
import per.pao.example.dao.jpa.SimpleRepository;
import per.pao.example.entity.SimpleDo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionalTest {

    @Autowired
    private SimpleRepository simpleRepository;

    @Test
    @Transactional
//    @Rollback(false)
    public void testTransactionalAnnotation() {
        demo();
    }

    public void demo() {
        try {
            SimpleDo simpleDo = simpleRepository.findById(43L).orElse(generateSimpleDo("david_real_1", 25));
            simpleDo.setAge(simpleDo.getAge() + 1);
            simpleRepository.save(simpleDo);
            throwException();
//            throwRuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("roll back");
    }

    private void throwRuntimeException() {
        throw new RuntimeException("exception test");
    }

    private void throwException() throws Exception {
        throw new Exception("exception test");
    }

    private SimpleDo generateSimpleDo(String name, int age) {
        SimpleDo simpleDo = new SimpleDo();
        simpleDo.setName(name);
        simpleDo.setAge(age);
        return simpleDo;
    }
}
