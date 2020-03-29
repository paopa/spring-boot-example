package pers.paopa.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.paopa.springboot.demo.service.mail.MailServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class MailServiceTest {

    @Autowired
    private MailServiceImpl mailService;

    @Test
    public void testSend() {
        String to = "david840422@gmail.com";
        String subject = "標題"+new Date();
        String text = "<h1>內文<h1>";
        mailService.send(to,subject,text);
    }

    @Test
    public void testTemplateSend() throws Exception {
        String to = "david840422@gmail.com";
        Map<String, Object> model = new HashMap<>();
        model.put("username", "David");
        model.put("templateType", "Freemarker");
        mailService.sendTemplateFreemarker(to, "Springboot Mail(Template)", model, "simple.html");
    }
}
