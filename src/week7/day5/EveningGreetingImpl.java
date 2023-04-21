package week7.day5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EveningGreetingImpl implements Greeting {
    @Autowired
    @Qualifier("eveningGreet")
    String message;

    @Override
    public void greet() {
        System.out.println(message);
    }
}
