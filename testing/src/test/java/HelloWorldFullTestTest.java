import com.example.SpringBootApp4Testing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alex on 1/22/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , classes = SpringBootApp4Testing.class
)
public class HelloWorldFullTestTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void exampleTest() {
        String body = testRestTemplate.getForObject("/sayHello?name=World", String.class);
        assertThat(body).isEqualTo("Hello, World");
    }
}