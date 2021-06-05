package per.pao.practice.service;

import org.springframework.stereotype.Service;

@Service
public class Math {
    public int add(int i1, int i2) {
        return i1 + i2;
    }

    public int subtract(int i1, int i2) {
        return i1 - i2;
    }

    public int multiply(int i1, int i2) {
        return i1 * i2;
    }

    public int divide(int i1, int i2) {
        return i1 / i2;
    }
}
