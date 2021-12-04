public class Time2 {
    private int hour;
    private int minute;
    private int second;

    public Time2() {
        this(0, 0, 0);
    }

    public Time2(int secondsPassed) {
        if (secondsPassed <= 0) {
            throw new IllegalArgumentException("Колличество прошедших секунд не может быть отрицательным!");
        }

        this.second = secondsPassed % 60;
        this.minute = secondsPassed / 60 % 60;
        this.hour = (secondsPassed / 60 / 60 % 60 >= 24) ? 0 : secondsPassed / 60 / 60 % 60;
    }

    public Time2(int час, int минута, int секунда) {
        if (час < 0 || час >= 24)
            throw new IllegalArgumentException("Час должен быть 0 - 23");

        if (минута < 0 || минута >= 60)
            throw new IllegalArgumentException("Минуты должны быть 0 - 59");

        if (секунда < 0 || секунда >= 60)
            throw new IllegalArgumentException("Секунда должна быть 0 - 59");

        this.hour = час;
        this.minute = минута;
        this.second = секунда;
    }

    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    public void Time2(int час, int минута, int секунда) {
        if (час < 0 || час >= 24)
            throw new IllegalArgumentException("Час должен быть 0 - 23");

        if (минута < 0 || минута >= 60)
            throw new IllegalArgumentException("Минуты должны быть 0 - 59");

        if (секунда < 0 || секунда >= 60)
            throw new IllegalArgumentException("Секунда должна быть 0 - 59");

        this.hour = час;
        this.minute = минута;
        this.second = секунда;
    }

    public void setHour(int час) {
        if (час < 0 || час >= 24)
            throw new IllegalArgumentException("Час должен быть 0 - 23");

        this.hour = час;
    }

    public void setMinute(int минута) {
        if (минута < 0 || минута >= 60)
            throw new IllegalArgumentException("Минуты должны быть от 0 - 59");

        this.minute = минута;
    }

    public void setSecond(int секунда) {
        if (секунда < 0 || секунда >= 60)
            throw new IllegalArgumentException("Секунда должна быть 0 - 59");

        this.second = секунда;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    public String toString() {
        return String.format("%d:%02d:%02d%s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }

    public void tick() {
        if (second + 1 < 60)
            second++;
        else if (second + 1 == 60) {
            second = 0;
            this.incrementMinute();
        }
    }

    public void incrementMinute() {
        if (minute + 1 < 60)
            minute++;
        else if (minute + 1 == 60) {
            minute  = 0;
            this.incrementHour();
        }
    }

    public void incrementHour() {
        if (hour + 1 < 24)
            hour++;
        else if (hour + 1 == 24) {
            hour = 0;
        }
    }
}


