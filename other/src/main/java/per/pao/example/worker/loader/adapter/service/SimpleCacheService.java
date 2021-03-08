package per.pao.example.worker.loader.adapter.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SimpleCacheService {

    @Cacheable(cacheNames = "getTime")
    public Date getDate() {
        return new Date();
    }

    @Cacheable("currentTimeMillis")
    public Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public void demoCache() throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (int i = 0; i < 30; i++) {
            System.out.println(simpleDateFormat.format(getDate()));
            Thread.sleep(1000);
        }
    }
}
