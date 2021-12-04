import java.util.Scanner;
public class DateAndTimeTest {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the date and time");
        System.out.print("Month: ");
        int month = input.nextInt();
        System.out.print("Day: ");
        int day = input.nextInt();
        System.out.print("Year: ");
        int year = input.nextInt();
        System.out.print("Hours: ");
        int hour = input.nextInt();
        System.out.print("Minutes: ");
        int minute = input.nextInt();
        System.out.print("Seconds: ");
        int seconds = input.nextInt();

        DateAndTime dateTime = new DateAndTime(month, day, year, hour, minute, seconds);

        int choise = getMenuChoise();

        while (choise != 7)
        {
            switch(choise)
            {
                case 1:
                    dateTime.tick();
                    break;

                case 2:
                    dateTime.incrementMinute();
                    break;

                case 3:
                    dateTime.incrementHour();
                    break;

                case 4:
                    dateTime.nextDay();
                    break;

                case 5:
                    dateTime.nextMonth();
                    break;

                case 6:
                    System.out.print("Enter seconds to tick: ");
                    int ticks = input.nextInt();

                    for (int i = 0; i < ticks; i++)
                         dateTime.tick();
                    break;
            }

            System.out.printf("Universal date and time: %s\n", dateTime.toUniversalString());
            System.out.printf("Standard date and time: %s\n", dateTime.toString());

            choise = getMenuChoise();
        }
    }

    private static int getMenuChoise()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Add 1 second");
        System.out.println("2 Add 1 Minute");
        System.out.println("3. Add 1 Hour");
        System.out.println("4. Add 1 Day");
        System.out.println("5. Add 1 Month");
        System.out.println("6. Add seconds");
        System.out.println("7. Exit");
        System.out.print("Choise: ");

        return input.nextInt();
    }
}
