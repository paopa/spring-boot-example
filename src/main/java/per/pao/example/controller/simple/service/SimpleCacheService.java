package per.pao.example.controller.simple.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SimpleCacheService {

    @Cacheable(cacheNames = "getTime")
    public Date getDate(){
        return new Date();
    }

    @Cacheable("currentTimeMillis")
    public Long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }
}
