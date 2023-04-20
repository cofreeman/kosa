package week7.day4;

import java.time.LocalDateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingApp {

    public static void main(String[] args) {
        ApplicationContext factory
            = new ClassPathXmlApplicationContext("exam1.xml");
        LocalDateTime localDateTime = (LocalDateTime) factory.getBean("localDateTime");
        int hour = localDateTime.getHour();
        if (isWithinHours(hour, 6, 12)) {
            Greeting morningGreeting = (Greeting) factory.getBean(
                "morningGreeting");
            morningGreeting.greet();
        } else if (isWithinHours(hour, 12, 17)) {
            Greeting afternoonGreeting = (Greeting) factory.getBean(
                "afternoonGreeting");
            afternoonGreeting.greet();
        } else if (isWithinHours(hour, 17, 22)) {
            Greeting eveningGreeting = (Greeting) factory.getBean(
                "eveningGreeting");
            eveningGreeting.greet();
        } else {
            Greeting nightGreeting = (Greeting) factory.getBean(
                "nightGreeting");
            nightGreeting.greet();
        }
        ((ClassPathXmlApplicationContext) factory).close();
    }

    private static boolean isWithinHours(int targetHour, int startHour, int endHour) {
        return targetHour >= startHour && targetHour < endHour;
    }

}
