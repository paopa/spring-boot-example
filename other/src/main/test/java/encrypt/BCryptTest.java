package encrypt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.pao.example.Application;
import per.pao.example.worker.encrypt.BCryptWorker;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BCryptTest {

    @Autowired
    private BCryptWorker bCryptWorker;

    @Test
    public void encryptTest() {

        List<String> encryptList = new ArrayList<>();
        int i = 0;
        while (i < 10) {
            String hashedPassword = bCryptWorker.encrypt("123456");
            System.out.println(hashedPassword);
            encryptList.add(hashedPassword);
            i++;
        }

        for (String password : encryptList) {
            boolean flag = bCryptWorker.match("123456", password);
            System.out.println(flag);
        }

    }
}
