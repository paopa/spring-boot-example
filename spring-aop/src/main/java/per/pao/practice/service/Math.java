package per.pao.practice.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Math {

    public int add(int i1, int i2) {
        log.info("do add method");
        return i1 + i2;
    }

    public int subtract(int i1, int i2) {
        log.info("do subtract method");
        return i1 - i2;
    }

    @SneakyThrows
    public int multiply(int i1, int i2) {
        log.info("do multiply method");
        Thread.sleep(2000);
        return i1 * i2;
    }

    public int divide(int i1, int i2) {
        log.info("do divide method");
        return i1 / i2;
    }

    public double pow(double i1, int i2) {
        return java.lang.Math.pow(i1, i2);
    }
}
