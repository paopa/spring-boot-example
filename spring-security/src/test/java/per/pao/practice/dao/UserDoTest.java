package per.pao.practice.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDoTest {

    @Autowired
    private UserDo.UserRepository userRepository;

    @Test
    public void test() {
        UserDo user = userRepository.findById(1);
        Assertions.assertNotNull(user);
    }
}
