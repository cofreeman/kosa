package week7.day5;

import java.time.LocalDateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingApp {

    public static void main(String[] args) {
        ApplicationContext factory
            = new ClassPathXmlApplicationContext("exam3.xml");
        LocalDateTime localDateTime = factory.getBean("localDateTime",LocalDateTime.class);
        int hour = localDateTime.getHour();

        if (isWithinHours(hour, 6, 12)) {
            MorningGreetingImpl morningGreetingImpl = factory.getBean("morningGreetingImpl",
                MorningGreetingImpl.class);
            morningGreetingImpl.greet();
        } else if (isWithinHours(hour, 12, 17)) {
            AfternoonGreetingImpl afternoonGreeting = factory.getBean("afternoonGreetingImpl",
                AfternoonGreetingImpl.class);
            afternoonGreeting.greet();
        } else if (isWithinHours(hour, 17, 22)) {
            EveningGreetingImpl eveningGreeting = factory.getBean("eveningGreetingImpl",
                EveningGreetingImpl.class);
            eveningGreeting.greet();
        } else {
            NightGreetingImpl nightGreeting = factory.getBean("nightGreetingImpl",
                NightGreetingImpl.class);
            nightGreeting.greet();
        }
        ((ClassPathXmlApplicationContext) factory).close();
    }

    private static boolean isWithinHours(int targetHour, int startHour, int endHour) {
        return targetHour >= startHour && targetHour < endHour;
    }

}
