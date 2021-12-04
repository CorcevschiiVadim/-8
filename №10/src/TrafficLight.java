public enum TrafficLight {
    RED(50),
    GREEN(40),
    YELLOW(5);

    private final int duration;

    TrafficLight(int durationSeconds)
    {
        duration = durationSeconds;
    }

    public int getDuration()
    {
        return duration;
    }
}
