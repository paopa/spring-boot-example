package per.pao.example.worker.encrypt;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BCryptWorker {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encrypt(String password) {
        return encoder.encode(password);
    }

    public boolean match(String password, String hashedPassword) {
        return encoder.matches(password, hashedPassword);
    }
}
