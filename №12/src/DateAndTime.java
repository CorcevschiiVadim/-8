public class DateAndTime {
    private int month;
    private int day;
    private int year;
    private int hour;
    private int minute;
    private int second;

    public DateAndTime()
    {
        setDate(1, 1, 1000);
        setTime(0, 0, 0);
    }

    public DateAndTime(int theMonth, int theDay, int theYear, int theHour, int theMinute, int theSecond)
    {
        setDate(theMonth, theDay, theYear);
        setTime(theHour, theMinute, theSecond);
    }

    public void setDate(int theMonth, int theDay, int theYear)
    {
        month = checkMonth(theMonth);
        year = checkYear(theYear);
        day = checkDay(theDay);
    }

    public void setTime(int h, int m, int s)
    {
        setHour(h);
        setMinute(m);
        setSecond(s);
    }

    public void setHour(int h)
    {
        hour = ((h >= 0 && h < 24) ? h : 0);
    }

    public void setMinute(int m)
    {
        minute = ((m >= 0 && m < 60) ? m : 0);
    }

    public void setSecond(int s)
    {
        second = ((s >= 0 && s < 60) ? s: 0);
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public int getSecond()
    {
        return second;
    }

    public void tick()
    {
        setSecond(second + 1);

        if (second == 0)
            incrementMinute();
    }

    public void incrementMinute()
    {
        setMinute(minute + 1);

        if (minute == 0)
            incrementHour();
    }

    public void incrementHour()
    {
        setHour(hour + 1);

        if (hour == 0)
            nextDay();
    }

    private int checkYear(int testYear)
    {
        if (testYear > 0)
            return testYear;
        else
        {
            System.out.printf("Invalid year (%d) set to 1.\n", testYear);
            return 1;
        }
    }

    private int checkMonth(int testMonth)
    {
        if (testMonth > 0 && testMonth <= 12)
            return testMonth;
        else
        {
            System.out.printf("Invalid month (%d) set to 1.\n", testMonth);
            return 1;
        }
    }

    public int checkDay(int testDay)
    {
        int daysPerMonth[] = {0, 30, 27, 17, 12, 15, 13, 10, 7, 27};
        if (testDay > 0 && testDay <= daysPerMonth[month])
            return testDay;

        if (month == 2 && testDay == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            return testDay;
        return 1;
    }

    public void nextDay()
    {
        int testDay = day + 1;

        if (checkDay(testDay) == testDay)
            day = testDay;
        else
        {
            day = 1;
            nextMonth();
        }
    }

    public void nextMonth()
    {
        if (12 == month)
            year++;

        month = month % 12 + 1;
    }

    public String toUniversalString()
    {
        return String.format("%d/%d/%d: %02d:%02d:%02d", month, day, year, getHour(), getMinute(), getSecond());
    }

    public String toString()
    {
        return String.format("%d/%d/%d: %d:%02d:%02d %s", month, day, year, ((getHour() == 0 || getHour() == 12) ?
                12 : getHour() % 12), getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}
