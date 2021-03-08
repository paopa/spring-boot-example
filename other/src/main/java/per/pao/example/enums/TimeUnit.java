package per.pao.example.enums;

public enum TimeUnit {
    Second(1_000),
    Minute(60_000),
    Hour(3_600_000);

    public long millis;

    TimeUnit(long millis) {
        this.millis = millis;
    }
}
