package test.pivotal.pal.tracker.controller;

import org.junit.jupiter.api.Test;
import io.pivotal.pal.tracker.controller.WelcomeController;
import static org.assertj.core.api.Assertions.assertThat;

public class WelcomeControllerTest {

    @Test
    public void itSaysHello() {
        WelcomeController controller = new WelcomeController("A welcome message");

        assertThat(controller.sayHello()).isEqualTo("A welcome message");
    }
}
