package week7.day5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NightGreetingImpl implements Greeting {
    @Autowired
    @Qualifier("nightGreet")
    String message;

    @Override
    public void greet() {
        System.out.println(message);
    }
}
