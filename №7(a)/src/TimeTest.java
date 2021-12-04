import java.util.Scanner;
public class TimeTest {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        Time2 time = new Time2();

        System.out.println("Enter the time");
        System.out.print("Hours: ");
        time.setHour(input.nextInt());
        System.out.print("Minutes: ");
        time.setMinute(input.nextInt());
        System.out.print("Seconds: ");
        time.setSecond(input.nextInt());

        int choise = getMenuChoise();

        while(choise != 5)
        {
            switch(choise)
            {
                case 1:
                    time.tick();
                    break;

                case 2:
                    time.incrementMinute();
                    break;

                case 3:
                    time.incrementHour();
                    break;

                case 4:
                    System.out.print("Enter seconds to tick: ");
                    int ticks = input.nextInt();

                    for (int i = 0; i < ticks; i++)
                        time.tick();
                    break;
            }

            System.out.printf("Hour: %d Minute: %d Second: %d\n", time.getHour(), time.getMinute(), time.getSecond());
            System.out.printf("Universal time: %s Standard time: %s\n", time.toUniversalString(), time.toString());

            choise = getMenuChoise();
        }
    }

    private static int getMenuChoise()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("1. Add 1 second");
        System.out.println("2. Add 1 minute");
        System.out.println("3. Add 1 hour");
        System.out.println("4. Add seconds");
        System.out.println("5. Exit");
        System.out.println("Choise: ");

        return input.nextInt();
    }
}
