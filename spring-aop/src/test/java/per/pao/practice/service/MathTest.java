package per.pao.practice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathTest {

    @Autowired
    private Math math;

    @Test
    @DisplayName("add test")
    public void add() {
        int expect = 3;
        int actual = this.math.add(1, 2);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("subtract test")
    public void subtract() {
        int expect = 1;
        int actual = this.math.subtract(2, 1);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("multiply test")
    public void multiply() {
        int expect = 4;
        int actual = this.math.multiply(2, 2);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("divide test")
    public void divide() {
        int expect = 2;
        int actual = this.math.divide(4, 2);
        Assertions.assertEquals(expect, actual);
    }
}
